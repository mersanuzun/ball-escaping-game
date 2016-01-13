package ballEscaping;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by mersanuzun on 01/01/2016.
 */
public class DrawingPane extends JPanel {
    Ball ball;
    Barrier barrier;
    public DrawingPane(Ball ball, Barrier barrier){
        this.ball = ball;
        this.barrier = barrier;
        setBackground(Color.DARK_GRAY);
    }
    public void paintComponent(Graphics g){
        System.out.println("drawing pane");
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(ball.getCenterX(), ball.getCenterY(), ball.getWidth(), ball.getHeight());
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;
        for(Wall w : barrier.walls){
            g2.fill(new Rectangle.Double(w.getStartX(), w.getStartY(), w.getWallWidth(), w.getWallHeight()));
        }
    }
}
