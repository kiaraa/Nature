import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFinder implements MouseListener {

    World world;

    public MouseFinder(World world){
        this.world = world;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        getUnitClicked(e, world);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Unit getUnitClicked(MouseEvent e, World world){
        int xCoord = e.getX() / 10;
        int yCoord = (e.getY() - 25) / 10;
        Unit clickedUnit = world.grid[xCoord][yCoord];
        System.out.println(clickedUnit);
        world.selectedUnit = clickedUnit;
        return clickedUnit;
    }
}
