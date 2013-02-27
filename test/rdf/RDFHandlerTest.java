package rdf;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

import com.hp.hpl.jena.query.QuerySolution;

public class RDFHandlerTest {

	@Test
	public void testReadSparqlFile() throws Exception {
		RDFHandler rdf = new RDFHandler();
		String result = rdf.readTextFile("./input/test/test1.sparql");
		assertEquals("12345\n678\n", result);
	}
	
	@Test
	public void testGetSparqlOutputTotalTypes() throws Exception {
		RDFHandler rdf = new RDFHandler();
		String owl = rdf.readTextFile("./input/test/bilbao-ibm.owl");
		Vector<QuerySolution> results = rdf.getSparqlOutput(owl, "./input/test/types.sparql");
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
		RDFHandler rdf = new RDFHandler();
		String owl = rdf.readTextFile("./input/test/bilbao-ibm.owl");
		Vector<QuerySolution> results = rdf.getSparqlOutput(owl, "./input/test/city.sparql");
		assertEquals(2, results.size());
		
		Set<String> names = new HashSet<String>();
		for (Iterator<QuerySolution> iterator = results.iterator(); iterator.hasNext();) {
			QuerySolution querySolution = (QuerySolution) iterator.next();
			names.add(querySolution.getLiteral("shortname").getString());

		}
		assertTrue(names.contains("London"));
		assertTrue(names.contains("Bilbao"));
	}

}
