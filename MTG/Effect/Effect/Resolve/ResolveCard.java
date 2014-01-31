package Effect.Resolve;

import Card.Card;
import Card.Permanent;
import Card.Spell;
import static Game.Game.battlefield;

public class ResolveCard extends Resolve {
    private final int ownerID;
    private final Card target;

    public ResolveCard(Card target) {
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
            battlefield.add((Permanent) target);
        }
        if (target.getClass().equals(Spell.class)) {
            //target.effect.execute();
            target.resetModifiers();
        }
    }
}
