package data;

public class City {
	private String name;
	private String shortname;
	private String country;
	private String latitude;
	private String longitude;
	private String uriGeonames;
	private String uriDBPedia;
	
	public City(String name, String shortname, String country, String latitude,
			String longitude) {
		super();
		this.name = name;
		this.shortname = shortname;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getUriGeonames() {
		return uriGeonames;
	}

	public void setUriGeonames(String uriGeonames) {
		this.uriGeonames = uriGeonames;
	}

	public String getUriDBPedia() {
		return uriDBPedia;
	}

	public void setUriDBPedia(String uriDBPedia) {
		this.uriDBPedia = uriDBPedia;
	}
	
	
	

}
