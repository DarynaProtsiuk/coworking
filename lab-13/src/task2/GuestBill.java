package task2;

import java.util.ArrayList;
import java.util.List;

public class GuestBill {
    private final String guestName;
    private final List<ChargeEntry> entries = new ArrayList<>();

    public GuestBill(String guestName) {
        this.guestName = guestName;
    }

    public void addEntry(ChargeEntry entry) {
        entries.add(entry);
        Logger.log("GuestBill", "запис додано: " + entry + "; баланс: " + getBalance() + " грн");
    }

    public int getBalance() {
        int total = 0;
        for (ChargeEntry entry : entries) {
            total += entry.getAmount();
        }
        return total;
    }

    public void printBill() {
        Logger.log("GuestBill", "Рахунок гостя " + guestName);
        for (ChargeEntry entry : entries) {
            Logger.log("GuestBill", "  " + entry);
        }
        Logger.log("GuestBill", "Разом до сплати: " + getBalance() + " грн");
    }

    public void printHistory() {
        Logger.log("GuestBill", "Повна історія операцій, гість " + guestName);
        int number = 1;
        for (ChargeEntry entry : entries) {
            Logger.log("GuestBill", number + ". " + entry);
            number++;
        }
    }
}
