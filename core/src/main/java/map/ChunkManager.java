package map;

import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.math.Vector2;

public class ChunkManager {
    private final ObjectMap<Vector2, Chunk> activeChunks = new ObjectMap<>();

    public void loadChunk(int x, int y) {
        Vector2 key = new Vector2(x, y);
        if (!activeChunks.containsKey(key)) {
            Chunk chunk = new Chunk(x, y);
            activeChunks.put(key, chunk);
        }
    }

    public void unloadChunk(int x, int y) {
        activeChunks.remove(new Vector2(x, y));
    }
}
