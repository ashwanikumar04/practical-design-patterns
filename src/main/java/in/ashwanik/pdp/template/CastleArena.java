package in.ashwanik.pdp.template;

public class CastleArena extends Arena {
    private CastleMesh mesh;

    CastleArena(CastleMesh mesh) {
        this.mesh = mesh;
    }

    @Override
    void buildTerrain() {
        mesh.render();
    }

    @Override
    void setupImmovables() {

    }

    @Override
    void placeNemesis() {

    }
}
