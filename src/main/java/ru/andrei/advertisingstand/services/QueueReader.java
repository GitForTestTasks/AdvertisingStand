package ru.andrei.advertisingstand.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Reads messages from a queue.
 *
 * @author Andrei
 */
@MessageDriven(name = "QueueReader", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/statistics"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class QueueReader implements MessageListener {

    @EJB
    private EJBWebServiceClient ejbWebServiceClient;

    private static Logger logger = LoggerFactory.getLogger(QueueReader.class);

    public QueueReader() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message.getBody(String.class).equals("update"))
                ejbWebServiceClient.forceUpdate();
        } catch (JMSException e) {
            logger.error(e.getMessage());
        }
    }
}