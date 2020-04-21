import java.util.ArrayList;

/**
 * Players of Game
 */
public class Player {
    //number in the game
    private int number;
    //cards of a player
    private ArrayList<Card> cards;
    //is the player has to put a specific card whit this sign
    private Sign haveToPut;
    //is this player a system or human
    private boolean isSystem;

    public Player(int number, boolean isSystem){
        this.number = number;
        cards = new ArrayList<Card>();
        haveToPut = null;
        this.isSystem = isSystem;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Sign getHaveToPut() {
        return haveToPut;
    }

    public void setHaveToPut(Sign haveToPut) {
        this.haveToPut = haveToPut;
    }

    public boolean isSystem() {
        return isSystem;
    }
}
