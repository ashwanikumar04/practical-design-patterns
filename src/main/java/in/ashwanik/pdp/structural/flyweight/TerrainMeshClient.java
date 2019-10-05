package in.ashwanik.pdp.structural.flyweight;

import java.util.EnumMap;

public class TerrainMeshClient {
    private static TerrainMeshClient instance = new TerrainMeshClient();
    private EnumMap<TerrainType, TerranMesh> meshMap;

    private TerrainMeshClient() {
        meshMap = new EnumMap<>(TerrainType.class);
        meshMap.put(TerrainType.MOUNTAIN, new MountainMesh());
        meshMap.put(TerrainType.SAND, new SandMesh());
        meshMap.put(TerrainType.WATER, new WaterMesh());
    }

    public static TerrainMeshClient getInstance() {
        return instance;
    }

    public TerranMesh getMesh(TerrainType type) {
        return meshMap.get(type);
    }
}
