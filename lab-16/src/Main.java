import task1.*;

public class Main {

    public static void main(String[] args) {
        scenarioBillOperations();
    }

    // Ситуація 1 (Visitor): операції над нарахуваннями рахунку
    private static void scenarioBillOperations() {
        Logger.reset();
        Logger.section("Завдання 1: операції над нарахуваннями рахунку (Visitor)");

        GuestBill bill = new GuestBill("Іваненко О.");
        bill.add(new AccommodationCharge("Люкс", 5, 4000));
        bill.add(new MealCharge("Сніданки", 10, 350));
        bill.add(new SpaCharge("Масаж", 1800));
        bill.add(new RentalCharge("Лижі", 3, 600));
        bill.add(new TouristTaxCharge(5, 40));

        bill.logState("Стан рахунку до операцій");

        Logger.section("Операція 1: розрахунок податків");
        TaxCalculationVisitor taxes = new TaxCalculationVisitor();
        bill.accept(taxes);
        Logger.log("Податки", "Результат: усього податків " + Logger.money(taxes.getTotalTax()));

        Logger.section("Операція 2: нарахування бонусних балів");
        BonusPointsVisitor bonuses = new BonusPointsVisitor();
        bill.accept(bonuses);
        Logger.log("Бонуси", "Результат: усього " + bonuses.getTotalPoints() + " балів");

        Logger.section("Операція 3: звіт для туроператора (новий клас)");
        TourOperatorReportVisitor report = new TourOperatorReportVisitor();
        bill.accept(report);
        Logger.log("Звіт туроператору", "Результат: послуги " + Logger.money(report.getServicesTotal())
                + ", збори " + Logger.money(report.getTaxesTotal()));

        bill.logState("Стан рахунку після операцій (не змінився)");
    }
}