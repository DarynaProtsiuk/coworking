package task3;

public class SiteCreator extends Creator {
    public SiteCreator(){
        super("Site");
    }
    @Override
    protected Confirmation createConfirmation(String guest, String room){
        return new Letter(guest, room);
    }
}
