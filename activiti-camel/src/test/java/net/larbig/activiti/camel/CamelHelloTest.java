package net.larbig.activiti.camel;

import java.util.Collections;

import org.activiti.camel.ActivitiProducer;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CamelHelloTest {

	@Test
	public void runMyTest() throws Exception {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:application-context.xml");
		CamelContext ctx = applicationContext.getBean(CamelContext.class);
		ProducerTemplate tpl = ctx.createProducerTemplate();
		System.out.println("############### Send a direct:start event to start Process");
		tpl.sendBodyAndProperty("direct:start",	Collections.singletonMap("var1", "ala"), ActivitiProducer.PROCESS_KEY_PROPERTY, "key1");
		String instanceId = (String) tpl.requestBody("direct:start", Collections.singletonMap("var1", "ala"));
		System.out.println("################ Wait for reply for Instance " + instanceId);
		Thread.sleep(10000);
		System.out.println("################ Send a direct:receive event to continue");
		tpl.sendBodyAndProperty("direct:receive", null,ActivitiProducer.PROCESS_KEY_PROPERTY, "key1");
	}

}
