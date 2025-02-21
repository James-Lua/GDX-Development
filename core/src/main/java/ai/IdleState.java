package ai;

import entities.Colonist;

public class IdleState implements AIState {
    @Override
    public void enter(Colonist colonist) {
        // Logic when entering idle state
    }

    @Override
    public void update(Colonist colonist) {
        // Logic to check for new jobs or needs
    }

    @Override
    public void exit(Colonist colonist) {
        // Cleanup logic
    }
}
