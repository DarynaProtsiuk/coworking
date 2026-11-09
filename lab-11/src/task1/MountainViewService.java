package task1;

public class MountainViewService extends RoomServiceDecorator {
    private static final double COST = 400.0;

    public MountainViewService(Room wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + вид на гори";
    }

    @Override
    public double getPrice() {
        double inner = wrapped.getPrice();
        Log.write("MountainViewService", "додає вид на гори +" + COST + " грн до " + inner);
        return inner + COST;
    }
}