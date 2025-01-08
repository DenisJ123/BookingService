package ie.atu.bookingservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final TableStorage tableStorage;
    private final ReservationStorage reservationStorage;
    private final UserClient userClient;

    public BookingController(TableStorage tableStorage, ReservationStorage reservationStorage, UserClient userClient) {
        this.tableStorage = tableStorage;
        this.reservationStorage = reservationStorage;
        this.userClient = userClient;
    }

    @PostMapping("/tables")
    public ResponseEntity<Table> addTable(@RequestParam int tableNumber, @RequestParam int seats) {
        Table t = tableStorage.addTable(tableNumber, seats);
        return ResponseEntity.ok(t);
    }

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> listTables() {
        return ResponseEntity.ok(tableStorage.getAllTables());
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestParam Long userId, @RequestParam Long tableId) {
        // Check user from User Service
        boolean userExists = userClient.checkUserExists(userId);
        if (!userExists) {
            return ResponseEntity.badRequest().build();
        }

        // Check table
        Table t = tableStorage.getTable(tableId);
        if (t == null || t.isReserved()) {
            return ResponseEntity.badRequest().build();
        }

        t.setReserved(true);
        tableStorage.updateTable(t);

        Reservation r = reservationStorage.addReservation(tableId, userId);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        return ResponseEntity.ok(reservationStorage.getAllReservations());
    }
}
