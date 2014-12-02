package com.spring.jms.async;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jms.sync.consumer.SimpleMessageConsumer;

/**
 * This class drives the example from the consumer side. It loads the Spring 
 * {@link ApplicationContext} and sends messages. The entire configuration for 
 * this app is held in <tt>src/main/resources/jms-context.xml</tt>. 
 * 
 * @author bsnyder
 *
 */
public class AsyncConsumerAppLaunch {
	
	private static final Logger LOG = LoggerFactory.getLogger(AsyncConsumerAppLaunch.class);
    
    /**
     * Run the app and tell the producer to send its messages. 
     * 
     * @param args
     * @throws JMSException
     */
    public static void main(String[] args) throws JMSException {
    	String receiveType = "jmsReceive";
    	
    /*	if (args.length > 0 && null != args[0] && !"".equals(args[0])) {
    		receiveType = args[0];
    	}*/
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("/jms/synch/spring/consumer-jms-context.xml", AsyncConsumerAppLaunch.class);
    	SimpleMessageConsumer receiver = context.getBean(SimpleMessageConsumer.class);
        LOG.debug("Using the '{}' receiveType", receiveType);
        
    	for (int i = 0; i < 100; ++i) {
    		receiver.receive(receiveType);
    	}
    }
    
}
