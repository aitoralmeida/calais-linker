package client;

import java.io.IOException;
import java.net.URLEncoder;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class CalaisClient {
	
	String TEST_TEXT = "This is a test, my name is Aitor Almeida and I'm in Bilbao, Spain. I'm writing a longer text because the previous one was too short.";
	
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
	

}
