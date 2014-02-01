package Action;

import static Game.Game.activePlayer;
import static Game.Game.manapool;

public abstract class Mana {

    public static void addMana(String addition) {
        manapool.get(activePlayer).addMana(addition);
    }
}
