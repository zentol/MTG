
package Effect;

import static Action.Pay.payMana;
import Card.Permanent;

public class Pestilence {
    private String cost;
    public Pestilence(Permanent Source, String cost){
        this.cost=cost;
    }
    
    public void execute(){
        payMana(cost);
        //dealDamage();
    }

}
