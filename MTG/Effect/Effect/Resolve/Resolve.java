package Effect.Resolve;

import Effect.Effect;

public abstract class Resolve extends Effect {

    public Resolve() {
        super(0);
    }

    @Override
    public int getType() {
        return 0;
    }
}
