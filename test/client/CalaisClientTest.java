package client;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalaisClientTest {

	@Test
	public void testGetAnalysis() throws Exception{
		String test = "This is a test, I'm in Bilbao, Spain. I'm writing a longer text because the previous one was too short. Test Test Test Test Test Test Test Test ";
		String expected = "<c:name>Bilbao,Biscay,Spain</c:name><c:shortname>Bilbao</c:shortname><c:containedbystate>Biscay</c:containedbystate><c:containedbycountry>Spain</c:containedbycountry><c:latitude>43.25</c:latitude><c:longitude>-2.9667</c:longitude>";
		CalaisClient client = new CalaisClient();
		String result = client.getAnalysis(test);
		assertTrue(result.contains(expected));
	}
}
