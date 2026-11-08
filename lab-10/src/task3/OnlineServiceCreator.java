package task3;

public class OnlineServiceCreator extends Creator {
    public OnlineServiceCreator(){
        super("OnlineService");
    }
    @Override
    protected Confirmation createConfirmation(String guest, String room){
        return new OnlineMessage(guest, room);
    }
}
