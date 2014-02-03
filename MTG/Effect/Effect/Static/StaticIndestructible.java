package Effect.Static;

import static Action.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;

public class StaticIndestructible extends StaticEffect {
    private final Permanent target;

    public StaticIndestructible(Card source, Permanent target) {
        super(false);
        this.source = source;
        this.target = target;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
        addIndestructible(this, target);
    }
}
