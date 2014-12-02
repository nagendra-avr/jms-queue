package com.spring.jms.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class QueueListener implements MessageListener {
  public void onMessage(Message message) {
    try {
      System.out.println(((TextMessage) message).getText());
      System.out.println("Hello");
    }
    catch (JMSException ex) {
      throw new RuntimeException(ex);
    }
  }
}
