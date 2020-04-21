public class DrawCard extends Card {

    public DrawCard (Color color){
        super.point = 20;
        super.color = color;
        super.sign = Sign.draw;
        super.design = colorToPaint(color) + BORDER + "\n" + DRAW + "\n" + BORDER + RESET;
    }

    @Override
    public void ability (){
        if (!checkNextPlayerHasSign(Run.player_turn, Sign.draw)) {
            drawCardsForNextPLayer(2);
        } else {
            System.out.println("- Put Your 2+ Card -");;
            Run.game.getTable().getPlayers().get(Run.player_turn + 1).setHaveToPut(Sign.draw);
        }
    }
}
