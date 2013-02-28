package data;

import java.util.Vector;

public class Entities {
	
	private Vector<City> cities;
	private Vector<Company> companies;
	
	public Entities(){
		cities = new Vector<City>();
	}

	public Vector<City> getCities() {
		return cities;
	}

	public void setCities(Vector<City> cities) {
		this.cities = cities;
	}

	public Vector<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Vector<Company> companies) {
		this.companies = companies;
	}
	
	
	

}
