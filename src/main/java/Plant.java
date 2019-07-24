import java.awt.*;

/**
 * Objects of this class represent plants, which are stationary*/
public class Plant extends Occupant {

    public Plant(Unit unit) {
        super(new Color(0,255,0), unit);
    }

    public Plant() {
        super(new Color(0,255,0));
    }

    public void move(World world) {

    }

    @Override
    public void restoreDefaultColor() {
        this.energy = 0;
        this.color = PLANT_COLOR;
        this.isHighlighted = false;
    }

    @Override
    public void takeTurn(World world) {

    }
}
