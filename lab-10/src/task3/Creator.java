package task3;

public abstract class Creator {
    private final String channelName;

    protected Creator(String channelName) {
        this.channelName = channelName;
    }

    protected abstract Confirmation createConfirmation (String guest, String room);

    public final void confirmBooking(String guest, String room) {
        Logger.log(channelName, "Checking the availability of the room \"" + room + "\".");
        Logger.log(channelName, "Booking is fixed for the guest - " + guest + ".");

        Confirmation confirmation = createConfirmation(guest, room);
        Logger.log(channelName,  "Confirmation is created:\n" + confirmation.getMessage());

        Logger.log(channelName, "Confirmation is sent.");
    }
}



