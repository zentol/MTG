package Effect.Spell;

import Effect.SpellEffect;
import static Action.Destroy.destroyAll;
import Card.Card;
import Condition.Condition;

public class Damnation extends SpellEffect {
    public Damnation() {
        super(0);
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
