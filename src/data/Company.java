package data;

public class Company {
	
	private String name;
	private String shortname;
	private String ticker;
	private String uriDBPedia;
	
	public Company(String name, String shortname, String ticker) {
		super();
		this.name = name;
		this.shortname = shortname;
		this.ticker = ticker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getUriDBPedia() {
		return uriDBPedia;
	}

	public void setUriDBPedia(String uri) {
		this.uriDBPedia = uri;
	}
}
