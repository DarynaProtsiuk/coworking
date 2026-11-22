package task1;

public class SpaCharge implements Charge {

    private final String procedure;
    private final double price;

    public SpaCharge(String procedure, double price) {
        this.procedure = procedure;
        this.price = price;
    }

    public String getProcedure() {
        return procedure;
    }

    @Override
    public String getTitle() {
        return "SPA (" + procedure + ")";
    }

    @Override
    public double getAmount() {
        return price;
    }

    @Override
    public void accept(ChargeVisitor visitor) {
        visitor.visit(this);
    }
}