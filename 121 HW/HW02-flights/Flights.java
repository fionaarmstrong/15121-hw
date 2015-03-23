/**
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

// YOU MAY NOT IMPORT ANY ADDITIONAL
// CLASSES OR PACKAGES

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
	
	public ArrayList<Flight> flights = new ArrayList<Flight>();
	
	public static void main(String[] args) {
		Flights fl = new Flights();
		ArrayList<Flight> fylist = fl.getNonStopFlights("PIT", "LAS");
		for(Flight i:fl.deepCopy(fylist)){
			System.out.println(i.getInfo());
		}
	}
	
	// DO NOT CHANGE THIS METHOD
	public Flights() {
		loadFlights();
	}
	
	/**
	 * Loads the flight data using the given specification. You must use the specification
	 * provided in the write-up in order to receive full credit. You may need to create
	 * multiple copies of the `flights.txt` file. You may *not* modify the `flights.txt` file.
	 */
	private void loadFlights() {
		String filename = "flights.txt";
		
		try {
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				// you need to look up the String.split method
				// in the Java API and understand how it works!
				String[] splitLine = line.split("[|]");
				flights.add(new Flight(splitLine[0],splitLine[1],splitLine[2],splitLine[3],splitLine[4],Integer.parseInt(splitLine[5])));
				// write your code here for loadFlights
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println("I could not load the file. Please make sure the file is in the correct directory.");
			System.exit(0);
		} catch(Exception e) {
			System.out.println("There was an error while creating the flights:");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Returns the flights ArrayList
	 * @return ArrayList<Flight>
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	/**
	 * Finds and returns all Flights that depart from the given ICAO airport code. This method
	 * must run in O(n) time. For example (your data may be different):
	 *   Flights f = new Flights();
	 *   f.getFlightsDepartingFrom("PIT"); // could return [DL8273, WN2834, WN5243]
	 * @param airport - the ICAO airport code to search for
	 * @return - an ArrayList of Flight objects that depart from the given ICAO code
	 */
	public ArrayList<Flight> getFlightsDepartingFrom(String airport) {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		for(int i=0; i<flights.size(); i++){
			if(flights.get(i).getDepartureAirport().equalsIgnoreCase(airport))
				flightList.add(flights.get(i));
		}
		return flightList;
	}
	
	/**
	 * Finds and returns all Flights that arrive at the given ICAO airport code. This method
	 * must run in O(n) time. For example (your data may be different):
	 *   Flights f = new Flights();
	 *   f.getFlightsArriveAt("LAS"); // could return [WN2834, WN5243]
	 * @param airport - the ICAO airport code to search for
	 * @return - an ArrayList of Flight objects that arrive at the given ICAO code
	 */
	public ArrayList<Flight> getFlightsArrivingAt(String airport) {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		for(int i=0; i<flights.size(); i++){
			if(flights.get(i).getArrivalAirport().equalsIgnoreCase(airport))
				flightList.add(flights.get(i));
		}
		return flightList;
	}
	
	/**
	 * Finds and returns an ArrayList<Flight> representing all direct Flights starting in
	 * startAirport and ending at endAirport.
	 * are grouped by their unique identifier. For example:
	 *   Flights f = new Flights();
	 *   f.getFlightsAlongPath("PIT", "LAS"); // could return [WN2834, WN5243]
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - an ArrayList<Flight> that are non-stop
	 */
	public ArrayList<Flight> getNonStopFlights(String departureAirport, String arrivalAirport) {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		for(int i=0; i<flights.size(); i++){
			if(flights.get(i).getArrivalAirport().equalsIgnoreCase(arrivalAirport)
					&& flights.get(i).getDepartureAirport().equalsIgnoreCase(departureAirport))
				flightList.add(flights.get(i));
		}
		return flightList;
	}
		
	/**
	 * Cancels all flights that stop in the given airport. You must deepCopy the global flights
	 * ArrayList and then remove any flights that ever exist in at a given airport.
	 * 
	 * Recall from lecture that there is optional bonus in this method
	 * @param airport - the airport that has canceled all flights
	 * @return - an ArrayList<Flight> that are still able to fly
	 */
	public ArrayList<Flight> cancelFlights(String airport) {
		// write your code for cancelFlights here
		return null; // remove this line when your done
	}
	
	/**
	 * Calculates the total distance traveled for all the given flightIdentifiers
	 * @param flightIdentifiers - an ArrayList<String> representing the flightIdentifiers to search for
	 * @return - the total distance (in miles) traveled
	 */
	public int getTotalDistance(ArrayList<String> flightIdentifiers) {
		int totDistance = 0;
		for(String i : flightIdentifiers){
			for(int j=0; j<flights.size(); j++){
				if(flights.get(j).getIdentifier().equalsIgnoreCase(i)){
					totDistance+=flights.get(j).getDistance();
					j=flights.size();
				}		
			}
		}
		return totDistance; // remove this line when your done
	}
	
	/**
	 * Arranges the flights in an ArrayList<ArrayList<Flight>>. Each ArrayList<ArrayList> represents
	 * a unique flight path. Each ArrayList<ArrayList<Flight>> represents a collection of the flight
	 * path, in the same order as the input file. For a more detailed explanation, see the write-up.
	 * @return
	 */
	public ArrayList<ArrayList<Flight>> arrangedFlights() {
		//ArrayList<ArrayList> mainList = new ArrayList<ArrayList>();
		
		
		return null; // remove this line when your done
	}
	
	/**
	 * Returns an ArrayList<Flight> corresponding to all flights that start at departureAirport
	 * and end at arrivalArrival airport and have at least 1 stop in between. Return the FIRST 
	 * flight object along the full flight path.
	 * 
	 * HINT: You may find it helpful to use the arrangedFlights() method you just wrote.
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - an organized list of all multi-hop flights
	 */
	public ArrayList<Flight> getMultiHopFlights(String departureAirport, String arrivalAirport) {
		// write your code for getMultiHopFlights here
		return null; // remove this line when your done
	}

	
	/**
	 * deepCopies an ArrayList<Flight>
	 * @param theFlights
	 * @return - a new ArrayList<Flight> containing the same Flights in the same order as the given
	 * ArrayList<Flight>
	 */
	private ArrayList<Flight> deepCopy(ArrayList<Flight> theFlights) {
		ArrayList<Flight> newList = new ArrayList<Flight>();
		for(Flight i: theFlights)
			newList.add(new Flight(i.getIdentifier(),i.getDepartureAirport(),i.getDepartureTime(),
					i.getArrivalAirport(),i.getArrivalTime(),i.getDistance()));
		return newList;
	}
}