package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.service.AppelerAscenseur;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    grpAscenseurGateway grpAscenseurGateway;

    @Inject
    AppelerAscenseur appelerAscenseur;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        //Appel un groupe d'ascenseur
        from("direct:callR")
                .to("jms:" + jmsPrefix + "ascenseurR");

        from("direct:callJ")
                .to("jms:" + jmsPrefix + "ascenseurJ");

        from("direct:callV")
                .to("jms:" + jmsPrefix + "ascenseurV");



        from("direct:entrer")
                .to("jms:" + jmsPrefix + "entrer");


        from("direct:fin")
                .to("jms:" + jmsPrefix + "fin");



        from("direct:select")
                .to("jms:" + jmsPrefix + "select");

        from("jms:" + jmsPrefix + "porte")
                .bean(appelerAscenseur, "portee");


        from("direct:porte")
                .to("jms:" + jmsPrefix + "porte");




        from("direct:move")
                .to("jms:" + jmsPrefix + "move");









      /*  onException(ExpiredTransitionalTicketException.class)
                .handled(true)
                .process(new ExpiredTransitionalTicketProcessor())
                .setHeader("success", simple("false"))
                .log("Clearning expired transitional ticket ${body}")
                .bean(ticketingService, "cleanUpTransitionalTicket");

        onException(UnsuficientQuotaForVenueException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("Vendor has not enough quota for this venue"));


        onException(NoSuchTicketException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("Ticket has expired"));

        onException(CustomerNotFoundException.NoSeatAvailableException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("No seat is available"));


        from("jms:" + jmsPrefix + "booking?exchangePattern=InOut")//
                .log("ticker received: ${in.headers}")//
                .unmarshal().json(Booking.class)//
                .bean(bookingHandler, "book").marshal().json()
        ;


        from("jms:" + jmsPrefix + "ticket?exchangePattern=InOut")
                .unmarshal().json(ETicket.class)
                .bean(ticketingService, "emitTicket").marshal().json();


        from("direct:ticketCancel")
                .marshal().json()
                .to("jms:topic:" + jmsPrefix + "cancellation");
*/
    }

    public class nearAggregatorStrategy implements AggregationStrategy {

        public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            // the first time we only have the new exchange
            if (oldExchange == null) {
                return newExchange;
            }

            if (oldExchange.getMessage().getBody(int.class) < newExchange.getMessage().getBody(int.class)) {
                return oldExchange;
            } else {
                return newExchange;
            }
        }
    }
}
