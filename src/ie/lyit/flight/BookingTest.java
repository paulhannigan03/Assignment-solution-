package ie.lyit.flight;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class BookingTest {

    @Test
    public void testBookingConstructor() {
        Flight outboundFlight = new Flight("OB123", "Derry", "London", new Date(), new Time(), 100.0);
        Flight inboundFlight = new Flight("IB456", "London", "Derry", new Date(), new Time(), 80.0);
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(new Name("Mr", "John", "Doe"), "123456789", "john@example.com", 1, false, null));

        Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

        assertNotNull(booking);
        assertEquals(outboundFlight, booking.getOutbound());
        assertEquals(inboundFlight, booking.getInbound());
        assertEquals(passengers, booking.getPassengers());
        assertTrue(booking.getBookingNo() >= 10000); // Assuming bookingNo starts from 10000
        assertEquals(180.0, booking.getTotalPrice(), 0.01);
    }

    @Test
    public void testSetOutbound() {
        Booking booking = new Booking(new Flight("OB123", "Derry", "London", new Date(), new Time(), 100.0), null, new ArrayList<>());

        try {
            booking.setOutbound(null);
            fail("Expected IllegalArgumentException for null outbound Flight");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testSetInbound() {
        Booking booking = new Booking(new Flight("OB123", "Derry", "London", new Date(), new Time(), 100.0), null, new ArrayList<>());
        Flight newInbound = new Flight("IB456", "London", "Derry", new Date(), new Time(), 80.0);

        booking.setInbound(newInbound);
        assertEquals(newInbound, booking.getInbound());
    }

    @Test
    public void testSetPassengers() {
        Booking booking = new Booking(new Flight("OB123", "Derry", "London", new Date(), new Time(), 100.0), null, new ArrayList<>());
        ArrayList<Passenger> newPassengers = new ArrayList<>();
        newPassengers.add(new Passenger(new Name("Mrs", "Jane", "Doe"), "987654321", "jane@example.com", 2, true, null));

        booking.setPassengers(newPassengers);
        assertEquals(newPassengers, booking.getPassengers());
    }

    @Test
    public void testSetOutboundWithNull() {
        Booking booking = new Booking(new Flight("OB123", "Derry", "London", new Date(), new Time(), 100.0), null, new ArrayList<>());

        try {
            booking.setOutbound(null);
            fail("Expected IllegalArgumentException for null outbound Flight");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testSetPassengersWithIncorrectNumber() {
        Booking booking = new Booking(new Flight("OB123", "Derry", "London", new Date(), new Time(), 100.0), null, new ArrayList<>());
        ArrayList<Passenger> newPassengers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newPassengers.add(new Passenger(new Name("Mr", "Passenger", String.valueOf(i)), "123456789", "passenger@example.com", 1, false, null));
        }

        try {
            booking.setPassengers(newPassengers);
            fail("Expected IllegalArgumentException for incorrect number of passengers");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}