package task1;

public class LateCheckoutService extends RoomServiceDecorator {
    private static final double COST = 500.0;

    public LateCheckoutService(Room wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + пізній виїзд";
    }

    @Override
    public double getPrice() {
        double inner = wrapped.getPrice();
        Log.write("LateCheckoutService", "додає пізній виїзд +" + COST + " грн до " + inner);
        return inner + COST;
    }
}
