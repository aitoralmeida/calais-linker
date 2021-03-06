package client;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import xml.GeonamesXMLParser;

public class GeonamesClient {
	
	//http://sws.geonames.org/3128026/about.rdf is an example of resource uri for a location (in this case Bilbao)
	//This client has to get the ID (the number in the uri) given a city name and its country
	//<fcode> must contain the PPL string to be a city
	//<countryName> must be the same as the one recovered from OpenCalais
	
	public static String URI_START = "http://sws.geonames.org/";
	public static String URI_END = "/about.rdf";
	
	public String getLocationUri(String city, String country) throws ResourceException, IOException{
		String response = this.search(city);
		GeonamesXMLParser parser = new GeonamesXMLParser();
		String id = parser.getGeonameId(response, city, country);
		String uri = GeonamesClient.URI_START + id + GeonamesClient.URI_END;
		return uri;
	}
	
	public String search(String city) throws ResourceException, IOException{
		String url = ConfigValuesGeonames.GEO_URL_SEARCH;
		url = url + ConfigValuesGeonames.GEO_QUERY + city + ConfigValuesGeonames.AND + ConfigValuesGeonames.GEO_USERNAME + ConfigValuesGeonames.USERNAME;
				
		ClientResource resource = new ClientResource(url);  
		Representation repr = resource.get();
		String result = repr.getText();
		return result;		
	}

}
