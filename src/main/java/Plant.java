import java.awt.*;

/**
 * Objects of this class represent plants, which are stationary*/
public class Plant extends Occupant {

    public Plant(Unit unit) {
        super(new Color(0,255,0), unit);
        this.energy = 15;
        this.unit = unit;
    }

    public Plant() {
        super(new Color(0,255,0));
    }

    public void move(World world) {

    }

    public void getEaten(World world){
        this.energy -= 5;
        if (this.energy <= 0){
            this.die(world);
        }
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

    @Override
    public void die(World world) {
        this.unit.changeGroundOccupant(new EmptySpace());
        System.out.println("A plant died.");
    }
}
