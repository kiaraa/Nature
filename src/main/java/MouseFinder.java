import javax.swing.*;
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
        Unit unit = getUnitClicked(e, world);
        if (SwingUtilities.isRightMouseButton(e) || e.isControlDown()){
            if (unit.cowSpace instanceof Cow){
                System.out.println("You right-clicked at " + unit);
                new StatusWindow(unit.cowSpace);
            }
        }
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

    public Unit getUnitClicked(MouseEvent e, World world){ //TODO Think about finding a better place for this highlighting code
        int xCoord = e.getX() / 10;
        int yCoord = (e.getY() - 25) / 10;
        Unit clickedUnit = world.grid[xCoord][yCoord];
        System.out.println(clickedUnit);
        world.selectedUnit = clickedUnit;

        if (clickedUnit.cowSpace instanceof Cow){
            clickedUnit.cowSpace.highlight();
            world.repaint();
        }
        return clickedUnit;
    }
}
