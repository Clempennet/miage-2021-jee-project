package fr.pantheonsorbonne.ufr27.miage.camel;



import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;



    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);


        from("jms:queue:" + jmsPrefix + "repair")//
                .choice()
                .when(header("GrpAscenseur").isEqualTo("R"))
                .to("file:data/rouge")
                .when(header("GrpAscenseur").isEqualTo(("V")))
                .to("file:data/vert")
                .when(header("GrpAscenseur").isEqualTo("J"))
                .to("file:data/jaune")
                .log("error received:"+ LocalDate.now());


        from("jms:queue:" + jmsPrefix + "report")
                .to("file:data/report")
                .log("report received : "+ LocalDate.now());

    }


}
