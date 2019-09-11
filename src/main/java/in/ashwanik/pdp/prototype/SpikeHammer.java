package in.ashwanik.pdp.prototype;

import java.io.Serializable;

public class SpikeHammer extends Weapon implements Serializable {
    private static final long serialVersionUID = 1357475305567978168L;

    public SpikeHammer(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
