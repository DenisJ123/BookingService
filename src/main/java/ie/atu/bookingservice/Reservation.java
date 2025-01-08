package ie.atu.bookingservice;

public class Reservation {
    private Long tableId;
    private Long userId;

    public Reservation() {}
    public Reservation(Long tableId, Long userId) {
        this.tableId = tableId;
        this.userId = userId;
    }
    // getters and setters
    public Long getTableId() { return tableId; }
    public void setTableId(Long tableId) { this.tableId = tableId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
