package Effect.Resolve;

import static Action.PutIntoPlay.putIntoPlay;
import Card.Card;
import Card.Permanent;
import Card.Spell;
import Effect.Effect;

public class ResolvePermanent extends Resolve {
    private final int ownerID;
    private final Card target;

    public ResolvePermanent(Card target) {
        super();
        this.target = target;
        this.ownerID = target.ownerID;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
        if (target.getClass().equals(Permanent.class)) {
            putIntoPlay((Permanent) target);
        }
        if (target.getClass().equals(Spell.class)) {
            for (Effect effect : target.effects) {
                effect.execute();
            }
            target.resetModifiers();
        }
    }
}
