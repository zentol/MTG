package Effect.Type.Static;

import Effect.Type.StaticEffect;
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
    public void execute() {
        addIndestructible(source, target);
    }

    @Override
    public void activate(Card[] targets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
