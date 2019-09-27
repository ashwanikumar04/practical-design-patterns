package in.ashwanik.pdp.flyweight;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TerrainUnitTest {
    @Test
    public void testTerrain() {
        TerrainSystem terrainSystem = new TerrainSystem(5, 5);
        terrainSystem.addTile(TerrainType.MOUNTAIN);
        terrainSystem.addTile(24, TerrainType.SAND);
        assertThat(terrainSystem.getNumberOfTiles()).isEqualTo(25);
    }
}
