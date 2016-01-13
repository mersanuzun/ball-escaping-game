package ballEscaping;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mersanuzun on 01/01/2016.
 */
public class Barrier {
    private static final double WALL_STEP = 2.5;
    private Random random = new Random();
    public ArrayList<Wall> walls;
    private int spaceWidth;
    private double wallStep;
    public Barrier(){
        walls = new ArrayList<>();
        spaceWidth = 50;
        generateWalls();
        resetWallStep();
    }

    public void resetWallStep() {
        this.wallStep = WALL_STEP;
    }

    public void generateWalls(){
        walls.clear();
        Wall w1 = new Wall();
        w1.setStartX(0);
        int w1Width = random.nextInt(400);
        w1.setWallWidth(w1Width);
        walls.add(w1);
        Wall w2 = new Wall();
        int w2Width = 500 - w1Width - 50;
        w2.setStartX(w1Width + spaceWidth);
        w2.setWallWidth(w2Width);
        walls.add(w2);
    }
    public void calculateWallStep(){
        wallStep = wallStep * 1.05;
        System.out.println(wallStep);
    }
    public void update(){
        for(Wall w : walls){
            w.setStartY(w.getStartY() -  wallStep);
        }
    }

    public Boolean isPass(Ball ball){
        return (((ball.getCenterX() <= walls.get(1).getStartX()) &
                (ball.getCenterX() >= walls.get(0).getStartX() + walls.get(0).getWallWidth())) &
                (ball.getCenterY() - ball.getHeight() >= walls.get(0).getStartY()));
    }

    public Boolean isCollision(Ball ball){
        return (((ball.getCenterX() <= walls.get(0).getStartX() + walls.get(0).getWallWidth()) |
                (ball.getCenterX() + ball.getWidth() >= walls.get(1).getStartX())) &
                (ball.getCenterY() + ball.getHeight() >= walls.get(0).getStartY()));
    }

}
