package task1;

public class AccountingService implements SubscriberInterface {
    @Override
    public String getName() {
        return "Бухгалтерія";
    }

    @Override
    public void onCheckOut(CheckOutEvent event) {
        Logger.log(getName(), "Отримала сповіщення про виїзд. Рахунок гостя "
                + event.getGuestName() + " закрито");
    }
}
