import task3.*;

public class Main {
    public static void main(String[] args) {
        confirmViaExistingChannels();
        addNewChannel();
        confirmViaNewChannel();
    }

    private static void confirmViaExistingChannels() {
        Logger.log("Main", "Confirmation through existing channels");
        Creator[] channels = {
                new ReceptionCreator(),
                new SiteCreator(),
                new TourOperator()
        };

        for (Creator channel : channels) {
            channel.confirmBooking("Pankiv", "Lux");
        }
    }

    private static void addNewChannel() {
        Logger.log("Main", "Add new booking confirmation channel");
        Logger.log("Main", "Was added new classes OnlineServiceCreator and OnlineMessage." +
                " Creator and confirmBooking weren't changed");
    }

    private static void confirmViaNewChannel(){
        Logger.log("Main", "Confirmation via new channel");
        Creator online = new OnlineServiceCreator();
        online.confirmBooking("Zhykharevych", "Lux");
    }
}