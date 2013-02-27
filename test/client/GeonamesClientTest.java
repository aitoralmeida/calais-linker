package client;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeonamesClientTest {

	@Test
	public void testSearch() throws Exception{
		GeonamesClient client = new GeonamesClient();
		String result = client.search("London");
		assertTrue(result.contains("London"));
		assertTrue(result.contains("United Kingdom"));
		assertTrue(result.contains("PPLC"));
	}

}
