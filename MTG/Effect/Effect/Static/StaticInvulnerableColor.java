package Effect.Static;

import static Action.Protection.addInvulnerablityColor;
import Card.Card;
import Card.Permanent;

public class StaticInvulnerableColor extends StaticEffect {
    private final int color;
    private final Permanent target;

    public StaticInvulnerableColor(Card source, Permanent target, int color) {
        super(false);
        this.color = color;
        this.source = source;
        this.target = target;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
        addInvulnerablityColor(this, target, color);
    }
}
