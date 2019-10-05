package in.ashwanik.pdp.behavioral.template;

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
