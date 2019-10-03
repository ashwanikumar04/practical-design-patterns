package in.ashwanik.pdp.mediator;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Message {
    private String topic;
    private String sender;
    private String receiver;
    private long sentOn;
    private long receivedOn;
    private String payload;

    byte[] getBytes() {
        return new Gson().toJson(this).getBytes();
    }
}
