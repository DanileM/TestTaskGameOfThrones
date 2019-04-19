package danilem.app.com.test;

public class Model {

    public static final int YOUR_MESSAGE_TYPE = 0;
    public static final int INTERLOCUTOR_MESSAGE_TYPE = 1;
    public static final int ADVERTISING_INTEGRATION_TYPE = 2;

    int type;
    String image;
    String message;
    String date;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
