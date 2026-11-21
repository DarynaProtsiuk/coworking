package task3;

public class LuxuryRoomPreparation extends RoomPreparation {

    public LuxuryRoomPreparation(String roomNumber) {
        super(roomNumber);
    }

    @Override
    protected String getCategoryName() {
        return "Люкс";
    }

    @Override
    protected void restockMinibar() {
        Logger.log(source(), "Етап: поповнення мінібару (напої та закуски)");
    }

    @Override
    protected void checkEquipment() {
        Logger.log(source(), "Етап: перевірка обладнання (телевізор, кондиціонер, кавомашина)");
    }

    @Override
    protected void prepareWelcomeBasket() {
        Logger.log(source(), "Етап: приготування вітального кошика");
    }
}
