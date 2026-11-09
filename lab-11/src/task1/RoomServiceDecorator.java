package task1;

public abstract class RoomServiceDecorator implements Room {
    protected final Room wrapped;

    protected RoomServiceDecorator(Room wrapped) {
        this.wrapped = wrapped;
    }

    @Override // делегування
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice();
    }
}