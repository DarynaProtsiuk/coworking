package task3;

public class TourOperator extends Creator {
    public TourOperator(){
        super("TourOperator");
    }
    @Override
    protected Confirmation createConfirmation(String guest, String room){
        return new File(guest, room);
    }
}
