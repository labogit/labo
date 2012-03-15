package net.larbig.activiti.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class CamelHelloRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    from("activemq:in.create")
        .log(LoggingLevel.INFO, "Received message ${body}")
        .to("activiti:helloCamelProcess")
        .log(LoggingLevel.INFO, "Received message ${body}")
        .to("activemq:out.create");
    
    from("activiti:helloCamelProcess:serviceTask1")
        .log(LoggingLevel.INFO, "Received message on service task ${property.var1}")
        .setProperty("var2").constant("world")
        .setBody().properties();
  }

}
