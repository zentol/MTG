package Effect.Destroy;

import static Action.Destroy.destroyAll;
import Card.Card;
import Card.Spell;
import Condition.Condition;
import Effect.Effect;

public class Damnation extends Effect {
    public Damnation(Spell source) {
        super(false);
        this.source = source;
    }

    @Override
    public void activate(Card[] targets) {
        //check play conditions        
    }

    @Override
    public void execute() {
        destroyAll(new Condition[0], source);
    }
}
