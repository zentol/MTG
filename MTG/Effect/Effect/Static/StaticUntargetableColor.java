package Effect.Static;

import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;

public class StaticUntargetableColor extends StaticEffect {
    private final int color;
    private final Permanent target;

    public StaticUntargetableColor(Card source, Permanent target, int color) {
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
        addUntargetableColor(source, target, color);
    }
}
