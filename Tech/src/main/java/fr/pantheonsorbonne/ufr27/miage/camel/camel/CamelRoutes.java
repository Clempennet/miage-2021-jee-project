package fr.pantheonsorbonne.ufr27.miage.camel.camel;

import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("jms:queue/miage.MATHIKARAN.repair")
                .choice()
                .when(header("GrpAscenseur").isEqualTo("R"))
                .to("file:data/rouge")
                .when(header("GrpAscenseur").isEqualTo(("V")))
                .to("file:data/vert")
                .when(header("GrpAscenseur").isEqualTo("J"))
                .to("file:data/jaune");
    }
}
