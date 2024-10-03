package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		// a) 
		
		// fra timestr henter man ut timer, min og sek
		
		int hours = Integer.parseInt(timestr.substring(11,13)); //time
		int minutes = Integer.parseInt(timestr.substring(14, 16)); //minutt
		int seconds = Integer.parseInt(timestr.substring(17, 19)); //sekund
		
		//regning
		return hours * 3600 + minutes * 60 + seconds; 
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		//tid til sek
		int time = toSeconds(timeStr);

		//konverter til double
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		//må opprette GPSPoint-objekt, får hjelp av konstruktør
		GPSPoint gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
		//return objektet
		return gpspoint;
		
	}
	
}




