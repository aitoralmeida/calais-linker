package xml;

import static org.junit.Assert.*;

import org.junit.Test;

import client.GeonamesClient;

public class GeonamesXMLParserTest {

	@Test
	public void testGetGeonameId() throws Exception{
		GeonamesClient client = new GeonamesClient();
		String result = client.search("London");
		GeonamesXMLParser parser = new GeonamesXMLParser();
		String id = parser.getGeonameId(result, "London", "United Kingdom");
		assertEquals("2643743", id);
	}

}
