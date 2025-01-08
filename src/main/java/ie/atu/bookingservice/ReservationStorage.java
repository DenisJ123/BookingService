package ie.atu.bookingservice;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ReservationStorage {
    private final List<Reservation> reservations = new ArrayList<>();

    public Reservation addReservation(Long tableId, Long userId) {
        Reservation r = new Reservation(tableId, userId);
        reservations.add(r);
        return r;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
