import java.awt.*;
/**
 * Objects of this class are placeholders occupy places on the World where there is not currently a plant of animal*/
public class EmptySpace extends Occupant{
    public EmptySpace(Unit unit) {
        super(new Color(50,50,50),unit);
    }

    public EmptySpace() {
        super(new Color(50,50,50));
    }


    @Override
    public void move(World world) {

    }

    @Override
    public void restoreDefaultColor() {
        this.color = EMPTY_COLOR;
        this.isHighlighted = false;
    }
}
