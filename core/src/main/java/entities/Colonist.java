package entities;

import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Colonist {
    private NeedsSubject needs = new NeedsSubject();
    private StateMachine<Colonist> stateMachine;
    private TextureRegion texture;
    private Vector2 position = new Vector2();

    public Colonist() {
        this.texture = new TextureRegion(new Texture("colonist.png"));
        setupAI();
    }

    private void setupAI() {
        stateMachine = new StateMachine<>(this);
        stateMachine.setInitialState(IdleState.INSTANCE);

        // Register needs observer
        needs.addObserver((needType) -> {
            if(needType.equals("HUNGER")) {
                stateMachine.changeState(FindFoodState.INSTANCE);
            }
        });
    }

    public void update(float delta) {
        stateMachine.update();
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
}
