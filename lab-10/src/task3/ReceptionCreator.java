package task3;

public class ReceptionCreator extends Creator {
    public ReceptionCreator(){
        super("Reception");
    }
    @Override
    protected Confirmation createConfirmation(String guest, String room){
        return new Blank(guest, room);
    }
}
