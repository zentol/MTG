package Effect;

public abstract class Effect<A extends Effect> {
    private A action;
    
    public abstract void execute();
}
