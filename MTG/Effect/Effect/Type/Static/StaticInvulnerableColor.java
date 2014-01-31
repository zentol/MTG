package Effect.Type.Static;

import Effect.Type.StaticEffect;
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
        addInvulnerablityColor(source, target, color);
    }
}
