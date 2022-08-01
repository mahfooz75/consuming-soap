package com.poc.consumingsoap.router;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.CountriesPort;
import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Component
public class InvokeSoapServiceRouteBuilder extends RouteBuilder {
	private static final String ROUTER_ADDRESS = "http://localhost:8080/ws";
	private static final String SERVICE_CLASS = "serviceClass=io.spring.guides.gs_producing_web_service.CountriesPortService";
	private static final String WSDL_LOCATION = "wsdlURL=wsdl/countries.wsdl";
    private static final String SERVICE_NAME = "serviceName={http://spring.io/guides/gs-producing-web-service}CountriesPortService";
    private static final String SOAP_OVER_HTTP_ROUTER = "portName={http://spring.io/guides/gs-producing-web-service}CountriesPortSoap11";
	
	private static final String ROUTER_ENDPOINT_URI = "cxf://" + ROUTER_ADDRESS + "?" + SERVICE_CLASS + "&"
            + WSDL_LOCATION + "&" + SERVICE_NAME + "&" + SOAP_OVER_HTTP_ROUTER;
	@Override
	public void configure() throws Exception {
		//from("timer:post-timer?period=2&repeatCount=5")
		from("timer:post-timer?repeatCount=5")
		.setBody(constant("Spain")).bean(GetCountryRequestBuilder.class)
		.setHeader(CxfConstants.OPERATION_NAME, constant("getCountry"))
        .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://spring.io/guides/gs-producing-web-service"))
		.to("cxf://http://localhost:8080/ws"
                + "?serviceClass="+CountriesPort.class.getName()
				//+"&serviceName={http://spring.io/guides/gs-producing-web-service}CountriesPortService"
                //+ "&endpointName=getCountry"
                //+ "&portName={http://spring.io/guides/gs-producing-web-service}CountriesPortSoap11"
                + "&wsdlURL=/wsdl/countries.wsdl")
        .process(e->{
        	Message message = e.getIn();
        	GetCountryResponse countryResponse = message.getBody(GetCountryResponse.class);
        	Country country = countryResponse.getCountry();
        	System.out.println(country.getName());
    		System.out.println(country.getCapital());
    		System.out.println(country.getCurrency());
        })
//        from("cxf://https://www.w3schools.com/xml/TempConvertSoap"
//                + "?serviceClass=com.w3schools.webservices.TempConvertSoap"
//                + "&serviceName=CelsiusToFahrenheit"
//                + "&wsdlURL=/wsdl/tempconvert.wsdl").setBody(constant("37")).bean(CelsiusToFarenheitRequestBuilder.class)
//		.setHeader(CxfConstants.OPERATION_NAME, constant("CelsiusToFahrenheit"))
//        .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://www.w3schools.com/xml"))
//        .to("cxf://http://localhost:8080/ws/CountriesPort"
//                + "?serviceClass=io.spring.guides.gs_producing_web_service.CountriesPort"
//                + "&wsdlURL=/wsdl/countries.wsdl")
        .log("SOAP Called");
	}

}
