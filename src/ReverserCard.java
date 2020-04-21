public class ReverserCard extends Card {

    public ReverserCard (Color color){
        super.point = 20;
        super.color = color;
        super.sign = Sign.reverser;
        super.design = colorToPaint(color) + BORDER + "\n" + REVERSER + "\n" + BORDER + RESET;
    }

    @Override
    public void ability (){
        Run.rotateDirection = - Run.rotateDirection;
    }
}
