package task1;

public class MarketingService implements SubscriberInterface {
    @Override
    public String getName() {
        return "Маркетинг";
    }

    @Override
    public void onCheckOut(CheckOutEvent event) {
        if (event.hasLeftReview()) {
            Logger.log(getName(), "Гість " + event.getGuestName()
                    + " залишив відгук. Додаю його до матеріалів і надсилаю подяку");
        } else {
            Logger.log(getName(), "Гість " + event.getGuestName()
                    + " відгуку не залишив. Жодних дій не потрібно");
        }
    }
}
