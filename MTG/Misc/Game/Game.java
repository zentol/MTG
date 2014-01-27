package Game;

import Collection.Battlefield;
import Collection.Exile;
import Collection.Graveyard;
import Collection.Hand;
import Collection.Library;
import Collection.Stack;
import Condition.Card.ConditionController;
import Effect.Effect;
import java.util.ArrayList;
import static Action.Destroy.destroyAll;
import static Action.Mana.addMana;
import static Action.Play.play;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Card;
import Card.Permanent;
import Collection.Manapool;
import Condition.Condition;
import Game.Phase.*;
import static Game.Phase.Beginning.phaseBeginning;
import static Game.Phase.Combat.phaseCombat;
import static Game.Phase.Ending.phaseEnding;
import static Game.Phase.Main.phasePostMain;
import static Game.Phase.Main.phasePreMain;

public class Game {
    public static final ArrayList<Boolean> player = new ArrayList();
    public static final ArrayList<Hand> hand = new ArrayList();
    public static final ArrayList<Library> library = new ArrayList();
    public static final ArrayList<Graveyard> graveyard = new ArrayList();
    public static final ArrayList<Exile> exile = new ArrayList();
    public static final ArrayList<Manapool> manapool = new ArrayList();
    public static final ArrayList<Integer> lifepoints = new ArrayList();
    public static final Battlefield battlefield = new Battlefield();
    public static final Stack stack = new Stack();
    public static final ArrayList<Effect> effects = new ArrayList();

    public static int activePlayer = 0;

    public Game(int playerCount) {
        for (int x = 0; x < playerCount; x++) {
            addPlayer();
        }
    }

//turn--------------------------------------------------------------------------
    public static void turn() {
        phaseBeginning();
        phasePreMain();
        phaseCombat();
        phasePostMain();
        phaseEnding();
    }

    public static void untapPhase() {
        for (int x = 0; x < battlefield.size(); x++) {
            if (battlefield.get(x).isController(activePlayer)) {
                battlefield.get(x).untap();
            }
        }
    }

    public static void drawPhase() {
        hand.get(activePlayer).add(library.get(activePlayer).draw(1));
        if (hand.get(activePlayer).size() > 7) {
            //hand.get(activePlayer).discard(hand.get(activePlayer).size() - 7);
        }
    }

    public static void mainPhase() {
        addMana(hand.get(activePlayer).get(0).cost);
        play(hand.get(activePlayer).get(0));
        play(hand.get(activePlayer).get(1));
        stack.resolveStack();
    }

    public static void endTurn() {
        activePlayer++;
        activePlayer %= lifepoints.size();
        if (!player.get(activePlayer)) {
            endTurn();
        }
    }

    public static void addPlayer() {
        player.add(true);
        hand.add(new Hand());
        library.add(new Library());
        graveyard.add(new Graveyard());
        exile.add(new Exile());
        manapool.add(new Manapool());
        lifepoints.add(20);
    }

    public static void removePlayer(int playerID) {
        player.set(playerID, false);
        destroyAll(new Condition[]{new ConditionController(playerID)});
        hand.remove(playerID);
        library.remove(playerID);
        graveyard.remove(playerID);
        exile.remove(playerID);
        lifepoints.remove(playerID);
        manapool.remove(playerID);
    }

    public static void dummyLoadLibrary() {
        Permanent card;
        for (int x = 0; x < 25; x++) {
            card = new Permanent(1, 1, 0, 1, "Footsoldier", "W", "W", false);
            card.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
            library.get(0).add(card);
        }
        for (int x = 0; x < 25; x++) {
            card = new Permanent(1, 1, 0, 1, "Footsoldier", "W", "W", false);
            card.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
            library.get(1).add(card);
        }
    }

    public static void initGame() {
        for (int x = 0; x < lifepoints.size(); x++) {
            hand.get(x).add(library.get(x).draw(7));
        }
    }
}
