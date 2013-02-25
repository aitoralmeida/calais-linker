package client;

import java.io.IOException;
import java.net.URLEncoder;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class CalaisClient {
	
	String TEST_TEXT = "This is a test, my name is Aitor Almeida and I'm in Bilbao, Spain. I'm writing a longer text because the previous one was too short.";
	StringBuilder parameters = new StringBuilder();
	
	public CalaisClient(){
		parameters.append("<c:params xmlns:c=\"http://s.opencalais.com/1/pred/\"");
		parameters.append(" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">");
		parameters.append("<c:processingDirectives c:contentType=\"${CONTENT_TYPE}\" c:outputFormat=\"${OUTPUT_FORMAT}\"></c:processingDirectives>");
		parameters.append("<c:userDirectives c:allowDistribution=\"true\" c:allowSearch=\"true\" c:externalID=\"17cabs901\" c:submitter=\"${SUBMITTER}\"></c:userDirectives>");
		parameters.append("<c:externalMetadata c:caller=\"SemanticProxy\"/>");
		parameters.append("</c:params>");
	}
	
	public void getAnalysis() throws IOException{
		Form form = new Form();
		form.add("licenseID", URLEncoder.encode(ConfigValues.KEY, "UTF-8"));
		form.add("content", URLEncoder.encode(this.TEST_TEXT, "UTF-8"));
		//form.add("paramsXML",URLEncoder.encode(this.getParamsXml(), "UTF-8"));
		
		ClientResource resource = new ClientResource(ConfigValues.CALAIS_URL);

		Representation r = resource.post(form.getWebRepresentation());

		if (resource.getStatus().isSuccess()) {
			System.out.println("Success");
			System.out.println(r.getText());
		} else {
			System.out.println("Fail");
			System.out.println(r.getText());
		}
	}
	
	private String getParamsXml(){
		String params = this.parameters.toString();
		params = params.replace("${CONTENT_TYPE}", ConfigValues.CONTENT_TYPE);
		params = params.replace("${OUTPUT_FORMAT}", ConfigValues.OUTPUT_FORMAT);
		params = params.replace("${SUBMITTER}", ConfigValues.SUBMITTER);
		
		return params;
	}

}
