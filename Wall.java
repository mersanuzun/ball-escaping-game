package ballEscaping;

/**
 * Created by mersanuzun on 01/01/2016.
 */
public class Wall {
    private double startX, startY, wallWidth, wallHeight;
    public Wall(){
        this.wallHeight = 30;
        this.startY = 500;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getWallWidth() {
        return wallWidth;
    }

    public void setWallWidth(double wallWidth) {
        this.wallWidth = wallWidth;
    }

    public double getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

}
