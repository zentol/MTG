package Ability.Resolve;

import static Action.Select.select;
import Card.Card;

public class ResolveSpell extends Resolve {
    private final int ownerID;
    private final Card target;

    public ResolveSpell(Card target) {
        super();
        this.target = target;
        this.ownerID = target.ownerID;
    }

    @Override
    protected void executeActions(Card target) {
        target.effects.get(0).activate(select(target.effects.get(0).targetCount));
        target.effects.get(0).execute();
    }
}
