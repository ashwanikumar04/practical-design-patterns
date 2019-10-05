package in.ashwanik.pdp.creational.abstract_factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Armoury {
    private static Armoury armoury;
    private static Random random = new Random();
    private List<Weapon> weapons;

    private Armoury() {
    }

    private static Armoury get() {
        if (armoury == null) {
            throw new IllegalStateException("Armoury is not ready");
        }
        return armoury;
    }

    static void fill() {
        Armoury armoury = new Armoury();
        Armoury.armoury = armoury;
        armoury.weapons = new ArrayList<>();
        armoury.weapons.add(new Dagger("dagger", "Useful for short range attacks", 50, 5, 20));
        armoury.weapons.add(new LongSword("long sword", "Useful for long range attacks", 150, 20, 40));
        armoury.weapons.add(new Mace("mace", "Good for brutal attacks", 250, 25, 50));
        armoury.weapons.add(new SpikeHammer("spike hammer", "Good for brutal attacks", 300, 30, 50));
    }

    static List<Weapon> getWeapons() {
        return get().weapons;
    }

    static Weapon getRandomWeapon() {
        return get().weapons.get(random.nextInt(get().numberOfWeapons()));
    }

    int numberOfWeapons() {
        return this.weapons.size();
    }
}
