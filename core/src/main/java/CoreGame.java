import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import entities.Colonist;
import jobs.JobManager;
import map.Map;

import java.util.ArrayList;
import java.util.List;

public class CoreGame extends ApplicationAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Map map;
    private JobManager jobManager;
    private List<Colonist> colonists;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();

        // Initialize systems
        map = new Map(new RandomMapGenerator());
        jobManager = JobManager.getInstance();
        colonists = new ArrayList<>();

        // Spawn initial colonists
        for(int i = 0; i < 5; i++) {
            colonists.add(new Colonist());
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update systems
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);

        // Render
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        map.render(batch);
        for(Colonist c : colonists) c.render(batch);
        batch.end();
    }

    private void update(float delta) {
        for(Colonist c : colonists) c.update(delta);
        jobManager.update(delta);
    }
}
