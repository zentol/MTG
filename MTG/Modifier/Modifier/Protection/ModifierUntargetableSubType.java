
package Modifier.Protection;

import Card.Aspect.Aspect;
import Card.Card;

public class ModifierUntargetableSubType extends TargetingModifier{
    private String[] subTypes;
    
    public ModifierUntargetableSubType(Card source, String[] subTypes){
        super(source);
        this.subTypes=subTypes;
    }

    @Override
    public boolean preventsTargeting(Card targeter) {
        boolean preventsTargeting = false;
        for(int x=0;x<targeter.aspects.size();x++){
            for(int y=0;y<targeter.aspects.get(x).subType.size();y++){
                for(int z=0;z<subTypes.length;z++){
                    preventsTargeting |= (targeter.aspects.get(x).subType.get(y).compareTo(subTypes[z])==0);
                }
            }
        }
        return preventsTargeting;
    }
}
