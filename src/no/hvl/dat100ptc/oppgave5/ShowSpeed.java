package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import no.hvl.dat100ptc.TODO;

public class ShowSpeed extends EasyGraphics {
			
	private static int MARGIN = 50;
	private static int BARHEIGHT = 100; 

	private GPSComputer gpscomputer;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Speed profile", 
				2 * MARGIN + 
				2 * gpscomputer.speeds().length, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT);
	}
	
	public void showSpeedProfile(int ybase) {
		
		double[] speeds = gpscomputer.speeds();  // henter speeds fra GPS data 
        double maxSpeed = gpscomputer.maxSpeed();  // Maksimal hastighet for skalering av søylene
        int x = MARGIN;

        // Loop gjennom alle hastighetene og tegner en søyle for hver hastighet
        for (double speed : speeds) {
            // Skalerer søylehøyden basert på maksimal hastighet
            int barHeight = (int) (speed / maxSpeed * BARHEIGHT);
            
            // blå farge
            setColor(0, 0, 255);  

            fillRectangle(x, ybase - barHeight, 2, barHeight);
            
            //x posisjon
            x += 3;
        }
		
	}
}
