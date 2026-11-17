package task1;

public class MinibarService implements SubscriberInterface {
    @Override
    public String getName() {
        return "Мінібар";
    }

    @Override
    public void onCheckOut(CheckOutEvent event) {
        Logger.log(getName(), "Отримав сповіщення про виїзд. Перевіряю споживання в номері "
                + event.getRoomNumber());
    }
}