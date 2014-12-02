package com.spring.jms.async.producer;

import java.util.Properties;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.spring.jms.exception.MessageProductionException;
import com.spring.jms.queue.Employee;


@Component
public class QueueProducer {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Resource(name = "jmsConfig")
  private Properties jmsConfig;

  /**
   * 
   * @param dto
   * @throws MessageProductionException
   */
  public void sendMesage(final Employee dto) throws MessageProductionException {
    
    try {
      
      MessageCreator messageCreator = new MessageCreator() {
        
        public Message createMessage(Session session) throws JMSException {
          
         //If want to send text message
         // return session.createTextMessage("I am sending Invoice message");
          return session.createObjectMessage(dto);
        }
      };

      System.out.println("Message Sent Successfully........");
      
      jmsTemplate.send(messageCreator);
      
    }catch(Exception je) {
      throw new MessageProductionException("Unable to send message to destination..", je);
    }
  }

}
