package in.ashwanik.pdp.pub_sub;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Message<T> {
    private String topic;
    private String sender;
    private String receiver;
    private long sentOn;
    private long receivedOn;
    private T payload;


    byte[] getBytes() {
        return new Gson().toJson(this).getBytes();
    }
}
