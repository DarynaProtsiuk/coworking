public class SkiPass {
    private int days;
    private String zone;

    public SkiPass(int days, String zone) {
        this.days = days;
        this.zone = zone;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString(){
        return "ski pass " + days + " days, " +zone + " zone";
    }

    public SkiPass copy(){
        return new SkiPass(days, zone);
    }

}

