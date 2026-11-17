package task1;

public class HousekeepingService implements SubscriberInterface {
    @Override
    public String getName() {
        return "Служба покоївок";
    }

    @Override
    public void onCheckOut(CheckOutEvent event) {
        Logger.log(getName(), "Отримала сповіщення про виїзд. Прибирання номера "
                + event.getRoomNumber() + " заплановано");
    }
}