package task1;

public class BreakfastService extends RoomServiceDecorator {
    private static final double COST = 300.0;

    public BreakfastService(Room wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + сніданок";
    }

    @Override
    public double getPrice() {
        double inner = wrapped.getPrice();
        Log.write("BreakfastService", "додає сніданок +" + COST + " грн до " + inner);
        return inner + COST;
    }
}
