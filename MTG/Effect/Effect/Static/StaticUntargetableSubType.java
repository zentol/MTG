package Effect.Static;

import static Action.Protection.addUntargetableSubType;
import Card.Card;
import Card.Permanent;

public class StaticUntargetableSubType extends StaticEffect {
    private final String[] subTypes;
    private final Permanent target;

    public StaticUntargetableSubType(Card source, Permanent target, String[] subTypes) {
        super(false);
        this.subTypes = subTypes;
        this.source = source;
        this.target = target;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
        addUntargetableSubType(source, target, subTypes);
    }
}
