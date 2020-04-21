public class SkipCard extends Card {

    public SkipCard (Color color){
        super.point = 20;
        super.color = color;
        super.sign = Sign.skip;
        super.design = colorToPaint(color) + BORDER + "\n" + SKIP + "\n" + BORDER + RESET;
    }

    /**
     *
     */
    @Override
    public void ability () {
        if (!checkNextPlayerHasSign(Run.player_turn, Sign.skip)) {
            System.out.println("! SKIPPED !");
            Run.player_turn++;
        } else {
            System.out.println("- Put Your Skip Card -");;
            Run.game.getTable().getPlayers().get(Run.player_turn + 1).setHaveToPut(Sign.skip);
        }
    }
}
