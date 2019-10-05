package in.ashwanik.pdp.behavioral.mediator;

class MessagePublisher implements Publisher {
    private String name;
    private MessageMediator messageMediator;

    MessagePublisher(String name,
                     MessageMediator messageMediator) {
        this.name = name;
        this.messageMediator = messageMediator;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void publish(Message message) {
        message.setSender(name);
        message.setSentOn(System.currentTimeMillis());
        messageMediator.send(message);
    }
}
