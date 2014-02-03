package Effect.Resolve;

import Card.Card;
import Card.Permanent;
import Card.Spell;
import Effect.Effect;
import static Game.Game.battlefield;

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
