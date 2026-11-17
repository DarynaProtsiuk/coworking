package task1;

public interface SubscriberInterface {
    String getName();
    void onCheckOut(CheckOutEvent event);
}
