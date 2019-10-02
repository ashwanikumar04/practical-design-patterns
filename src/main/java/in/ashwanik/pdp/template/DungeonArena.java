package in.ashwanik.pdp.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DungeonArena extends Arena {
    private CaveMesh mesh;

    DungeonArena(CaveMesh mesh) {
        this.mesh = mesh;
    }

    @Override
    void buildTerrain() {
        mesh.render();
    }

    @Override
    void setupImmovables() {
        log.info("setup traps etc");
    }

    @Override
    void placeNemesis() {
        log.info("Place Dragon");
    }
}
