package no.hvl.dat100ptc.oppgave1;

//d)
public class Main {

	public static void main(String[] args) {
		GPSPoint point = new GPSPoint(1, 2.0, 3.0, 5.0); // Opprett et GPSPoint-objekt
		
		//skriv ut tidspunkt
		System.out.println("Tidspunkt: " + point.getTime());
		System.out.println(); //ikke viktig, men det er for mellomrom i utskrift
		
		//endre tidspunkt 
		point.setTime(2);
		
		//skriv ut ny tidspunkt
		System.out.println("Ny tidspunkt: " + point.getTime());
		System.out.println(); //ikke viktig, men det er for mellomrom i utskrift
		
		//toString 
		System.out.println("Informasjon om GPSPoint: " + point.toString());
	}
}
