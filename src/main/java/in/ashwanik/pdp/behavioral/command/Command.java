package in.ashwanik.pdp.behavioral.command;

public abstract class Command {

    private final CommandDetail description;

    Command(String name,
            String info) {
        description = new CommandDetail(name, info);
    }

    CommandDetail getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Command command = (Command) object;
        return description.getName().equals(command.description.getName());
    }

    @Override
    public int hashCode() {
        return description.getName().hashCode();
    }

    abstract void execute(String[] arguments);

    @Override
    public String toString() {
        return description.toString();
    }

}
