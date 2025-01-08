package ie.atu.bookingservice;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class TableStorage {
    private final Map<Long, Table> tables = new HashMap<>();
    private Long nextTableId = 1L;

    public Table addTable(int tableNumber, int seats) {
        Table t = new Table(nextTableId, tableNumber, seats);
        tables.put(nextTableId, t);
        nextTableId++;
        return t;
    }

    public List<Table> getAllTables() {
        return new ArrayList<>(tables.values());
    }

    public Table getTable(Long id) {
        return tables.get(id);
    }

    public void updateTable(Table table) {
        tables.put(table.getId(), table);
    }
}
