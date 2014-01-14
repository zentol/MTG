
package Effect.Type.Activated;

import static Action.Destroy.DestroyAll.destroyAll;
import Card.Permanent;
import Card.Spell;
import Condition.Condition;

public class Damnation extends Activated{
private final Spell source;
    
    public Damnation(Spell source){
        this.source=source;
    }
    
    public void execute(Permanent target){
        destroyAll(new Condition[0]);
    }
}
