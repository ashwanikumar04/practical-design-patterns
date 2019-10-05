package in.ashwanik.pdp.behavioral.template;

abstract class Arena {

    void build() {
        buildTerrain();
        setupImmovables();
        placeNemesis();
    }

    abstract void buildTerrain();

    abstract void setupImmovables();

    abstract void placeNemesis();
}
