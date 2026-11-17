package task1;

public class KeyLockSystem implements SubscriberInterface {
    @Override
    public String getName() {
        return "Система замків";
    }

    @Override
    public void onCheckOut(CheckOutEvent event) {
        Logger.log(getName(), "Отримала сповіщення про виїзд. Ключ-карту номера "
                + event.getRoomNumber() + " анульовано");
    }
}