package task1;

public interface ChargeVisitor {
    void visit(AccommodationCharge charge);
    void visit(MealCharge charge);
    void visit(SpaCharge charge);
    void visit(RentalCharge charge);
    void visit(TouristTaxCharge charge);
}
