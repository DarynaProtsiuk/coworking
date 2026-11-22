package task1;

public class MealCharge implements Charge {

    private final String mealType;
    private final int portions;
    private final double pricePerPortion;

    public MealCharge(String mealType, int portions, double pricePerPortion) {
        this.mealType = mealType;
        this.portions = portions;
        this.pricePerPortion = pricePerPortion;
    }

    public String getMealType() {
        return mealType;
    }

    public int getPortions() {
        return portions;
    }

    @Override
    public String getTitle() {
        return "Харчування (" + mealType + ", " + portions + " порцій)";
    }

    @Override
    public double getAmount() {
        return portions * pricePerPortion;
    }

    @Override
    public void accept(ChargeVisitor visitor) {
        visitor.visit(this);
    }
}