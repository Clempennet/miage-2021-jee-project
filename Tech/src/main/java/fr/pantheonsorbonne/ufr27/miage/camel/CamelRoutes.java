package fr.pantheonsorbonne.ufr27.miage.camel;



import fr.pantheonsorbonne.ufr27.miage.service.techService;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    techGateway techGateway;

    @Inject
    techService techService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:" + jmsPrefix + "error")
                .bean(techService, "error");

        from("direct:repair")
                .to("jms:" + jmsPrefix + "repair");

    }
}