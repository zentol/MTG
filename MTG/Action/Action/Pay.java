package Action;

import static Game.Game.activePlayer;
import static Game.Game.manapool;

public class Pay {
    public static void payMana(String cost) {
        manapool.get(activePlayer).useMana(cost);
    }
}
