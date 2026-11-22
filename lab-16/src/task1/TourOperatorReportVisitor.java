package task1;

public class TourOperatorReportVisitor implements ChargeVisitor {

    private double servicesTotal = 0;
    private double taxesTotal = 0;

    public double getServicesTotal() {
        return servicesTotal;
    }

    public double getTaxesTotal() {
        return taxesTotal;
    }

    private void addService(String category, Charge charge) {
        servicesTotal += charge.getAmount();
        Logger.log("Звіт туроператору", category + ": " + charge.getTitle()
                + " = " + Logger.money(charge.getAmount()));
    }

    @Override
    public void visit(AccommodationCharge charge) {
        addService("Проживання", charge);
    }

    @Override
    public void visit(MealCharge charge) {
        addService("Харчування", charge);
    }

    @Override
    public void visit(SpaCharge charge) {
        addService("Додаткові послуги", charge);
    }

    @Override
    public void visit(RentalCharge charge) {
        addService("Додаткові послуги", charge);
    }

    @Override
    public void visit(TouristTaxCharge charge) {
        taxesTotal += charge.getAmount();
        Logger.log("Звіт туроператору", "Збори: " + charge.getTitle()
                + " = " + Logger.money(charge.getAmount()));
    }
}
