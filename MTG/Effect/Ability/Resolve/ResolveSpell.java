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
        target.abilities.get(0).activate(select(target.abilities.get(0).targetCount));
        target.abilities.get(0).execute();
    }
}
