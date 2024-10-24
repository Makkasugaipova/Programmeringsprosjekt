package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import no.hvl.dat100ptc.TODO;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	private double minlon, minlat, maxlon, maxlat;

	private double xstep, ystep;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		
		xstep = scale(MAPXSIZE, minlon, maxlon);
		ystep = scale(MAPYSIZE, minlat, maxlat);
		
		showRouteMap(MARGIN + MAPYSIZE);

		replayRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	public double scale(int maxsize, double minval, double maxval) {

		double step = maxsize / (Math.abs(maxval - minval));

		return step;
	}

	public void showRouteMap(int ybase) {

	    setColor(0, 0, 255);

	    for (int i = 0; i < gpspoints.length - 1; i++) {
	        // Hent GPS-koordinatene for to påfølgende punkter
	        int x1 = MARGIN + (int)((gpspoints[i].getLongitude() - minlon) * xstep);
	        int y1 = ybase - (int)((gpspoints[i].getLatitude() - minlat) * ystep);
	        int x2 = MARGIN + (int)((gpspoints[i + 1].getLongitude() - minlon) * xstep);
	        int y2 = ybase - (int)((gpspoints[i + 1].getLatitude() - minlat) * ystep);

	        drawLine(x1, y1, x2, y2);
	    }
	}

	public void showStatistics() {
	    int TEXTDISTANCE = 20;

	    // Hent statistikk fra GPSComputer
	    double totalDistance = gpscomputer.totalDistance(); // Total distanse i km
	    double totalElevation = gpscomputer.totalElevation(); // Total stigning i meter
	    double totalTime = gpscomputer.totalTime(); // Total tid i sekunder
	    double avgSpeed = gpscomputer.averageSpeed(); // Gjennomsnittshastighet i km/t

	    // Vis statistikken i vinduet
	    setColor(0, 0, 0); // Svart farge for tekst
	    setFont("Courier", 12);

	    drawString("Total distance: " + String.format("%.2f", totalDistance) + " km", MARGIN, TEXTDISTANCE);
	    drawString("Total elevation: " + String.format("%.2f", totalElevation) + " m", MARGIN, TEXTDISTANCE + 20);
	    drawString("Total time: " + String.format("%.2f", totalTime) + " s", MARGIN, TEXTDISTANCE + 40);
	    drawString("Average speed: " + String.format("%.2f", avgSpeed) + " km/h", MARGIN, TEXTDISTANCE + 60);
	}


	public void replayRoute(int ybase) {

	    setColor(255, 0, 0); // Rød farge for å vise ruten "replay"

	    for (int i = 0; i < gpspoints.length - 1; i++) {

	        int x1 = MARGIN + (int)((gpspoints[i].getLongitude() - minlon) * xstep);
	        int y1 = ybase - (int)((gpspoints[i].getLatitude() - minlat) * ystep);
	        int x2 = MARGIN + (int)((gpspoints[i + 1].getLongitude() - minlon) * xstep);
	        int y2 = ybase - (int)((gpspoints[i + 1].getLatitude() - minlat) * ystep);

	        drawLine(x1, y1, x2, y2);

	        pause(100); 
	    }
	}
}

