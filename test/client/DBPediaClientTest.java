package client;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBPediaClientTest {

	@Test
	public void testSearchCompanies() throws Exception{
		DBPediaClient client = new DBPediaClient();
		String result = client.searchCompanyResource("INTERNATIONAL BUSINESS MACHINES CORPORATION", "IBM", "IBM");
		assertEquals("http://dbpedia.org/resource/IBM", result);
		
		result = client.searchCompanyResource("Google Inc", "Google", "GOOG");
		assertEquals("http://dbpedia.org/resource/Google", result);
		
		result = client.searchCompanyResource("Apple Inc.", "Apple", "AAPL");
		assertEquals("http://dbpedia.org/resource/Apple_Inc", result);		
	}
	
	@Test
	public void testSearchCities() throws Exception{
		DBPediaClient client = new DBPediaClient();
		String result = client.searchCityResource("Bilbao", "Spain");
		assertEquals("http://dbpedia.org/resource/Bilbao", result);
		
		result = client.searchCityResource("London", "United Kingdom");
		assertEquals("http://dbpedia.org/resource/London", result);
	}
	
	
	
	@Test
	public void testGetURI() throws Exception{
		DBPediaClient client = new DBPediaClient();
		String result = client.getUri("<td>http://dbpedia.org/resource/IBM</td>");
		assertEquals("http://dbpedia.org/resource/IBM", result);
		
		result = client.getUri("<td>http</td>");
		assertEquals("", result);
	}

}
