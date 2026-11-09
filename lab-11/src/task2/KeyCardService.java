package task2;

public class KeyCardService {
    public void issue(String guestName, int room) {
        Log.write("KeyCard", "видано ключ-карту для номера " + room + " (" + guestName + ")");
    }

    public void reissue(String guestName, int room) {
        Log.write("KeyCard", "перевипущено ключ-карту для номера " + room + " (" + guestName + ")");
    }
}