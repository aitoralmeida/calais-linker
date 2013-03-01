package main;

import java.io.IOException;
import java.util.Vector;

import rdf.CalaisRDFHandler;
import client.CalaisClient;
import client.DBPediaClient;
import client.GeonamesClient;
import data.City;
import data.Company;
import data.Entities;

public class CalaisLinker {
	
	public Entities linkContentData(String content) throws IOException{
		CalaisClient calaisClient = new CalaisClient();
		CalaisRDFHandler calaisRdfHandler = new CalaisRDFHandler();
		GeonamesClient geonamesClient = new GeonamesClient();
		DBPediaClient dbpediaClient = new DBPediaClient();
		
		Entities entities = new Entities();
		String calaisRdf = calaisClient.getAnalysis(content);
		Vector<City> cities = calaisRdfHandler.getCities(calaisRdf);
		for (City city : cities) {
			String resourceUri = geonamesClient.getLocationUri(city.getShortname(), city.getCountry());
			city.setUri(resourceUri);
		}	
		entities.setCities(cities);
		
		Vector<Company> companies = calaisRdfHandler.getCompanies(calaisRdf);
		for (Company company : companies) {
			String resourceUri = dbpediaClient.searchCompanyResource(company.getName(), company.getShortname(), company.getTicker());
			company.setUri(resourceUri);
		}
		entities.setCompanies(companies);
		
		return entities;		
	}
}
