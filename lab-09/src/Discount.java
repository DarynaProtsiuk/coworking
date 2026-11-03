public class Discount {
    private String name;
    private int percent;

    public Discount(String name, int percent) {
        this.name = name;
        this.percent = percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString(){
        return "Discount( "  + name + ": " +percent+ " percent) ";
    }

    public Discount copy(){
        return new Discount(name, percent);
    }
}
