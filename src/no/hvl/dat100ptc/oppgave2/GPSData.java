package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	// her opprettes en tabell fra konstruktør av objekt GPSPoint
	public GPSData(int n) {
		gpspoints = new GPSPoint[n]; //oppretter array
		antall = 0; //GPS punkter starter med null
		
		/*
		  Må initialisere en array av objekter slik at vi har et sted å lagre GPSPoint objekter 
		  når vi leser inn data.
		 */
	}

	//returnerer array
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	/*
	 Denne metoden setter inn et nytt GPS-punkt i arrayet
	 og oppdaterer antallet elementer.
	 */
	protected boolean insertGPS(GPSPoint gpspoint) {
	    if (antall < gpspoints.length) { // Sjekker plass i array
	        gpspoints[antall] = gpspoint; // Setter inn GPS-punkt på rett posisjon
	        antall++;
	        return true; 
	    } else {
	        return false;
	    }
	    /*
	     Vi må sjekke om det er plass i arrayet før vi setter inn et nytt element 
	     for å unngå feil. Returnerer true hvis innsettingen var vellykket
	     og false hvis det ikke er mer plass.
	     */
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
	    
		GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation); 
	    
		return insertGPS(gpspoint); 
	}


	public void print() {
		
		
		System.out.println("====== GPS Data - START ======");
		for (int i = 0; i < antall; i++) {
			System.out.println((i + 1) + " " + gpspoints[i].toString());
		}
		System.out.println("====== GPS Data - SLUTT ======");
	}
}
