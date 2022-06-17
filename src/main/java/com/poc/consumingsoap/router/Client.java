package com.poc.consumingsoap.router;

import java.io.File;
import java.net.URL;

import javax.xml.namespace.QName;

import io.spring.guides.gs_producing_web_service.CountriesPort;
import io.spring.guides.gs_producing_web_service.CountriesPortService;
import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

public class Client {

	private final static QName SERVICE_NAME = new QName("http://spring.io/guides/gs-producing-web-service", "CountriesPortService");
	
	public static void main(String[] args) throws Exception {
		String fileName="D:\\apache-camel-workspace\\consuming-soap\\src\\main\\resources\\wsdl\\countries.wsdl";
		File wsdlFile=new File(fileName);
		URL wsdlURL=wsdlFile.toURL();
		
		CountriesPortService service=new CountriesPortService(wsdlURL, SERVICE_NAME);
		CountriesPort countriesPortSoap11 = service.getCountriesPortSoap11();
		GetCountryRequest req=new GetCountryRequest();
		req.setName("Spain");
		GetCountryResponse countryResponse = countriesPortSoap11.getCountry(req);
		Country country = countryResponse.getCountry();
		System.out.println(country.getName());
		System.out.println(country.getCapital());
		System.out.println(country.getCurrency());
	}

}
