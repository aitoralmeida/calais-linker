package client;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBPediaClientTest {

	@Test
	public void testSearch() throws Exception{
		DBPediaClient client = new DBPediaClient();
		String result = client.searchResource("INTERNATIONAL BUSINESS MACHINES CORPORATION", "IBM", "IBM");
		assertEquals("http://dbpedia.org/resource/IBM", result);
		
		result = client.searchResource("Google Inc", "Google", "GOOG");
		assertEquals("http://dbpedia.org/resource/Google", result);
		
		result = client.searchResource("Apple Inc.", "Apple", "AAPL");
		assertEquals("http://dbpedia.org/resource/Apple_Inc", result);		
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
