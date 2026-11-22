package task1;

public class BonusPointsVisitor implements ChargeVisitor {

    private static final int UAH_PER_POINT = 10;

    private int totalPoints = 0;

    public int getTotalPoints() {
        return totalPoints;
    }

    private void addPoints(Charge charge) {
        int points = (int) (charge.getAmount() / UAH_PER_POINT);
        totalPoints += points;
        Logger.log("Бонуси", charge.getTitle() + ": +" + points + " балів");
    }

    @Override
    public void visit(AccommodationCharge charge) {
        addPoints(charge);
    }

    @Override
    public void visit(MealCharge charge) {
        addPoints(charge);
    }

    @Override
    public void visit(SpaCharge charge) {
        addPoints(charge);
    }

    @Override
    public void visit(RentalCharge charge) {
        addPoints(charge);
    }

    @Override
    public void visit(TouristTaxCharge charge) {
        Logger.log("Бонуси", charge.getTitle() + ": не враховується, 0 балів");
    }
}