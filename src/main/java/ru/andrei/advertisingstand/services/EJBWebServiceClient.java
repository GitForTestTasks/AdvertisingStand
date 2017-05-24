package ru.andrei.advertisingstand.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.andrei.advertisingstand.ws.StatisticsGoods;
import ru.andrei.advertisingstand.ws.TopGoodsWs;
import ru.andrei.advertisingstand.ws.TopGoodsWsService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Web service client.
 *
 * @author Andrei
 */
@Singleton
public class EJBWebServiceClient {

    private static Logger logger = LoggerFactory.getLogger(EJBWebServiceClient.class);
    private static List<StatisticsGoods> statisticsGoods = null;

    @PostConstruct
    private void init() {
        forceUpdate();
    }

    public EJBWebServiceClient() {
    }

    /**
     * Forces update from web-service
     */
    public synchronized void forceUpdate() {
        TopGoodsWsService service = new TopGoodsWsService();
        TopGoodsWs pService = service.getTopGoodsWsPort();
        statisticsGoods = pService.getTopTenGoods();
        logger.info("Update is forced.");
    }

    /**
     * Returns top ten goods
     * @return list of statistics DTO
     */
    public List<StatisticsGoods> getStatisticsGoods() {

        if(statisticsGoods == null)
            return new ArrayList<>();
        else
            return statisticsGoods;
    }
}
