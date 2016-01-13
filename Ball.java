package ballEscaping;

import java.awt.*;

/**
 * Created by mersanuzun on 01/01/2016.
 */
public class Ball{
    private int centerX, centerY, speedX, width, height;

    public Ball(){
        this.centerY = 0;
        this.centerX = 0;
        this.speedX = 1;
        this.height = 30;
        this.width = 30;
    }

    public void update(){
        System.out.println("Ball Update");
        if (centerX + speedX >= 450) centerX = 450;
        else if (centerX + speedX <= 0) centerX = 0;
        else
            this.centerX += speedX;
    }

    public void moveLeft(){
        this.speedX = -6;
    }

    public void moveRight(){
        this.speedX = 6;
    }

    public void stop(){
        this.speedX = 0;
    }

    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.drawOval(centerX, centerY, 20, 20);
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
