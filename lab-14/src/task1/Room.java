package task1;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int number;
    private final List<SubscriberInterface> observers = new ArrayList<>();

    public Room(int number) {
        this.number = number;
    }

    private String source() {
        return "Номер " + number;
    }

    public void subscribe(SubscriberInterface observer) {
        observers.add(observer);
        Logger.log(source(), observer.getName() + " підписався на події виїзду");
    }

    public void unsubscribe(SubscriberInterface observer) {
        observers.remove(observer);
        Logger.log(source(), observer.getName() + " відписався від подій виїзду");
    }

    public void checkOut(String guestName, boolean leftReview) {
        Logger.log(source(), "Гість " + guestName + " виїжджає. Сповіщаю підписників: " + observers.size());
        CheckOutEvent event = new CheckOutEvent(number, guestName, leftReview);
        for (SubscriberInterface observer : new ArrayList<>(observers)) {
            observer.onCheckOut(event);
        }
    }
}