package task1;

public class GuestRequest {
    private RequestType type;
    private String description;

    public GuestRequest(RequestType type, String description) {
        this.type = type;
        this.description = description;
    }

    public RequestType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
