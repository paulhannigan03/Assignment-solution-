package ie.lyit.testers;

import ie.lyit.flight.Booking;
import ie.lyit.flight.CreditCard;
import ie.lyit.flight.Passenger;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Name;
import ie.lyit.flight.Date;
import ie.lyit.flight.Time;
import java.util.ArrayList;

public class BookingTester {
    public static void main(String[] args) {
        // Create dummy flights
        Flight outboundFlight = new Flight("781DER", "Derry", "London Stanstead", new Date(23, 12, 2021), new Time(8, 30), 105.99);
        Flight inboundFlight = new Flight("BR418", "Stanstead", "Derry", new Date(30, 12, 2021), new Time(10, 15), 155.97);

        // Create dummy passengers
        ArrayList<Passenger> passengers1 = new ArrayList<>();
        passengers1.add(new Passenger(new Name("Mr", "Bart", "Simpson"), "123456789", "bart@example.com", 1, false, new CreditCard(0, null, 0)));

        ArrayList<Passenger> passengers2 = new ArrayList<>();
        passengers2.add(new Passenger(new Name("Mrs", "Marge", "Simpson"), "987654321", "marge@example.com", 2, true, new CreditCard(0, null, 0)));
        passengers2.add(new Passenger(new Name("Mr", "Homer", "Simpson"), "555555555", "homer@example.com", 0 , true, new CreditCard(0, null, 0)));
        passengers2.add(new Passenger(new Name("Mr", "Homer", "Simpson"), "555555555", "homer@example.com", 0, true, new CreditCard(0, null, 0)));

        // Create Booking instances
        Booking booking1 = new Booking(outboundFlight, null, passengers1);
        Booking booking2 = new Booking(outboundFlight, inboundFlight, passengers2);

        // Display booking details
        displayBookingDetails(booking1);
        System.out.println();
        displayBookingDetails(booking2);
    }

    private static void displayBookingDetails(Booking booking) {
        System.out.println("Booking Number " + booking.getBookingNo());
        System.out.println("Outbound Flight " + booking.getOutbound());
        
        if (booking.getInbound() != null) {
            System.out.println("Inbound Flight " + booking.getInbound());
        }
        
        System.out.println("Passengers " + booking.getPassengers());
        System.out.println("Total Price " + booking.getTotalPrice());
    }
}
