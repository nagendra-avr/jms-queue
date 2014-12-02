package com.spring.jms.async;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jms.async.producer.QueueProducer;
import com.spring.jms.queue.Employee;

/**
 * This class drives the example from the producer side. It loads the Spring {@link ApplicationContext} and sends
 * messages. The entire configuration for this app is held in <tt>src/main/resources/jms-context.xml</tt>.
 * 
 * @author bsnyder
 */
public class AsynchProducerAppLaunch {

  private static final Logger LOG = LoggerFactory.getLogger(AsynchProducerAppLaunch.class);

  /**
   * Run the app and tell the producer to send its messages.
   * 
   * @param args
   * @throws JMSException
   */

  public static void main(String[] args) throws JMSException {
    ApplicationContext context = new ClassPathXmlApplicationContext("/jms/Async/spring/producer-jms-context.xml",
        AsynchProducerAppLaunch.class);
    QueueProducer producer = (QueueProducer) context.getBean("queueProducer");

    for (int i = 0; i < 20; i++) {
      Employee emp = new Employee();
      emp.setEmpID(i);
      emp.setEmpName("vl " + i);
      producer.sendMesage(emp);
    }

  }

}
