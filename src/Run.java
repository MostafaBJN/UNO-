import java.util.Scanner;

/**
 *
 * @author Mostafa_BJN
 * @version 0.0
 */
public class Run {
    //
    public static int player_turn;
    //anticlockwise = -1 , clockwise = 1
    public static int rotateDirection;
    //
    public static Game game;
    //
    public static int numberOfPlayers;

    public static void main(String[] args) {
        numberOfPlayers = 2;
        game= new Game(numberOfPlayers);
        game.getTable().print();
//        for (Player player:g.getTable().getPlayers()) {
//            for(Card card:player.getCards())
//                System.out.println("" + card.getSign() + " " + card.getColor());
//            System.out.println();
//            System.out.println();
//        }
//        Card card = g.getTable().getMiddleCard();
//        System.out.println("" + card.getSign() + " " + card.getColor());
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
