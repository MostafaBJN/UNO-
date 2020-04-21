public class NumberCard extends Card {

    public NumberCard (Color color, int number){
        super.point = number;
        super.color = color;
        super.sign = numberFinder(number);
        super.design = colorToPaint(color) + BORDER + "\n" + "*  " + number + "  *" + "\n" + BORDER + RESET;
    }

    @Override
    public void ability(){
        /* NOTHING */
    }
}
