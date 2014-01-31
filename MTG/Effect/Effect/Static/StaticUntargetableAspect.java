package Effect.Static;

import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;

public class StaticUntargetableAspect extends StaticEffect {
    private final int aspect;
    private final Permanent target;

    public StaticUntargetableAspect(Card source, Permanent target, int aspect) {
        super(false);
        this.aspect = aspect;
        this.source = source;
        this.target = target;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
        addUntargetableColor(source, target, aspect);
    }
}
