package in.ashwanik.pdp.command;

import java.util.Locale;


public class CommandDetail {
    private final String name;
    private final String info;

    CommandDetail(String name,
                  String info) {
        name = name.toLowerCase(Locale.ENGLISH);
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return getName() + " - " + getInfo();
    }

    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.info;
    }
}
