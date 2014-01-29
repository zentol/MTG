package Effect.Resolve;

import Card.Card;
import Card.Permanent;
import Card.Spell;
import Effect.Effect;
import static Game.Game.battlefield;

public class Resolve extends Effect {
    private final int ownerID;
    private final Card target;

    public Resolve(Card target) {
        this.target = target;
        this.ownerID = target.ownerID;
    }

    public void execute() {
        if (target.getClass().equals(Permanent.class)) {
            battlefield.add((Permanent) target);
        }
        if (target.getClass().equals(Spell.class)) {
            //target.effect.execute();
            target.resetModifiers();
        }
    }
}
