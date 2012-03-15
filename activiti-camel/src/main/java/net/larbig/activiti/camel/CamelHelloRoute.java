package net.larbig.activiti.camel;

import org.apache.camel.builder.RouteBuilder;

public class CamelHelloRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("activiti:camelProcessName:serviceTask1")
				.setBody()
				.property("var1")
				.setBody()
				.constant("ala")
				.to("log:service1 ##############################################");

		from("direct:start")
				.to("log:directStart ##############################################")
				.to("activiti:camelProcessName");

		from("direct:receive")
				.to("log:directReceive ##############################################")
				.to("activiti:camelProcessName:waitState");

	}

}
