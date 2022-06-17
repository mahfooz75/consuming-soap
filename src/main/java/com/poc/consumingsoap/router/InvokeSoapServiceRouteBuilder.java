package com.poc.consumingsoap.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class InvokeSoapServiceRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("cxf://http://localhost:8080/ws"
				+ "?serviceClass=io.spring.guides.gs_producing_web_service.CountriesPortService"
				+"&serviceName=CountriesPortService"
				+"&endpointName=CountriesPort"
				+"&dataFormat=PAYLOAD"
				+ "&wsdlURL=/wsdl/countries.wsdl")
				//.setBody(constant("request"))
				//.bean(LoanEligibilityRequestBuilder.class)
				// .setHeader(CxfConstants.SERVICE_CLASS,constant("TempConvert"))
				//.setHeader(CxfConstants.OPERATION_NAME, constant("getCountry"))
				//.setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://spring.io/guides/gs-producing-web-service"))
//			.process(e->{
//				Message message = e.getIn();
//				String body = message.getBody(String.class);
//				System.out.println(body);
//			})
			.to("log:SOAP service called");
//				.to("cxf://http://localhost:8080/ws/LoanEligibilityIndicator"
//						+ "?serviceClass=com.poc.spring.soap.api.loaneligibility.LoanEligibilityIndicator"
//						+ "&wsdlURL=/wsdl/loanEligibility.wsdl")
		
	}

}
