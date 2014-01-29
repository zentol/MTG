
package Effect.Resolve;

import Card.Card;
import Effect.Effect;

public class ResolveEffect extends Resolve{
    private final int ownerID;
    private final Effect target;

    public ResolveEffect(Effect target) {
        this.target = target;
        this.ownerID = target.source.ownerID;
    }

    @Override
    public void execute() {
        target.execute();
    }

    @Override
    public void setTargets(Card[] targets) {
    }
}
