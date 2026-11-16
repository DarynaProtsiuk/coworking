package task2;

public class ChargeEntry {
    private final String department;
    private final String description;
    private final int amount;
    private final String time;
    private final OperationType type;

    public ChargeEntry(String department, String description, int amount,
                       String time, OperationType type) {
        this.department = department;
        this.description = description;
        this.amount = amount;
        this.time = time;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "[" + time + "] " + department + " — " + description + ": "
                + String.format("%+d", amount) + " грн (" + type.getLabel() + ")";
    }
}
