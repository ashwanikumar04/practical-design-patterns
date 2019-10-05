package in.ashwanik.pdp.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class TerrainTile {
    private Point location;
    private TerranMesh mesh;

    void draw() {
        mesh.draw(1, 1, location);
    }

}
