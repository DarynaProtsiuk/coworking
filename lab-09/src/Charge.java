public class Charge {
    private final String department;
    private final String description;
    private final int amount;

    public Charge(String department, String description, int amount) {
        this.department = department;
        this.description = description;
        this.amount = amount;
    }

    public String getDepartment() { return department; }
    public String getDescription() { return description; }
    public int getAmount() { return amount; }
}