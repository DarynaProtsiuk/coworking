package task3;

public class ChaletPreparation extends RoomPreparation {

    public ChaletPreparation(String roomNumber) {
        super(roomNumber);
    }

    @Override
    protected String getCategoryName() {
        return "Шале";
    }

    @Override
    protected void restockMinibar() {
        Logger.log(source(), "Етап: поповнення мінібару (напої та закуски)");
    }

    @Override
    protected void checkEquipment() {
        Logger.log(source(), "Етап: перевірка обладнання (опалення, димохід, електроприлади)");
    }

    @Override
    protected void lightFireplace() {
        Logger.log(source(), "Етап: розпалювання каміна");
    }
}