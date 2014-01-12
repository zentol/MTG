package Game;

import Collection.Battlefield;
import Collection.Exile;
import Collection.Graveyard;
import Collection.Hand;
import Collection.Library;
import Collection.Stack;
import Effect.Effect;
import java.util.ArrayList;

public class Game {
    public static ArrayList<Hand> hand;
    public static ArrayList<Library> library;
    public static ArrayList<Graveyard> graveyard;
    public static ArrayList<Exile> exile;
    public static ArrayList<Integer> lifepoints;
    public static Battlefield battlefield;
    public static Stack stack;
    public static ArrayList<Effect> effects;
    
    public static int activePlayer=0;
    
    public static void nextTurn(){
        activePlayer++;
        activePlayer%=lifepoints.size();
    }
}
