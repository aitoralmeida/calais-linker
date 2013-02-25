package client;

public class ConfigValues {

	public static String KEY = "YOUR_KEY_GOES_HERE"; //Replace this with the API key
	public static String CALAIS_URL = "http://api1.opencalais.com/enlighten/rest/";
	public static String CONTENT_TYPE = "TEXT/RAW";
	public static String OUTPUT_FORMAT = "XML/RDF";
	public static String SUBMITTER ="Calais-linker";
	
	static String paramsBase = "<c:params xmlns:c=\"http://s.opencalais.com/1/pred/\"" +
						" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">" +
						"<c:processingDirectives c:contentType=\"${CONTENT_TYPE}\" c:outputFormat=\"${OUTPUT_FORMAT}\"></c:processingDirectives>" +
						"<c:userDirectives c:allowDistribution=\"true\" c:allowSearch=\"true\" c:externalID=\"17cabs901\" c:submitter=\"${SUBMITTER}\"></c:userDirectives>" +
						"<c:externalMetadata c:caller=\"SemanticProxy\"/>" +
						"</c:params>";
	
	private static String getParamsXml(){
		String params = ConfigValues.paramsBase;
		params = params.replace("${CONTENT_TYPE}", ConfigValues.CONTENT_TYPE);
		params = params.replace("${OUTPUT_FORMAT}", ConfigValues.OUTPUT_FORMAT);
		params = params.replace("${SUBMITTER}", ConfigValues.SUBMITTER);
		
		return params;
	}

}
