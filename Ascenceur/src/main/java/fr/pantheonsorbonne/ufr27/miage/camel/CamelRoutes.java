package fr.pantheonsorbonne.ufr27.miage.camel;
import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
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
    AscenseurService ascenseurService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:" + jmsPrefix + "ascenseur1?exchangePattern=InOut")//
                .setBody(constant("1"))
                .bean(ascenseurGateway, "sendEtageActuel1");

        from("jms:" + jmsPrefix + "ascenseur2?exchangePattern=InOut")//
                .setBody(constant("1"))
                .bean(ascenseurGateway, "sendEtageActuel2");

        from("jms:" + jmsPrefix + "ascenseur3?exchangePattern=InOut")//
                .setBody(constant("1"))
                .bean(ascenseurGateway, "sendEtageActuel3");

        from("jms:" + jmsPrefix + "ascenseur4?exchangePattern=InOut")//
                .setBody(constant("1"))
                .bean(ascenseurGateway, "sendEtageActuel4");

        from("jms:" + jmsPrefix + "ascenseur5?exchangePattern=InOut")//
                .setBody(constant("1"))
                .bean(ascenseurGateway, "sendEtageActuel5");



        from("direct:etageActuel1")
                .to("jms:topic:" + jmsPrefix + "gather");

        from("direct:etageActuel2")
                .to("jms:topic:" + jmsPrefix + "gather");

        from("direct:etageActuel3")
                .to("jms:topic:" + jmsPrefix + "gather");

        from("direct:etageActuel4")
                .to("jms:topic:" + jmsPrefix + "gather");

        from("direct:etageActuel5")
                .to("jms:topic:" + jmsPrefix + "gather");


        from("jms:" + jmsPrefix + "move?exchangePattern=InOut")
                .bean(ascenseurService, "move");;



        from("direct:technicien")
                .to("jms:topic:" + jmsPrefix + "repair");

        from("direct:alert")
                .to("jms:topic:" + jmsPrefix + "alert");


        from("direct:ticketCancel")
                .marshal().json()
                .to("jms:topic:" + jmsPrefix + "cancellation");

    }

}
