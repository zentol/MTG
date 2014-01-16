package Action.Mana;

import Action.Action;
import static Game.Game.activePlayer;
import static Game.Game.manapool;

public class AddMana extends Action {

    public static void addMana(String addition) {
        manapool.get(activePlayer).addMana(addition);
    }
}
