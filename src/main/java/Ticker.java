import java.util.TimerTask;

public class Ticker extends TimerTask {

    World world;

    Ticker(World world){
        this.world = world;
    }

    @Override
    public void run(){
        try {
            world.tick();
            System.out.println("tick");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("error running thread " + ex.getMessage());
        }
    }
}