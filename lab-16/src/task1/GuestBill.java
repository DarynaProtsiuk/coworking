package task1;

import java.util.ArrayList;
import java.util.List;

public class GuestBill {

    private final String guestName;
    private final List<Charge> charges = new ArrayList<>();

    public GuestBill(String guestName) {
        this.guestName = guestName;
    }

    public void add(Charge charge) {
        charges.add(charge);
    }

    public double getTotal() {
        double total = 0;
        for (Charge charge : charges) {
            total += charge.getAmount();
        }
        return total;
    }

    public void accept(ChargeVisitor visitor) {
        for (Charge charge : charges) {
            charge.accept(visitor);
        }
    }

    public void logState(String stage) {
        Logger.log("Рахунок " + guestName, stage + ": нарахувань " + charges.size()
                + ", разом " + Logger.money(getTotal()));
        for (Charge charge : charges) {
            Logger.log("Рахунок " + guestName, "  - " + charge.getTitle()
                    + " = " + Logger.money(charge.getAmount()));
        }
    }
}
