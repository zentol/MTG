package Ability.Resolve;

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
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
    }
}
