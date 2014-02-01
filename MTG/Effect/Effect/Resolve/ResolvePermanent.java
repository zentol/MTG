package Effect.Resolve;

import Card.Card;
import Card.Permanent;
import Card.Spell;
import Effect.Effect;
import static Game.Game.battlefield;

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
            battlefield.add((Permanent) target);
        }
        if (target.getClass().equals(Spell.class)) {
            for(Effect effect:target.effects){
                effect.execute();
            }
            target.resetModifiers();
        }
    }
}
