package ru.andrei.advertisingstand.beans;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.andrei.advertisingstand.services.EJBWebServiceClient;


import javax.ejb.EJB;

/**
 * Class handles prime faces push
 */
@PushEndpoint("/data")
public class DataPusher {

    private static Logger logger = LoggerFactory.getLogger(DataPusher.class);

    @EJB
    private EJBWebServiceClient ejbWebServiceClient;

    /**
     * Async method is used to tell the view there is an update
     * @param dummy dummy boolean
     */
    @OnMessage(encoders = {JSONEncoder.class})
    public void onMessage(boolean dummy) {

        logger.info("Update is passed to JSF view");
    }
}
