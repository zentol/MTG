package Effect.Type.Static;

import static Action.temp.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;

public class StaticIndestructible extends Static {
    private final Card source;
    private final Permanent target;

    public StaticIndestructible(Card source, Permanent target) {
        this.source = source;
        this.target = target;
    }
    
    public void execute(){
        addIndestructible(source,target);
    }
}
