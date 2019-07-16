import java.awt.*;

public class EmptySpace extends Occupant{
    public EmptySpace(Unit unit) {
        super(new Color(50,50,50),unit);
    }

    public EmptySpace() {
        super(new Color(50,50,50));
    }

    public void move() {

    }
}
