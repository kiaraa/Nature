import javax.swing.*;
import java.awt.*;

public abstract class Occupant {
    private Color color;
    public final Color HIGHLIGHT_COLOR = new Color(250,246,0);
    public final Color COW_COLOR = new Color(0,0,255);
    public final Color PLANT_COLOR = new Color(0,255,0);
    public final Color EMPTY_COLOR = new Color(50,50,50);
    public Unit unit;
    public int speed;
    public String name;

    public Occupant(Color color, Unit unit) {
        this.color = color;
        this.unit = unit;
        this.name = name;
    }

    public Occupant(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setPosition(Unit unit) {
        this.unit = unit;
        unit.cowSpace = this;
    }

    public void highlight() {
        this.color = HIGHLIGHT_COLOR;
    }

    public void move(World world) {

    }

    public void rename(String newName) {
        this.name = newName;
    }
}