import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFinder implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        System.out.println("Clicked at X: " + xCoord + " Y: " + yCoord);
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
}
