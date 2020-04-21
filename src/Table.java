import java.util.ArrayList;

/**
 *
 *
 */
public class Table {
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private ArrayList<Card> cards;
    private Card middleCard;

    public Table (int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        cards = new ArrayList<Card>();
        players = new ArrayList<Player>();
        for (int i = 0; i < numberOfPlayers; i++)
            players.add(new Player(i));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.blue,(i/2)));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.green,(i/2)));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.red,(i/2)));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.yellow,(i/2)));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.blue));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.green));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.red));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.yellow));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.blue));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.green));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.red));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.yellow));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.blue));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.green));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.red));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.yellow));
        for (int i = 0; i < 4; i++)
            cards.add(new WildCard());
        for (int i = 0; i < 4; i++)
            cards.add(new WildDrawCard());
    }

    public void print() {
        //
        System.out.println(middleCard.getDesign());
        int i = 1;
        for (Player player:players) {
            System.out.println("Player " + i);
            for (Card card : player.getCards()) {
                System.out.println("" + card.getSign() + " " + card.getColor());
                System.out.println(card.getDesign());
                i++;
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Getter for Players
     *
     * @return Players List
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Getter for Cards
     *
     * @return Cards List
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getMiddleCard() {
        return middleCard;
    }

    public void setMiddleCard(Card middleCard) {
        this.middleCard = middleCard;
    }
}
