import java.util.ArrayList;
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
        divideCards();
    }

    /**
     * Put a card on
     *
     * @param cardToPut card to put
     * @param putterPlayer who want to put a card
     * @return Is card putted
     */
    public boolean putCard(Card cardToPut, Player putterPlayer) {
        if(checkPuttedCard(cardToPut, putterPlayer)) {
            table.getCards().add(table.getMiddleCard());
            table.setMiddleCard(cardToPut);
            return true;
        }
        else
            return false;

    }

    /**
     * Check if you can put the selected card.
     *
     * @param cardToPut card to put on.
     * @return can put or not.
     */
    private boolean checkPuttedCard(Card cardToPut, Player putterPlayer) {
        Card middleCard = table.getMiddleCard();
        if(cardToPut.getSign() == Sign.wildColor)
            return true;
        if(middleCard.getSign() == cardToPut.getSign())
            return true;
        if(middleCard.getColor() == cardToPut.getColor())
            return true;
        if(cardToPut.getSign() == Sign.wildDraw)
            return checkWildDrawPutting(middleCard, putterPlayer);
        return false;
    }

    /**
     * Check if you can put another card instead of WildDraw Card , you can't put it on.
     *
     * @param middleCard the middle cart of game
     * @param putterPlayer who want to put a card.
     * @return can put or not.
     */
    private boolean checkWildDrawPutting(Card middleCard, Player putterPlayer){
        for (Card cardToCheck:putterPlayer.getCards()) {
            if(cardToCheck.getSign() != Sign.wildDraw){
                if(checkPuttedCard(cardToCheck, putterPlayer))
                    return false;
            }
        }
        return true;
    }

    /**
     * Take a card from table
     *
     * @param player who want to take a card
     */
    public void takeCard(Player player) {
        Card aCard = selectRandomCard(table.getCards());
        player.getCards().add(aCard);
        table.getCards().remove(aCard);
    }

    /**
     * Select a Random Card from the given Card Source
     *
     * @param cardSource card source
     * @return selected card
     */
    private Card selectRandomCard (ArrayList<Card> cardSource){
        return cardSource.get(ThreadLocalRandom.current().nextInt(0 ,  cardSource.size()));
    }

    /**
     * divide cards for players at first of game
     */
    public void divideCards() {
        for (Player player : table.getPlayers()) {
            for (int i = 0; i < numberOfCardsForEachPlayer; i++) {
                takeCard(player);
            }
        }
        Card middleCard;
        do {
            middleCard = selectRandomCard(table.getCards());
        } while(!checkFirstMiddleCard(middleCard));
        table.setMiddleCard(middleCard);
    }

    /**
     * Check for first middle Card
     *
     * @param cardToPutFirst first card to put
     * @return can put or not.
     */
    private boolean checkFirstMiddleCard(Card cardToPutFirst) {
        return cardToPutFirst.getSign() != Sign.wildDraw && cardToPutFirst.getSign() != Sign.wildColor;
    }

    public void systemPlay() {

    }

    public boolean endGame() {
        return false;
    }

    public Table getTable() {
        return table;
    }
}
