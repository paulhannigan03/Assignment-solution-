package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {
    private Flight outbound;
    private Flight inbound;
    private ArrayList<Passenger> passengers;
    private double totalPrice;
    private int bookingNo;
    private static int nextUniqueBookingNumber = 10000;

    public Booking(Flight oF, Flight iF, ArrayList<Passenger> p) {
        if (oF == null || p == null || p.isEmpty() || p.size() > 9) {
            throw new IllegalArgumentException("Invalid arguments for Booking");
        }

        this.outbound = oF;
        this.inbound = iF;
        this.passengers = p;
        this.bookingNo = nextUniqueBookingNumber++;

        // Calculate total price
        this.totalPrice = calculatePrice();
    }

    public Flight getOutbound() {
        return outbound;
    }

    public Flight getInbound() {
        return inbound;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Booking No: ").append(bookingNo).append("\n");
        result.append("Outbound Flight: ").append(outbound).append("\n");

        if (inbound != null) {
            result.append("Inbound Flight: ").append(inbound).append("\n");
        }

        result.append("Passengers:\n");
        for (Passenger passenger : passengers) {
            result.append(passenger).append("\n");
        }

        result.append("Total Price: ").append(totalPrice).append("\n");

        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Booking booking = (Booking) obj;

        return bookingNo == booking.bookingNo &&
                Double.compare(booking.totalPrice, totalPrice) == 0 &&
                outbound.equals(booking.outbound) &&
                (inbound == null ? booking.inbound == null : inbound.equals(booking.inbound)) &&
                passengers.equals(booking.passengers);
    }

    public boolean findPassenger(Passenger p) {
        return passengers.contains(p);
    }

    public double calculatePrice() {
        double outboundPrice = outbound.getPrice();
        double inboundPrice = (inbound != null) ? inbound.getPrice() : 0.0;
        int passengerCount = passengers.size();

        return (outboundPrice + inboundPrice) * passengerCount;
    }

    // Additional setter methods
    public void setOutbound(Flight outbound) {
        if (outbound == null) {
            throw new IllegalArgumentException("Outbound Flight cannot be null");
        }
        this.outbound = outbound;
        this.totalPrice = calculatePrice(); // Recalculate total price after changing outbound
    }

    public void setInbound(Flight inbound) {
        this.inbound = inbound;
        this.totalPrice = calculatePrice(); // Recalculate total price after changing inbound
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        if (passengers == null || passengers.isEmpty() || passengers.size() > 9) {
            throw new IllegalArgumentException("Invalid number of passengers");
        }
        this.passengers = passengers;
        this.totalPrice = calculatePrice(); // Recalculate total price after changing passengers
    }
}
