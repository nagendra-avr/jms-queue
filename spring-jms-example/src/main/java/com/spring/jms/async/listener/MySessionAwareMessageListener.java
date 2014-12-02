package com.spring.jms.async.listener;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.spring.jms.queue.Employee;

@Component
public class MySessionAwareMessageListener implements SessionAwareMessageListener<ObjectMessage> {

  private static final Logger LOG = LoggerFactory.getLogger(MySessionAwareMessageListener.class);

/**
 * Perform the necessary operations to consume a message.
 *  
 * @param message A JMS ObjectMessage
 * @param session A JMS Session
 * @throws JMSException if an error occurs with the JMS System
 */
  @Override
  public void onMessage(ObjectMessage message, Session session) throws JMSException {
    try {
      
     // LOG.info("Received message: {}", ((TextMessage) message).getText());

    //  System.out.println(((TextMessage) message).getText());
    //  System.out.println("message.getJMSReplyTo()" + message.getJMSReplyTo());
      
     Employee emp =  (Employee) message.getObject();
     
     System.out.println("Emp id is...." + emp.getEmpID());
     System.out.println("Emp name is ....." + emp.getEmpName());
     
    }
    catch (JMSException e) {
      LOG.error(e.getMessage(), e);
    }

  }



}
