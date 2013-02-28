package client;

import java.io.IOException;
import java.net.URLEncoder;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class CalaisClient {
	
	
	
	public String getAnalysis(String content) throws IOException{
		Form form = new Form();
		form.add("licenseID", URLEncoder.encode(ConfigValuesCalais.KEY, "UTF-8"));
		form.add("content", URLEncoder.encode(content, "UTF-8"));
		
		ClientResource resource = new ClientResource(ConfigValuesCalais.CALAIS_URL);

		String response = "";
		Representation r = resource.post(form.getWebRepresentation());
		if (resource.getStatus().isSuccess()) {
			if (resource.getStatus().getCode() == 200){
				response = r.getText();
			}			
		} 
		
		return response;
	}
}
