package Card;

import static Card.Aspect.Aspect.KEY_ASPECT_PERMANENT;
import Card.Aspect.Permanent.ArtifactAspect;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Aspect.Permanent.EnchantmentAspect;
import Card.Aspect.Permanent.LandAspect;
import Card.Aspect.Permanent.PlaneswalkerAspect;
import Ability.Ability;
import Modifier.Modifier;

public class Permanent extends Card {
    private boolean untapped;

    public Permanent(int cardID, int instanceID, int ownerID, int controllerID, String name, String cost, int colors, boolean legendary) {
        super(cardID, instanceID, ownerID, controllerID, name, cost, colors, legendary, KEY_ASPECT_PERMANENT);
        this.untapped = true;
    }

//Aspect------------------------------------------------------------------------
    public void addArtifactAspect(String[] types) {
        aspects.add(new ArtifactAspect(types));
    }

    public void addCreatureAspect(int attack, int defense, String[] types) {
        aspects.add(new CreatureAspect(attack, defense, types));
    }

    public void addEnchantmentAspect(String[] types) {
        aspects.add(new EnchantmentAspect(types));
    }

    public void addLandAspect(String[] types) {
        aspects.add(new LandAspect(types));
    }

    public void addPlaneswalkerAspect(String[] types, int loyalty) {
        aspects.add(new PlaneswalkerAspect(types, loyalty));
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

//------------------------------------------------------------------------------
    public boolean hasEffect(Class<? extends Ability> effect) {
        for (int x = 0; x < effects.size(); x++) {
            if (effects.get(x).getClass().equals(effect)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasModifier(Class<? extends Modifier> modifier) {
        for (int x = 0; x < modifiers.size(); x++) {
            if (modifiers.get(x).getClass().equals(modifier)) {
                return true;
            }
        }
        return false;
    }
}
