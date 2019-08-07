import javax.swing.*;
import java.awt.*;
/**
 * All living things will inherit from this class.
 * */
public abstract class Occupant {
    Color color;
    public final Color HIGHLIGHT_COLOR = new Color(250,246,0);
    public final Color COW_COLOR = new Color(0,0,255);
    public final Color PLANT_COLOR = new Color(0,255,0);
    public final Color EMPTY_COLOR = new Color(50,50,50);
    public Unit unit;
    public int speed;
    public String name;
    public boolean isHighlighted;
    public int energy;

    /**
     * @param color The color that will be displayed in the occupied space.
     * @param unit The initial location of the creature or plant*/
    public Occupant(Color color, Unit unit) {
        this.color = color;
        this.unit = unit;
        this.name = name;
        this.isHighlighted = false;
    }

    public Occupant(Color color) {
        this.color = color;
    }

    /**
     * Gets the color of the occupant
     * @return The current color of the creature*/
    public Color getColor() {
        return this.color;
    }

    /**
     * Changes the position of the creature
     * @param unit A valid position on the world*/
    public void setPosition(Unit unit) {
        this.unit = unit;
        unit.cowSpace = this;
    }

    /**
     * Highlights the creature to make it easier to keep track of*/
    public void highlight(){
        this.color = HIGHLIGHT_COLOR;
        this.isHighlighted = true;
    }

    public abstract void move(World world);

    /**
     * Changes the name of the creature
     * @param newName The desired new name*/
    public void rename(String newName) {
        this.name = newName;
    }

    public abstract void restoreDefaultColor();

    public abstract void takeTurn(World world);

    public abstract void die(World world);
}