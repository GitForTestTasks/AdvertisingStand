package ru.andrei.advertisingstand.beans;

import ru.andrei.advertisingstand.services.EJBWebServiceClient;
import ru.andrei.advertisingstand.ws.StatisticsGoods;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.List;

@ManagedBean
@SessionScoped
public class GoodStatistics {

    @EJB
    private EJBWebServiceClient ejbWebServiceClient;

    public List<StatisticsGoods> getTopTenGoods() {
        throw new RuntimeException("sasadasd");
//        return ejbWebServiceClient.getStatisticsGoods();
    }
}
