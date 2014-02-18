package Effect.Spell;

import static Action.Destroy.destroyAll;
import Card.Card;
import Card.Spell;
import Condition.Condition;

public class Damnation extends SpellEffect {
    public Damnation(Spell source) {
        super(0);
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
