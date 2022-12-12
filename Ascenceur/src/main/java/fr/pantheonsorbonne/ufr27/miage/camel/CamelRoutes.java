package fr.pantheonsorbonne.ufr27.miage.camel;
import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
import fr.pantheonsorbonne.ufr27.miage.exception.HsException;
import fr.pantheonsorbonne.ufr27.miage.service.AscenseurService;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;


    @Inject
    AscenseurGateway ascenseurGateway;

    @Inject
    TechGateway techGateway;

    @Inject
    AscenseurService ascenseurService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:" + jmsPrefix + "ascenseurR")
                .bean(ascenseurGateway, "sendEtageActuelR");

        from("jms:" + jmsPrefix + "ascenseurJ")
                .bean(ascenseurGateway, "sendEtageActuelJ");

        from("jms:" + jmsPrefix + "ascenseurV")
                .bean(ascenseurGateway, "sendEtageActuelV");


        from("jms:" + jmsPrefix + "move")
                .bean(ascenseurService, "move");

        onException(HsException.class)
                .bean(techGateway, "sendHsAlert");


        from("direct:technicien")
                .marshal().json()
                .to("jms:queue/miage.MATHIKARAN.repair");

        from("direct:alert")
                .to("jms:topic:" + jmsPrefix + "alert");

        from("direct:isOpen")
                .to("jms:topic:" + jmsPrefix + "isOpen");


        from("direct:ticketCancel")
                .marshal().json()
                .to("jms:topic:" + jmsPrefix + "cancellation");


    }


}
