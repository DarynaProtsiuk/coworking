package task2;

public class BillingService {
    public void openAccount(String guestName, int room) {
        Log.write("Billing", "відкрито рахунок для " + guestName + ", номер " + room);
    }
}
