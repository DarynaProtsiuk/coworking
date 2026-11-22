package task1;

public interface Charge {
    String getTitle();
    double getAmount();
    void accept(ChargeVisitor visitor);
}
