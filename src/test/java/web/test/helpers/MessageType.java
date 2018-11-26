package web.test.helpers;

public enum MessageType {

    CREATED("CREATED"),
    UPDATED("UPDATED");

    private String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
