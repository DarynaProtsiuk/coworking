package task1;

public class TaxCalculationVisitor implements ChargeVisitor {

    private static final double ACCOMMODATION_RATE = 0.07;
    private static final double STANDARD_RATE = 0.20;

    private double totalTax = 0;

    public double getTotalTax() {
        return totalTax;
    }

    private void applyTax(Charge charge, double rate) {
        double tax = charge.getAmount() * rate;
        totalTax += tax;
        Logger.log("Податки", charge.getTitle() + ": база " + Logger.money(charge.getAmount())
                + ", ставка " + (int) (rate * 100) + "% → податок " + Logger.money(tax));
    }

    @Override
    public void visit(AccommodationCharge charge) {
        applyTax(charge, ACCOMMODATION_RATE);
    }

    @Override
    public void visit(MealCharge charge) {
        applyTax(charge, STANDARD_RATE);
    }

    @Override
    public void visit(SpaCharge charge) {
        applyTax(charge, STANDARD_RATE);
    }

    @Override
    public void visit(RentalCharge charge) {
        applyTax(charge, STANDARD_RATE);
    }

    @Override
    public void visit(TouristTaxCharge charge) {
        Logger.log("Податки", charge.getTitle() + ": сам є податковим збором, ПДВ не нараховується");
    }
}