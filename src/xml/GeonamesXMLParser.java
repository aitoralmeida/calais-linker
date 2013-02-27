package xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GeonamesXMLParser {
	
	public String getGeonameId(String geonamesResult, String city, String country){
		String result ="";
		
		try {
			InputStream is = new ByteArrayInputStream(geonamesResult.getBytes("UTF-8"));
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(is);
			//root element
			Element docEle = dom.getDocumentElement();
			
			//nodelist of geoname-s
			NodeList nl = docEle.getElementsByTagName("geoname");
			
			if(nl != null && nl.getLength() > 0) {
				for(int i = 0 ; i < nl.getLength();i++) {		
					Element el = (Element)nl.item(i);
						
					String toponymName = getTextValue(el,"toponymName");
					String countryName = getTextValue(el,"countryName");
					String fcode = getTextValue(el,"fcode");
					String geonameId = getTextValue(el,"geonameId");
					
					// fcode must contain PPL to be a city
					if (toponymName.equals(city) && countryName.equals(country) && fcode.contains("PPL")){
						result = geonameId;
						break;
					} 	
				}
			}

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return result;
	}


	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	

}
