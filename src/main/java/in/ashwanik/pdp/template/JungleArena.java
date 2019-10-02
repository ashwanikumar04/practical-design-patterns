package in.ashwanik.pdp.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JungleArena extends Arena {

    private TreeMesh mesh;

    JungleArena(TreeMesh mesh) {
        this.mesh = mesh;
    }

    @Override
    void buildTerrain() {
        mesh.render();
    }

    @Override
    void setupImmovables() {
        log.info("Setup mountains, lakes etc.");
    }

    @Override
    void placeNemesis() {
        log.info("Place King Kong");
    }
}
