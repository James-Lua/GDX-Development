package map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Map {
    private com.yourgame.core.map.ChunkManager chunkManager;
    private TextureRegion groundTexture;

    public Map(MapGenerator generator) {
        this.groundTexture = new TextureRegion(new Texture("ground.png"));
        this.chunkManager = new com.yourgame.core.map.ChunkManager();
        generator.generate(this);
    }

    public void render(SpriteBatch batch) {
        // Render visible chunks
        for(Chunk chunk : chunkManager.getActiveChunks()) {
            batch.draw(groundTexture, chunk.getX(), chunk.getY());
        }
    }
}
