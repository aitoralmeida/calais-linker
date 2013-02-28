package main;

import java.io.IOException;
import java.util.Vector;

import rdf.CalaisRDFHandler;
import client.CalaisClient;
import client.GeonamesClient;
import data.City;
import data.Entities;

public class CalaisLinker {
	
	public Entities linkContentData(String content) throws IOException{
		CalaisClient calaisClient = new CalaisClient();
		CalaisRDFHandler calaisRdfHandler = new CalaisRDFHandler();
		GeonamesClient geonamesClient = new GeonamesClient();
		
		String calaisRdf = calaisClient.getAnalysis(content);
		Vector<City> cities = calaisRdfHandler.getCities(calaisRdf);
		for (City city : cities) {
			String resourceUri = geonamesClient.getLocationUri(city.getShortname(), city.getCountry());
			city.setUri(resourceUri);
		}
		
		Entities entities = new Entities();
		entities.setCities(cities);
		
		return entities;		
	}
}
