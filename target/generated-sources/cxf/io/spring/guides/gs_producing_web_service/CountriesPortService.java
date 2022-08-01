package io.spring.guides.gs_producing_web_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.2
 * 2022-06-20T17:46:32.003+05:30
 * Generated source version: 3.5.2
 *
 */
@WebServiceClient(name = "CountriesPortService",
                  wsdlLocation = "file:/D:/apache-camel-workspace/consuming-soap/src/main/resources/wsdl/countries.wsdl",
                  targetNamespace = "http://spring.io/guides/gs-producing-web-service")
public class CountriesPortService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://spring.io/guides/gs-producing-web-service", "CountriesPortService");
    public final static QName CountriesPortSoap11 = new QName("http://spring.io/guides/gs-producing-web-service", "CountriesPortSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/apache-camel-workspace/consuming-soap/src/main/resources/wsdl/countries.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CountriesPortService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/D:/apache-camel-workspace/consuming-soap/src/main/resources/wsdl/countries.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CountriesPortService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CountriesPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountriesPortService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CountriesPortService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CountriesPortService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CountriesPortService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CountriesPort
     */
    @WebEndpoint(name = "CountriesPortSoap11")
    public CountriesPort getCountriesPortSoap11() {
        return super.getPort(CountriesPortSoap11, CountriesPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CountriesPort
     */
    @WebEndpoint(name = "CountriesPortSoap11")
    public CountriesPort getCountriesPortSoap11(WebServiceFeature... features) {
        return super.getPort(CountriesPortSoap11, CountriesPort.class, features);
    }

}
