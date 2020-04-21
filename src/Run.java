import java.util.Scanner;

/**
 *
 * @author Mostafa_BJN
 * @version 0.0
 */
public class Run {
    //Player Turn
    public static int playerTurn;
    //anticlockwise = -1 , clockwise = 1
    public static int rotateDirection;
    //UNO Game
    public static Game game;
    //number of Players of game
    public static int numberOfPlayers;
    //if Draw Card got on, How many Card should add to the next player
    public static int drawNumberToAdd;
    //if Skip Card got on, How many Player should pass
    public static int skipNumberToPass;

    public static void main(String[] args) {
        numberOfPlayers = 4;
        game= new Game(numberOfPlayers);
        playGame();
    }

    public static void playGame(){////after put has to consider and back to 0
        rotateDirection = 1;
        boolean cardTaken = false;
        skipNumberToPass = 0;
        drawNumberToAdd = 0;
        game.getTable().getMiddleCard().ability();
        for (playerTurn = 0; true; playerTurn = (playerTurn + rotateDirection) % numberOfPlayers){
            //game.getTable().print();
            if(playerTurn<0)
                playerTurn = numberOfPlayers - 1;
            Player player = game.getTable().getPlayers().get(playerTurn);
            System.out.println("It's Player " + (playerTurn + 1) + " Turn");
            Card card;
            do {
                card = getCardInput(player, cardTaken);
                if(card == null){
                    if(cardTaken) {
                        cardTaken = false;
                        break;
                    }
                    game.takeCard(player);
                    card = getCardInput(player, true);
                    if(card == null) {
                        cardTaken = false;
                        break;
                    }
                    else
                        cardTaken = true;
                }
            } while (!game.putCard(card, player));
        }
    }

    public static Card getCardInput(Player putterPlayer, boolean cardTaken) {
        System.out.println("Middle Card");
        System.out.println(game.getTable().getMiddleCard().getDesign());
        System.out.println("-------------------");
        game.getTable().printPlayer(putterPlayer);
        int numberOfCards = putterPlayer.getCards().size();
        if(cardTaken)
            System.out.println(numberOfCards + 1 + ") Pass (If You Can't Put)");
        else
            System.out.println(numberOfCards + 1 + ") Take A Card");
        System.out.println("Enter Your Choice :");
        int choice = inputMenuGetter(-1, numberOfCards + 1);
        if(choice == 0) {//input 0 will show all players cards
            game.getTable().print();
            return getCardInput(putterPlayer, cardTaken);
        }
        if(choice > putterPlayer.getCards().size())
            return null;
        return putterPlayer.getCards().get(choice - 1);
    }

    public static int inputMenuGetter(int min, int max){
        Scanner scan = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = scan.nextInt();
                //for being out of menu
                if ((choice < min || choice > max)) {
                    System.out.println("!!! It's Unavailable !!!");
                    continue;
                }
                break;
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("!!! WRONG INPUT !!!");
            }
        }
        return choice;
    }
}
