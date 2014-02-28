package Ability.Resolve;

import Card.Card;
import Ability.Ability;

public class ResolveEffect extends Resolve {
    private final int ownerID;
    private final Ability target;

    public ResolveEffect(Ability target) {
        this.target = target;
        this.ownerID = target.source.ownerID;
    }

    @Override
    protected void executeActions(Card ignored) {
        target.execute();
    }
}
