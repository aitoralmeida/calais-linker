package data;

import java.util.Vector;

public class Entities {
	
	private Vector<City> cities;
	
	public Entities(){
		cities = new Vector<City>();
	}

	public Vector<City> getCities() {
		return cities;
	}

	public void setCities(Vector<City> cities) {
		this.cities = cities;
	}
	
	

}
