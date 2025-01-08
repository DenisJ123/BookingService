package ie.atu.bookingservice;

public class Table {
    private Long id;
    private int tableNumber;
    private int seats;
    private boolean reserved;

    public Table() {}

    public Table(Long id, int tableNumber, int seats) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.seats = seats;
        this.reserved = false;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    public boolean isReserved() { return reserved; }
    public void setReserved(boolean reserved) { this.reserved = reserved; }
}

