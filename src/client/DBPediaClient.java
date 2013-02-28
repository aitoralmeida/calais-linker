package client;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class DBPediaClient {
	
	public static String DBPEDIA_URL_SEARCH = "http://dbpedia.org/sparql?query=";
	public static String COMPANY_QUERY_START = "select ?uri where {?uri rdfs:label \"";
	public static String COMPANY_QUERY_END = "\"@en . ?uri rdf:type dbpedia-owl:Company}";
	
	public String searchResource(String company) throws IOException{
		String url = DBPediaClient.DBPEDIA_URL_SEARCH;
		String query = DBPediaClient.COMPANY_QUERY_START + company + DBPediaClient.COMPANY_QUERY_END;
		url = url + URLEncoder.encode(query, "UTF-8");

		ClientResource resource = new ClientResource(url);  
		Representation repr = resource.get();
		String result = repr.getText();
		String uri = this.getUri(result);
		return uri;		
	}
	
	String getUri(String result){
		Pattern pattern = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		Matcher matcher = pattern.matcher(result);
		String uri = "";
		while (matcher.find()) {
			uri = matcher.group();
		}
		
		return uri;
	}

}
