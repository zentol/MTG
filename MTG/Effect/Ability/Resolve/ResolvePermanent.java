package Ability.Resolve;

import static Action.PutIntoPlay.putIntoPlay;
import Card.Card;
import Card.Permanent;
import Card.Spell;
import Ability.Ability;

public class ResolvePermanent extends Resolve {
    private final int ownerID;
    private final Card target;

    public ResolvePermanent(Card target) {
        super();
        this.target = target;
        this.ownerID = target.ownerID;
    }

    @Override
    protected void executeActions(Card ignored) {
        if (target.getClass().equals(Permanent.class)) {
            putIntoPlay((Permanent) target);
        }
        if (target.getClass().equals(Spell.class)) {
            for (Ability effect : target.effects) {
                effect.execute();
            }
            target.resetModifiers();
        }
    }
}
