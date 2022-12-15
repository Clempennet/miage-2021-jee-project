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

        //Appel un groupe d'ascenseur
        from("jms:" + jmsPrefix + "ascenseurR")
                .bean(ascenseurGateway, "sendEtageActuelR");

        from("jms:" + jmsPrefix + "ascenseurJ")
                .bean(ascenseurGateway, "sendEtageActuelJ");

        from("jms:" + jmsPrefix + "ascenseurV")
                .bean(ascenseurGateway, "sendEtageActuelV");



        from("jms:" + jmsPrefix + "entrer")
                .bean(ascenseurGateway, "entrer");

        from("direct:entrer")
                .to("jms:topic:" + jmsPrefix + "entrer");


        from("jms:" + jmsPrefix + "select")
                .bean(ascenseurService, "select");


        from("direct:open")
                .to("jms:topic:" + jmsPrefix + "open");



        from("jms:" + jmsPrefix + "move")
                .bean(ascenseurService, "move");;


        from("direct:sortir")
                .to("jms:topic:" + jmsPrefix + "sortir");

        from("jms:" + jmsPrefix + "fin")
                .bean(ascenseurGateway, "fin");

        from("direct:fin")
                .to("jms:topic:" + jmsPrefix + "fin");

        from("jms:" + jmsPrefix + "getAscenseur")
                .bean(ascenseurService, "getAscenseur");


        from("direct:getAscenseur")
                .to("jms:topic:" + jmsPrefix + "getAscenseur");

        from("direct:error")
                .to("jms:topic:" + jmsPrefix + "error");

        from("jms:" + jmsPrefix + "repair")
                .bean(ascenseurService, "repair");


        from("direct:technicien")
                .to("jms:topic:" + jmsPrefix + "repair");

        from("direct:alert")
                .to("jms:topic:" + jmsPrefix + "alert");

        from("direct:isOpen")
                .to("jms:topic:" + jmsPrefix + "isOpen");


        from("direct:ticketCancel")
                .marshal().json()
                .to("jms:topic:" + jmsPrefix + "cancellation");


    }

}
