package ai;

import entities.Colonist;

public interface AIState {
    void enter(Colonist colonist);
    void update(Colonist colonist);
    void exit(Colonist colonist);
}
