import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static void load() {
        manager.load("textures/colonist.png", Texture.class);
        manager.load("textures/ground.png", Texture.class);
        manager.finishLoading();
    }

    public static void dispose() {
        manager.dispose();
    }
}
