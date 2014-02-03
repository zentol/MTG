package Game;

import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import static Card.Color.Color.W;
import Card.Permanent;
import Collection.Battlefield;
import Collection.Exile;
import Collection.Graveyard;
import Collection.Hand;
import Collection.Library;
import Collection.Manapool;
import Collection.Stack;
import Effect.Effect;
import static Game.Phase.Beginning.phaseBeginning;
import static Game.Phase.Combat.phaseCombat;
import static Game.Phase.Ending.phaseEnding;
import static Game.Phase.Main.phasePostMain;
import static Game.Phase.Main.phasePreMain;
import java.util.ArrayList;

public class Game {
    public static ArrayList<Hand> hand;
    public static ArrayList<Library> library;
    public static ArrayList<Graveyard> graveyard;
    public static ArrayList<Exile> exile;
    public static ArrayList<Manapool> manapool;
    public static ArrayList<Integer> lifepoints;
    public static Battlefield battlefield;
    public static Stack stack;
    public static ArrayList<Effect> effects;

    public static int activePlayer = 0;

//turn--------------------------------------------------------------------------
    public static void turn() {
        phaseBeginning();
        phasePreMain();
        phaseCombat();
        phasePostMain();
        phaseEnding();
        endTurn();
    }
    public static void endTurn() {
        activePlayer++;
        activePlayer %= lifepoints.size();
    }

    public static void addPlayer() {
        hand.add(new Hand());
        library.add(new Library());
        graveyard.add(new Graveyard());
        exile.add(new Exile());
        manapool.add(new Manapool());
        lifepoints.add(20);
    }

    public static void removePlayer(int playerID) {
        battlefield.removePlayer(playerID);
        hand.remove(playerID);
        library.remove(playerID);
        graveyard.remove(playerID);
        exile.remove(playerID);
        lifepoints.remove(playerID);
        manapool.remove(playerID);
        if (playerID < activePlayer) {
            activePlayer--;
        }
        if (playerID == activePlayer) {
            activePlayer--;
            endTurn();
        }
    }

    public static void dummyLoadLibrary() {
        Permanent card;
        for (int x = 0; x < 25; x++) {
            card = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
            card.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
            library.get(0).add(card);
        }
        for (int x = 0; x < 25; x++) {
            card = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
            card.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
            library.get(1).add(card);
        }
    }

    public static void initGame() {
        for (int x = 0; x < lifepoints.size(); x++) {
            hand.get(x).add(library.get(x).draw(7));
        }
    }

    public Game(int playerCount) {
        hand = new ArrayList();
        library = new ArrayList();
        graveyard = new ArrayList();
        exile = new ArrayList();
        manapool = new ArrayList();
        lifepoints = new ArrayList();
        battlefield = new Battlefield();
        stack = new Stack();
        effects = new ArrayList();
        for (int x = 0; x < playerCount; x++) {
            addPlayer();
        }
    }
}
