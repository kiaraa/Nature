import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public class Cow extends Occupant {

    public Cow(Unit unit) {
        super(new Color(0,0,255), unit);
        this.speed = 1;
    }

    public void move(World world) {
        int newXCoord;
        int newYCoord;
        int direction = ThreadLocalRandom.current().nextInt(-1, 3);
        switch(direction) {
            case -1:    newXCoord = this.unit.xCoord - this.speed;
                        newYCoord = this.unit.yCoord;
                        break;

            case 0:     newXCoord = this.unit.xCoord;
                        newYCoord = this.unit.yCoord + this.speed;
                        break;

            case 1:     newXCoord = this.unit.xCoord + this.speed;
                        newYCoord = this.unit.yCoord;
                        break;

            case 2:     newXCoord = this.unit.xCoord;
                        newYCoord = this.unit.yCoord - this.speed;
                        break;

            default:    newXCoord = this.unit.xCoord;
                        newYCoord = this.unit.xCoord;
        }
        if (world.grid[newXCoord][newYCoord].cowSpace instanceof EmptySpace) {
            this.unit.changeCowSpaceOccupant(new EmptySpace());
            world.grid[newXCoord][newYCoord].changeCowSpaceOccupant(this);
            this.unit = world.grid[newXCoord][newYCoord];
        }
        else {
            System.out.println("A movement failed.");
        }
    }

}
