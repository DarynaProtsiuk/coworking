package task3;

public abstract class RoomPreparation {

    protected final String roomNumber;

    protected RoomPreparation(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public final void prepare() {
        Logger.log(source(), "Початок підготовки номера");
        cleaning();
        changeLinen();
        restockMinibar();
        checkEquipment();
        prepareWelcomeBasket();
        lightFireplace();
        finalInspection();
        Logger.log(source(), "Номер готовий до заселення");
    }

    //Спільні етапи
    protected void cleaning() {
        Logger.log(source(), "Етап: прибирання за єдиним стандартом");
    }

    protected void changeLinen() {
        Logger.log(source(), "Етап: заміна білизни");
    }

    protected void finalInspection() {
        Logger.log(source(), "Етап: фінальний огляд");
    }

    //Обов'язкові етапи
    protected abstract void restockMinibar();

    protected abstract void checkEquipment();

    protected abstract String getCategoryName();

    //Хуки: за замовчуванням нічого не роблять
    protected void prepareWelcomeBasket() {
    }

    protected void lightFireplace() {
    }

    protected String source() {
        return getCategoryName() + " " + roomNumber;
    }
}