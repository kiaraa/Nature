import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents the 2D array of units on which the simulation takes place.*/

public class World extends JFrame {
    public final int UNIT_SIZE = 10;
    public Unit[][] grid;
    int rows;
    int columns;
    Color color1;
    Color color2;
    int startPlants;
    int startCows;
    Timer worldTimer;

    public World(int rows,int columns, int startPlants, int startCows) {
        super("Nature");
        this.addMouseListener(new MouseFinder());
        this.rows = rows;
        this.columns = columns;
        this.startPlants = startPlants;
        this.startCows = startCows;
        this.grid = new Unit[rows][columns];
        this.worldTimer = new Timer();
        Ticker ticker = new Ticker(this);
        initializeGrid(rows, columns, startPlants, startCows);

        worldTimer.schedule(ticker, 0, 10000); //TODO change back to 1000

        setSize(columns * UNIT_SIZE,(rows * UNIT_SIZE) + 23);

        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    /**
     * This method creates the grid of units that make up the world.
     * @param rows The number of rows
     * @param columns The number of columns
     * @param startPlants The initial number of plants
     * @param startCows The initial number of cows
     * */
    private void initializeGrid(int rows, int columns, int startPlants, int startCows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                        grid[i][j] = new Unit(i,j);
            }
        }
        for (int p = 0; p < startPlants; p++) {
            initializePlant();
        }

        for (int c = 0; c < startCows; c++) {
            initializeCow();
        }
    }


    private void initializePlant() {
        int xSeed = ThreadLocalRandom.current().nextInt(0, rows);
        int ySeed = ThreadLocalRandom.current().nextInt(0, columns);
        if (!(grid[xSeed][ySeed].groundSpace instanceof Plant)) {
            grid[xSeed][ySeed].changeGroundOccupant(new Plant());
        }
        else {
            initializePlant();
        }

    }
    private void initializeCow() {
        int xSeed = ThreadLocalRandom.current().nextInt(0, rows);
        int ySeed = ThreadLocalRandom.current().nextInt(0, columns);
        Unit unit = grid[xSeed][ySeed];
        if (!(unit.cowSpace instanceof Cow)) {
            unit.changeCowSpaceOccupant(new Cow(unit));
        }
        else {
            initializeCow();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (!(grid[i][j].cowSpace instanceof EmptySpace)) {
                    g.setColor(grid[i][j].cowSpace.getColor());
                }
                else{
                    g.setColor((grid[i][j].groundSpace.getColor()));
                }
                g.fillRect(i * UNIT_SIZE, j * UNIT_SIZE + 23, UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void tick() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.grid[i][j].cowSpace instanceof Cow) {
                    this.grid[i][j].cowSpace.move(this);
                }
            }
        }
        this.repaint();
    }

    /**
     * This method is used for debugging purposes.
     * */
    public void debugInfo() {
        int plantcount = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (grid[i][j].groundSpace instanceof Plant) {
                    plantcount++;
                    System.out.println("There is a plant at " + i + ", " + j + ".");
                }
            }
        }
        System.out.println("There are " + plantcount + " plants. There should be " + this.startPlants + " plants.");
        System.out.println("There are " + rows + " rows and " + columns + " columns.");
    }
}
