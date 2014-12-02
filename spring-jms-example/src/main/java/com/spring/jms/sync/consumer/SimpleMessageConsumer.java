package com.spring.jms.sync.consumer;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageConsumer {
    
    private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageConsumer.class);

    @Autowired
    protected JmsTemplate jmsTemplate; 
    
    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void receive(String receiveType) {
		if ("jmsReceive".equalsIgnoreCase(receiveType)) {
			jmsReceive();
		} else if ("receiveAndConvert".equalsIgnoreCase(receiveType)) {
			receiveAndConvert();
		}
	}
	
	public void jmsReceive() {
		Message message = jmsTemplate.receive();
		System.out.println("Received a JMS message: {}" + message);
		LOG.debug("Received a JMS message: {}", message);
    }
	
	public void receiveAndConvert() {
		String message = (String) jmsTemplate.receiveAndConvert();
		LOG.debug("Received a text message: {}", message);
	}

}
