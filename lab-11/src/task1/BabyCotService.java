package task1;

public class BabyCotService extends RoomServiceDecorator {
    private static final double COST = 200.0;

    public BabyCotService(Room wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + дитяче ліжко";
    }

    @Override
    public double getPrice() {
        double inner = wrapped.getPrice();
        Log.write("BabyCotService", "додає дитяче ліжко +" + COST + " грн до " + inner);
        return inner + COST;
    }
}
