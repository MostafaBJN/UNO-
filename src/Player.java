import java.util.ArrayList;

public class Player {
    private int number;
    private ArrayList<Card> cards;
    private Sign haveToPut;

    public Player(int number){
        this.number = number;
        cards = new ArrayList<Card>();
        haveToPut = null;
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
}
