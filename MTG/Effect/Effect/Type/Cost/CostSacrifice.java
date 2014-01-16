package Effect.Type.Cost;

import Card.Aspect.Aspect;
import Card.Card;
import Effect.Effect;

public class CostSacrifice extends Effect {
    private final Class<? extends Aspect> type;
    private final int count;

    public CostSacrifice(int count, Class<? extends Aspect> type) {
        this.count = count;
        this.type = type;
    }
    
    public void pay(Card[] sacrifices){
        for(Card sacrifice : sacrifices){
            //sacrifice(sacrifice);
        }
    }
}
