import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFinder implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX() / 10;
        int yCoord = (e.getY() - 25) / 10;
        System.out.println("Clicked at square X: " + xCoord + " Y: " + yCoord);
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

    public void getSquareClicked(MouseEvent e, World world){ //TODO convert type to Unit later
        int convertedX = e.getX() / 10;

    }
}
