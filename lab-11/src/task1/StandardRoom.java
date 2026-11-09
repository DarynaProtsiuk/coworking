package task1;

public class StandardRoom implements Room {
    private static final double BASE_PRICE = 2000.0;

    @Override
    public String getDescription() {
        return "Стандартний номер";
    }

    @Override
    public double getPrice() {
        Log.write("StandardRoom", "базова ціна за ніч: " + BASE_PRICE + " грн");
        return BASE_PRICE;
    }
}
