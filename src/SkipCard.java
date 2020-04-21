public class SkipCard extends Card {

    public SkipCard (Color color){
        super(color, Sign.skip);
        super.point = 20;
        super.design = colorToPaint(color) + BORDER + "\n" + SKIP + "\n" + BORDER + RESET;
    }


    @Override
    public void ability () {
        Run.skipNumberToPass ++;
        int turnOfNextPlayer = (Run.playerTurn + Run.rotateDirection)%Run.numberOfPlayers;
        if(turnOfNextPlayer < 0)
            turnOfNextPlayer = Run.numberOfPlayers - 1;
        if (!checkNextPlayerHasSign(turnOfNextPlayer, Sign.skip)) {
            System.out.println("! SKIPPED !");
            turnOfNextPlayer = (turnOfNextPlayer + Run.drawNumberToAdd*Run.rotateDirection)%Run.numberOfPlayers;
            if(turnOfNextPlayer < 0)
                turnOfNextPlayer = Run.numberOfPlayers + turnOfNextPlayer;
            Run.playerTurn = turnOfNextPlayer;
            Run.skipNumberToPass = 0;
        } else {
            System.out.println("- Put Your Skip Card -");;
            Run.game.getTable().getPlayers().get(turnOfNextPlayer).setHaveToPut(Sign.skip);
        }
    }
}
