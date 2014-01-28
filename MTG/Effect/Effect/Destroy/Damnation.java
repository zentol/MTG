package Effect.Destroy;

import static Action.Destroy.destroyAll;
import Card.Permanent;
import Card.Spell;
import Condition.Condition;
import Effect.Effect;

public class Damnation extends Effect {
    private final Spell source;
    int test = 4 & 5;

    public Damnation(Spell source) {
        this.source = source;
    }

    public void execute(Permanent target) {
        destroyAll(new Condition[0], source);
    }
}
