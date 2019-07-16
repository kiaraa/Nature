import java.awt.*;

public class Plant extends Occupant {

    public Plant(Unit unit) {
        super(new Color(0,255,0), unit);
    }

    public Plant() {
        super(new Color(0,255,0));
    }

    public void move(World world) {

    }
}
