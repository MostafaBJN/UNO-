import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class Game {
    //Max Players = 15
    private static final int numberOfCardsForEachPlayer = 7;
    private Table table;

    /**
     * Star a new Game
     */
    public Game(int numberOfPlayers) {
        table = new Table(numberOfPlayers);
    }

    public boolean putCard(Card cardToPut) {
        if(checkPuttedCard(cardToPut)) {
            table.getCards().add(table.getMiddleCard());
            table.setMiddleCard(cardToPut);
            return true;
        }
        else
            return false;

    }

    /**
     *
     *
     * @param cardToPut
     * @return
     */
    private boolean checkPuttedCard(Card cardToPut) {
        Card middleCard = table.getMiddleCard();
        return true;
    }


    public void takeCard(Player player) {
        player.getCards().add(selectRandomCard());
    }

    private Card selectRandomCard (){
        return table.getCards().get(ThreadLocalRandom.current().nextInt(0 ,  table.getCards().size()));
    }

    public void divideCards() {
        for (Player player : table.getPlayers()) {
            for (int i = 0; i < 7; i++) {
                takeCard(player);
            }
        }
        Card middleCard = selectRandomCard();
        if()
        table.setMiddleCard();
    }

    public Card systemPlay() {
        return null;
    }

    public void a() {

    }

    public void s() {

    }
}
