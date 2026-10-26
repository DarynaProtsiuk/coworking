package task2;

import java.math.BigDecimal;

// Опис предметної області: Логістичний оператор та служба доставки.
// Завдання коду: Розрахунок вартості транспортування посилки залежно від обраного типу доставки.

public class Task2 {
    public static void main(String[] args) {

        Parcel parcel = new Parcel(
                "UA123456",
                new BigDecimal("6.00"),
                new BigDecimal("0.40"),
                new BigDecimal("100.00")
        );

        ShippingCostCalculator calculator = new ShippingCostCalculator();

        BigDecimal standardCost = calculator.calculateCost(parcel, new StandardCourierStrategy());
        System.out.println("Standard courier cost: $" + standardCost);

        BigDecimal expressCost = calculator.calculateCost(parcel, new ExpressAirStrategy());
        System.out.println("Express air cost: $" + expressCost);


        BigDecimal overnightCost = calculator.calculateCost(parcel, new OvernightExpressStrategy());
        System.out.println("Overnight express cost: $" + overnightCost);

        BigDecimal lockerCost = calculator.calculateCost(parcel, new LockerPickupStrategy());
        System.out.println("Locker pickup cost: $" + lockerCost);
        }
    }
