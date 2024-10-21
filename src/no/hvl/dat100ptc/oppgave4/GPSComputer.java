package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	//a)
	public double totalDistance() {
	    double totalDistance = 0.0;
	    
	    for (int i = 0; i < gpspoints.length - 1; i++) {
	        totalDistance += GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
	    }
	    
	    return totalDistance;
	    
/* Vi itererer fra 1. punktet til nest siste (gpspoints.length - 1), siden det
skal beregne avstand mellom punkt i og punkt i+1. GPSUtils.distance(gpspoints[i]
gpspoints[i + 1]) brukes for å beregne avstanden mellom hvert par av punkter.
Avstandene blir lagt sammen til totalDistance
*/
	}

	public double totalElevation() {
	    double totalElevation = 0.0;
	    
	    for (int i = 0; i < gpspoints.length - 1; i++) {
	        // Beregn høydeforskjellen
	        double elevationDiff = gpspoints[i + 1].getElevation() - gpspoints[i].getElevation();
	        
	        // Hvis det beveger seg oppover, da må man legge til høydeforskjellen
	        if (elevationDiff > 0) {
	            totalElevation += elevationDiff;
	        }
	    }
	    
	    return totalElevation;    
/*
Løkken går gjennom alle punktene - bortsett fra det siste for å sammenligne hvert punkt med det neste.
gpspoints[i + 1].getElevation() - gpspoints[i].getElevation() beregner høydeforskjellen mellom to punkter.
Hvis høydeforskjellen er positiv, beveger den oppover og da legger vi til forskjellen i totalElevation.
*/
	    
	}
//c)
	public int totalTime() {
	    int startTime = gpspoints[0].getTime();
	    int endTime = gpspoints[gpspoints.length - 1].getTime();
	    
	    return endTime - startTime;
	    /*
gpspoints[0].getTime() henter tiden fra det første punktet (start).
gpspoints[gpspoints.length - 1].getTime() henter tiden fra siste punktet (slutt).
	     */
	}

	public double[] speeds() {
		//d)
	    double[] speeds = new double[gpspoints.length - 1];
	    
	    for (int i = 0; i < gpspoints.length - 1; i++) {

	        double distance = GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);

	        int timeDiff = gpspoints[i + 1].getTime() - gpspoints[i].getTime();
	        
	        speeds[i] = distance / timeDiff;
	    }
	    
	    return speeds;
	    /*
Tabellen speeds har lengden gpspoints.length - 1 fordi en hastighet mellom hvert par av punkter.

Løkken går gjennom alle punktene bortsett fra det siste, og for hvert par av punkter beregnes:
- Distansen mellom punktene med GPSUtils.distance().
- Tidsforskjellen ved å trekke tiden til punkt i fra tiden til punkt i+1.
- Hastigheten som distanse delt på tid, som lagres i speeds[i].
	     */
	}
	
//e)
	public double maxSpeed() {
	    // tabell hastigheter
	    double[] speeds = speeds();
	    
	    double maxSpeed = speeds[0];
	    
	    for (int i = 1; i < speeds.length; i++) {
	        if (speeds[i] > maxSpeed) {
	            maxSpeed = speeds[i];
	        }
	    }
	    
	    return maxSpeed;
	    /*
Bruker speeds()-metoden for å få en tabell med hastighetene mellom alle punktene.
Derette finne største hastigheten ved å iterere gjennom hastighetstabellen og sammenligne hver verdi med maxSpeed. 
Hvis en verdi er større enn maxSpeed, oppdateres maxSpeed.
Return - den største hastigheten.
	     */
	}

	public double averageSpeed() { //f)
	    // Total distanse og total tid
	    double totalDistance = totalDistance(); // Total distanse i meter
	    int totalTime = totalTime(); // Total tid i sek
	    
	    // Beregn gjennomsnittshastigheten i m/s
	    double averageSpeed = totalDistance / totalTime;
	    
	    return averageSpeed;
	    /*
totalDistance() = beregne total distanse i meter.
totalTime() = beregne total tid i sekunder.
Gjennomsnittshastigheten er ganske enkelt den totale distansen delt på den totale tiden.
Resultatet returneres som gjennomsnittshastighet i meter per sekund (m/s).
	     */
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double speedmph = speed * MS;

		if (speedmph < 10 ) {
			met = 4.0;
		} else if (speedmph < 12 ) {
			met = 6.0;
		} else if (speedmph < 14 ) {
			met = 8.0;
		} else if (speedmph < 16 ) {
			met = 10.0;
		} else if (speedmph < 20 ) {
			met = 12.0;
		} else if (speedmph > 20 ) {
			met = 16.0;
		}
	
		double t = secs / 3600;
		
		return kcal = met * weight * t;
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		;
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
