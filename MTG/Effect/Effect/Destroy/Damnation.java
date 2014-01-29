package Effect.Destroy;

import static Action.Destroy.destroyAll;
import Card.Card;
import Card.Spell;
import Condition.Condition;
import Effect.Effect;

public class Damnation extends Effect {
    public Damnation(Spell source) {
        this.source = source;
    }

    @Override
    public void execute() {
        destroyAll(new Condition[0], source);
    }

    @Override
    public void setTargets(Card[] targets) {
    }
}
