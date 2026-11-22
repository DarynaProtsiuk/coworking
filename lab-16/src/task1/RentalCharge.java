package task1;

public class RentalCharge implements Charge {

    private final String item;
    private final int days;
    private final double pricePerDay;

    public RentalCharge(String item, int days, double pricePerDay) {
        this.item = item;
        this.days = days;
        this.pricePerDay = pricePerDay;
    }

    public String getItem() {
        return item;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String getTitle() {
        return "Прокат (" + item + ", " + days + " дні)";
    }

    @Override
    public double getAmount() {
        return days * pricePerDay;
    }

    @Override
    public void accept(ChargeVisitor visitor) {
        visitor.visit(this);
    }
}