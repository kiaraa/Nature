public class Unit {

    public Occupant groundSpace;
    public Occupant cowSpace;
    public int xCoord;
    public int yCoord;

    public Unit(int xCoord, int yCoord) {
        this.cowSpace = new EmptySpace(this);
        this.groundSpace = new EmptySpace(this);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void changeGroundOccupant(Occupant newGroundOccupant) {

        this.groundSpace = newGroundOccupant;
    }

    public void changeCowSpaceOccupant(Occupant newAboveGroundOccupant) {

        this.cowSpace = newAboveGroundOccupant;
    }

    public String toString() {
        String string = this.xCoord + ", " + this.yCoord;
        return string;
    }

}
