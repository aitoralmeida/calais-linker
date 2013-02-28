package client;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBPediaClientTest {

	@Test
	public void testSearch() throws Exception{
		DBPediaClient client = new DBPediaClient();
		String result = client.searchResource("IBM");
		assertEquals("http://dbpedia.org/resource/IBM", result);
	}
	
	@Test
	public void testGetURI() throws Exception{
		DBPediaClient client = new DBPediaClient();
		String result = client.getUri("<td>http://dbpedia.org/resource/IBM</td>");
		assertEquals("http://dbpedia.org/resource/IBM", result);
	}

}
