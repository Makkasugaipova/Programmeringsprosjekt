package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	//a)
	private int time; //tid i sekunder 
	private double latitude; //breddegrad
	private double longitude; //lengdegrad
	private double elevation; //høyde i meter
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation; 
		
	}

	//b) 
	public int getTime() {
		return time; //getter 
		
	}

	public void setTime(int time) {
		this.time = time; //setter
		
	}

	public double getLatitude() {
		return latitude; 
		
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
		
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;		
	}
	
	
	//c
	public String toString() {
		
		String str = time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
		
		return str;
		// toString()-metode som returnerer 1 (2.0,3.0) 5.0\n i følge oppgaven
		
		//oppgave d er i Main.java
	}
}
