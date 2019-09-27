package in.ashwanik.pdp.flyweight;

import lombok.Getter;

import java.util.stream.IntStream;

public class TerrainSystem {

    private TerrainTile[][] terrain;
    @Getter
    private int numberOfTiles;
    private int row;
    private int column;
    private int currentRow = 0;
    private int currentColumn = 0;

    TerrainSystem(int length,
                  int width) {
        row = width;
        column = length;
        terrain = new TerrainTile[length][width];
    }

    void addTile(int numberOfTiles,
                 TerrainType terrainType) {
        IntStream.range(0, numberOfTiles).forEach(x -> addTile(terrainType));
    }

    void addTile(
            TerrainType terrainType) {
        if (currentRow < row) {
            if (currentColumn >= column) {
                currentColumn = 0;
                currentRow++;
            }
            TerrainTile terrainTile = new TerrainTile(
                    new Point(currentRow, currentColumn),
                    TerrainMeshClient.getInstance().getMesh(terrainType));
            terrain[currentRow][currentColumn] = terrainTile;
            currentColumn++;
            numberOfTiles++;
        } else {
            throw new IllegalArgumentException("Out of terrain");
        }
    }

    void draw() {
        for (TerrainTile[] terrainTiles : terrain) {
            for (int index = 0; index < column; index++) {
                TerrainTile terrainTile = terrainTiles[index];
                if (terrainTile != null) {
                    terrainTile.draw();
                }
            }
        }
    }
}
