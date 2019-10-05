package in.ashwanik.pdp.others.pub_sub;

public class MessagePublisher implements Publisher {
    private String name;

    MessagePublisher(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public <T> void publish(Message<T> message,
                            PublishService publishService) {
        message.setSender(name);
        message.setSentOn(System.currentTimeMillis());
        publishService.publish(message);
    }
}
