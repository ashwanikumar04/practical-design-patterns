package in.ashwanik.pdp.template;

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
