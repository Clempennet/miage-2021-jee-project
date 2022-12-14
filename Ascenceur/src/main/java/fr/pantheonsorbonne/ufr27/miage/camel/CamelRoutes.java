package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.service.ReportService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    @Inject
    ReportService reportService;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("direct:technician")
                .marshal().json()
                .to("jms:"+jmsPrefix+"repair");

        from("cron:tab?schedule=0/* * * 15 * * *")
                .bean(reportService, "sendReport()");

        from("direct:report")
                .marshal().json()
                .to("jms:"+jmsPrefix+"report");
    }

}
