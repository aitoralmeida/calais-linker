package rdf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

import com.hp.hpl.jena.query.QuerySolution;

import data.City;

public class CalaisRDFHandlerTest {

	@Test
	public void testReadSparqlFile() throws Exception {
		CalaisRDFHandler rdf = new CalaisRDFHandler();
		String result = rdf.readTextFile("./input/test/test1.sparql");
		assertEquals("12345\n678\n", result);
	}
	
	@Test
	public void testGetSparqlOutputTotalTypes() throws Exception {
		CalaisRDFHandler rdf = new CalaisRDFHandler();
		String owl = rdf.readTextFile("./input/test/bilbao-ibm.owl");
		Vector<QuerySolution> results = rdf.executeQuery(owl, "./input/test/types.sparql");
		/*
		for (Iterator<QuerySolution> iterator = results.iterator(); iterator.hasNext();) {
			QuerySolution querySolution = (QuerySolution) iterator.next();
			System.out.println(querySolution.toString());	

		}
		*/
		assertEquals(17,  results.size());		
	}
	
	@Test
	public void testGetSparqlOutputCities() throws Exception {
		CalaisRDFHandler rdf = new CalaisRDFHandler();
		String owl = rdf.readTextFile("./input/test/bilbao-ibm.owl");
		Vector<QuerySolution> results = rdf.executeQuery(owl, "./input/sparql/places.sparql");
		assertEquals(2, results.size());
		
		Set<String> names = new HashSet<String>();
		for (Iterator<QuerySolution> iterator = results.iterator(); iterator.hasNext();) {
			QuerySolution querySolution = (QuerySolution) iterator.next();
			names.add(querySolution.getLiteral("shortname").getString());

		}
		assertTrue(names.contains("London"));
		assertTrue(names.contains("Bilbao"));
	}
	
	@Test
	public void testGetSparqlOutputCompanies() throws Exception {
		CalaisRDFHandler rdf = new CalaisRDFHandler();
		String owl = rdf.readTextFile("./input/test/bilbao-ibm.owl");
		Vector<QuerySolution> results = rdf.executeQuery(owl, "./input/sparql/companies.sparql");
		assertEquals(1, results.size());

		QuerySolution querySolution = results.get(0);
		assertEquals("INTERNATIONAL BUSINESS MACHINES CORPORATION",querySolution.getLiteral("name").getString());
		assertEquals("IBM",querySolution.getLiteral("shortname").getString());
		assertEquals("IBM",querySolution.getLiteral("ticker").getString());
	
	}
	
	@Test
	public void testGetCities() throws Exception {
		CalaisRDFHandler rdf = new CalaisRDFHandler();
		String owl = rdf.readTextFile("./input/test/bilbao-ibm.owl");
		Vector<City> cities = rdf.getCities(owl);
		assertEquals(2, cities.size());
		//London
		assertEquals("London", cities.get(0).getShortname());
		assertEquals("London,Greater London,United Kingdom", cities.get(0).getName());
		assertEquals("-0.106196", cities.get(0).getLongitude());
		assertEquals("51.517124", cities.get(0).getLatitude());
		assertEquals("United Kingdom", cities.get(0).getCountry());
		//Bilbao
		assertEquals("Bilbao", cities.get(1).getShortname());
		assertEquals("Bilbao,Biscay,Spain", cities.get(1).getName());
		assertEquals("-2.9667", cities.get(1).getLongitude());
		assertEquals("43.25", cities.get(1).getLatitude());
		assertEquals("Spain", cities.get(1).getCountry());
				
	}


}
