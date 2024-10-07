package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {
    public static void main(String[] args) {
        // Oppretter objekter
        GPSPoint gpsPoint1 = new GPSPoint(0, 60.385390, 5.332200, 50.0); 
        GPSPoint gpsPoint2 = new GPSPoint(1, 60.390000, 5.340000, 70.0); 

        // Oppretter et GPSData-objekt med plass til to GPSPoint-objekt
        GPSData gpsData = new GPSData(2);

        // insert metoden
        gpsData.insertGPS(gpsPoint1);
        gpsData.insertGPS(gpsPoint2);

        gpsData.print();
    }
}

