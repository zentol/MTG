package Card;

import Card.Aspect.Permanent.LandAspect;
import Card.Aspect.Permanent.ArtifactAspect;
import Card.Aspect.Permanent.PlaneswalkerAspect;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Aspect.Permanent.EnchantmentAspect;
import Card.Aspect.Permanent.PermanentAspect;
import Effect.Effect;

public class Permanent extends Card<PermanentAspect> {
    private boolean untapped;

    public Permanent(int cardID, int instanceID, int ownerID, int controllerID, String name, String cost, String colors, boolean legendary) {
        super(cardID, instanceID, ownerID, controllerID, name, cost, colors, legendary);
        this.untapped = true;
    }

//Aspect------------------------------------------------------------------------
    public void addArtifactAspect(String[] types) {
        aspects.add(new ArtifactAspect(types));
    }

    public void addCreatureAspect(int attack, int defense, String[] types, Effect[] effects) {
        aspects.add(new CreatureAspect(attack, defense, types, effects));
    }

    public void addEnchantmentAspect(String[] types) {
        aspects.add(new EnchantmentAspect(types));
    }

    public void addLandAspect(String[] types) {
        aspects.add(new LandAspect(types));
    }

    public void addPlaneswalkerAspect(String[] types) {
        aspects.add(new PlaneswalkerAspect(types));
    }
    
    public PermanentAspect getAspect(Class<? extends PermanentAspect> aspect) {
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getClass().equals(aspect)) {
                return aspects.get(x);
            }
        }
        return null;
    }

//Tap---------------------------------------------------------------------------
    public boolean isTapped() {
        return !untapped;
    }

    public void tap() {
        untapped = false;
    }

    public void untap() {
        untapped = true;
    }
}
