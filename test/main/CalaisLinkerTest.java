package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data.Entities;

public class CalaisLinkerTest {

	@Test
	public void testLinkContentData() throws Exception{
		CalaisLinker linker = new CalaisLinker();
		Entities entities = linker.linkContentData("This is a test. Bilbao, London, Beijing, test, test test test test test test test. Companies are IBM, Google, Apple.");
		assertEquals(3, entities.getCities().size());
		assertEquals(3, entities.getCompanies().size());
		
		//London
		assertEquals("London", entities.getCities().get(0).getShortname());
		assertEquals("http://sws.geonames.org/2643743/about.rdf", entities.getCities().get(0).getUri());
		assertEquals("United Kingdom", entities.getCities().get(0).getCountry());
		//Bilbao
		assertEquals("Bilbao", entities.getCities().get(1).getShortname());
		assertEquals("http://sws.geonames.org/3128026/about.rdf", entities.getCities().get(1).getUri());
		assertEquals("Spain", entities.getCities().get(1).getCountry());
		//Beijing
		assertEquals("Beijing", entities.getCities().get(2).getShortname());
		assertEquals("http://sws.geonames.org/1816670/about.rdf", entities.getCities().get(2).getUri());
		assertEquals("China", entities.getCities().get(2).getCountry());
		
		//Apple
		assertEquals("Apple", entities.getCompanies().get(0).getShortname());
		assertEquals("AAPL", entities.getCompanies().get(0).getTicker());
		assertEquals("http://dbpedia.org/resource/Apple_Inc", entities.getCompanies().get(0).getUri());
		//Google
		assertEquals("Google", entities.getCompanies().get(1).getShortname());
		assertEquals("GOOG", entities.getCompanies().get(1).getTicker());
		assertEquals("http://dbpedia.org/resource/Google", entities.getCompanies().get(1).getUri());
		//IBM
		assertEquals("IBM", entities.getCompanies().get(2).getShortname());
		assertEquals("IBM", entities.getCompanies().get(2).getTicker());
		assertEquals("http://dbpedia.org/resource/IBM", entities.getCompanies().get(2).getUri());
		
	}

}
