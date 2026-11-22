package task1;

public class TouristTaxCharge implements Charge {

    private final int nights;
    private final double taxPerNight;

    public TouristTaxCharge(int nights, double taxPerNight) {
        this.nights = nights;
        this.taxPerNight = taxPerNight;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String getTitle() {
        return "Туристичний збір (" + nights + " ночей)";
    }

    @Override
    public double getAmount() {
        return nights * taxPerNight;
    }

    @Override
    public void accept(ChargeVisitor visitor) {
        visitor.visit(this);
    }
}