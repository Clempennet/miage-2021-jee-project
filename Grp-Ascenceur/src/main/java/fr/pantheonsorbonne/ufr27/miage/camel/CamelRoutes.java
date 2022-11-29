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

        from("direct:callR")
                .multicast()
                .to("jms:" + jmsPrefix + "ascenseur1?exchangePattern=InOut")
                .to("jms:" + jmsPrefix + "ascenseur2?exchangePattern=InOut")
                .to("jms:" + jmsPrefix + "ascenseur3?exchangePattern=InOut")
                .to("jms:" + jmsPrefix + "ascenseur4?exchangePattern=InOut")
                .to("jms:" + jmsPrefix + "ascenseur5?exchangePattern=InOut");


        from("jms:" + jmsPrefix + "gather")
                .aggregate(new nearAggregatorStrategy())
                .header("etage")
                .completionTimeout(1000L)
                .bean(grpAscenseurGateway, "move");

        from("direct:move")
                .to("jms:" + jmsPrefix + "move?exchangePattern=InOut");

        from("jms:" + jmsPrefix + "alert")
                .bean(appelerAscenseur,"alert");







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
