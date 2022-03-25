package Test.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EditAreaMouseListener implements MouseListener, MouseMotionListener {
    public EditAreaMouseListener() {
        super();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked Mouse pressed. x = "
                + e.getX() + " y = " + e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed Mouse pressed. x = "
                + e.getX() + " y = " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased Mouse pressed. x = "
                + e.getX() + " y = " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouseDragged Mouse pressed. x = "
        + e.getX() + " y = " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved Mouse pressed. x = "
        + e.getX() + " y = " + e.getY());
    }

}
