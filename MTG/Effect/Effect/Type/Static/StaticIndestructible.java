package Effect.Type.Static;

import Effect.Type.StaticEffect;
import static Action.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;

public class StaticIndestructible extends StaticEffect {
    private final Permanent target;

    public StaticIndestructible(Card source, Permanent target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public void execute() {
        addIndestructible(source, target);
    }

    @Override
    public void setTargets(Card[] targets) {
    }
}
