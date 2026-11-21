package task3;

public class FamilyRoomPreparation extends RoomPreparation {

    public FamilyRoomPreparation(String roomNumber) {
        super(roomNumber);
    }

    @Override
    protected String getCategoryName() {
        return "Сімейний номер";
    }

    @Override
    protected void restockMinibar() {
        Logger.log(source(), "Етап: поповнення мінібару (соки та дитячі снеки)");
    }

    @Override
    protected void checkEquipment() {
        Logger.log(source(), "Етап: перевірка обладнання (телевізор, дитяче ліжечко, розетки із захистом)");
    }
}