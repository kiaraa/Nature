import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**Objects of this class represent cows*/
public class Cow extends Occupant {

    static int lifetimeCows = 0;

    public Cow(Unit unit) {
        super(new Color(0,0,255), unit);
        this.speed = 1;
        lifetimeCows++;
        this.name = "Cow #" + lifetimeCows;
        this.energy = 10;
    }
    /**
     * Allows cows to move up to a set distance away from their current location
     * @param world The world that the cow is on*/
    @Override
    public void move(World world) {
        int newXCoord;
        int newYCoord;
        int direction = ThreadLocalRandom.current().nextInt(-1, 4);
        switch(direction) {
            case -1:    newXCoord = this.unit.xCoord - this.speed;
                        newYCoord = this.unit.yCoord;
                        this.energy--;
                        break;

            case 0:     newXCoord = this.unit.xCoord;
                        newYCoord = this.unit.yCoord + this.speed;
                        this.energy--;
                        break;

            case 1:     newXCoord = this.unit.xCoord + this.speed;
                        newYCoord = this.unit.yCoord;
                        this.energy--;
                        break;

            case 2:     newXCoord = this.unit.xCoord;
                        newYCoord = this.unit.yCoord - this.speed;
                        this.energy--;
                        break;

            default:    newXCoord = this.unit.xCoord;
                        newYCoord = this.unit.xCoord;
        }
        if (targetOnGrid(world, newXCoord, newYCoord)) {
            if (world.grid[newXCoord][newYCoord].cowSpace instanceof EmptySpace) {
                this.unit.changeCowSpaceOccupant(new EmptySpace());
                world.grid[newXCoord][newYCoord].changeCowSpaceOccupant(this);
                this.unit = world.grid[newXCoord][newYCoord];
            }
            else {
                System.out.println("A cow bumped into a friend.");
            }
        }
        else{
            System.out.println("A cow tried to walk off the earth.");
        }

    }

    public void eat(World world){
        if (this.unit.groundSpace instanceof Plant){
            this.energy += 5;
            ((Plant) this.unit.groundSpace).getEaten(world);
        }
    }

    @Override
    public void restoreDefaultColor() {
        this.color = COW_COLOR;
        this.isHighlighted = false;
    }

    @Override
    public void takeTurn(World world) {
        if (this.isHighlighted){
            System.out.println("Highlighted cow has " + this.energy + " energy.");
        }
        if (this.energy <= 0){
            this.die(world);
        }
        else{
            int actionChoice = ThreadLocalRandom.current().nextInt(0, 5);
            switch (actionChoice){
                case 0:     this.eat(world);
                    System.out.println("A cow tried to eat.");
                            break;

                default:    this.move(world);
            }

        }
    }

    @Override
    public void die(World world) {
        this.unit.changeCowSpaceOccupant(new EmptySpace());
        System.out.println("A cow died with " + this.energy + " energy.");
    }

    private boolean targetOnGrid(World world, int newXCoord, int newYCoord) {
        return newXCoord < world.columns && newYCoord < world.rows && (newXCoord >= 0 && newYCoord >= 0);
    }

}
