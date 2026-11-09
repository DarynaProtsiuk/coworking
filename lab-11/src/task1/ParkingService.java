package task1;

public class ParkingService extends RoomServiceDecorator {
    private static final double COST = 150.0;

    public ParkingService(Room wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + паркування";
    }

    @Override
    public double getPrice() {
        double inner = wrapped.getPrice();
        Log.write("ParkingService", "додає паркування +" + COST + " грн до " + inner);
        return inner + COST;
    }
}
