package ru.andrei.advertisingstand.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.andrei.tsystemsverificationwork.web.services.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTopTenGoodsResponse_QNAME = new QName("http://impl.services.web.tsystemsverificationwork.andrei.ru/", "getTopTenGoodsResponse");
    private final static QName _GetTopTenGoods_QNAME = new QName("http://impl.services.web.tsystemsverificationwork.andrei.ru/", "getTopTenGoods");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.andrei.tsystemsverificationwork.web.services.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTopTenGoods }
     * 
     */
    public GetTopTenGoods createGetTopTenGoods() {
        return new GetTopTenGoods();
    }

    /**
     * Create an instance of {@link GetTopTenGoodsResponse }
     * 
     */
    public GetTopTenGoodsResponse createGetTopTenGoodsResponse() {
        return new GetTopTenGoodsResponse();
    }

    /**
     * Create an instance of {@link StatisticsGoods }
     * 
     */
    public StatisticsGoods createStatisticsGoods() {
        return new StatisticsGoods();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTopTenGoodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.services.web.tsystemsverificationwork.andrei.ru/", name = "getTopTenGoodsResponse")
    public JAXBElement<GetTopTenGoodsResponse> createGetTopTenGoodsResponse(GetTopTenGoodsResponse value) {
        return new JAXBElement<GetTopTenGoodsResponse>(_GetTopTenGoodsResponse_QNAME, GetTopTenGoodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTopTenGoods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.services.web.tsystemsverificationwork.andrei.ru/", name = "getTopTenGoods")
    public JAXBElement<GetTopTenGoods> createGetTopTenGoods(GetTopTenGoods value) {
        return new JAXBElement<GetTopTenGoods>(_GetTopTenGoods_QNAME, GetTopTenGoods.class, null, value);
    }

}
