package ru.andrei.advertisingstand.beans;

import ru.andrei.advertisingstand.services.EJBWebServiceClient;
import ru.andrei.advertisingstand.ws.StatisticsGoods;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.util.List;

/**
 * Bucket bean is used for getting statistics DTO
 */
@ManagedBean
@ApplicationScoped
public class GoodStatistics {

    @EJB
    private EJBWebServiceClient ejbWebServiceClient;

    /**
     * Returns statistics top ten goods
     * @return list of dto objects
     */
    public List<StatisticsGoods> getTopTenGoods() {
        return ejbWebServiceClient.getStatisticsGoods();
    }
}
