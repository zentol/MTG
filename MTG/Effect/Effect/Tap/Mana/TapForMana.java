
package Effect.Tap.Mana;

import static Action.Mana.AddMana.addMana;
import Effect.Effect;
import Effect.Type.Activated.Activated;

public class TapForMana extends Effect<Activated>{
    private final String[] manaCreated;
    
    public TapForMana(String[] manaCreated){
        this.manaCreated=manaCreated;
    }
    
    public void execute(int option){
        addMana(manaCreated[option]);
    }

}
