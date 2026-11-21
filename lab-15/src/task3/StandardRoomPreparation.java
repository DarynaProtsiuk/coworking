package task3;

public class StandardRoomPreparation extends RoomPreparation {

    public StandardRoomPreparation(String roomNumber) {
        super(roomNumber);
    }

    @Override
    protected String getCategoryName() {
        return "Стандарт";
    }

    @Override
    protected void restockMinibar() {
        Logger.log(source(), "Етап: поповнення мінібару (базовий набір)");
    }

    @Override
    protected void checkEquipment() {
        Logger.log(source(), "Етап: перевірка обладнання (телевізор, кондиціонер)");
    }
}
