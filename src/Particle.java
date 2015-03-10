import java.util.Random;
import processing.core.*;

/**
 * Created by jens on 03.03.15.
 */
class Particle {

    private Random rand;

    private float xpos;
    private float ypos;

    private int xMoves = 0;
    private int yMoves= 0;

    private int colR;
    private int colG;
    private int colB;

    private float width;
    private float height;

    Particle(float xpos, float ypos, int colR, int colG, int colB) {
        this.xpos = xpos;
        this.ypos = ypos;

        this.colR = colR;
        this.colG = colG;
        this.colB = colB;

        this.width = 5;
        this.height = 5;

        rand = new Random();

    }

    public float getXpos() {
        return xpos;
    }

    public void setXpos(float xpos) {
        this.xpos = xpos;
    }

    public float getYpos() {
        return ypos;
    }

    public void setYpos(float ypos) {
        this.ypos = ypos;
    }

    public int getColR() {
        return colR;
    }

    public void setColR(int colR) {
        this.colR = colR;
    }

    public int getColG() {
        return colG;
    }

    public void setColG(int colG) {
        this.colG = colG;
    }

    public int getColB() {
        return colB;
    }

    public void setColB(int colB) {
        this.colB = colB;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void bounceBack(float height) {
        this.height = height;
    }

    public int getxMoves() {
        return xMoves;
    }

    public void setxMoves(int xMoves) {
        this.xMoves = xMoves;
    }

    public int getyMoves() {
        return yMoves;
    }

    public void setyMoves(int yMoves) {
        this.yMoves = yMoves;
    }

    public void move(int displayWidth, int displayHeight){


        int xRand = rand.nextInt(3)-1;
        int yRand = rand.nextInt(3)-1;

        // Kan den bevege seg dit?

        if ((this.xpos + xRand) >= 0 && (this.xpos + xRand) <= displayWidth){
            // Den er innenfor display
            if (xRand == 1 || xRand == -1){
                // Den har beveget seg i x-retning
                this.xMoves++;
            }
            this.xpos =  xpos + xRand;

        }

        if ((this.ypos + yRand) >= 0 && (this.ypos + yRand) <= displayHeight){
            // Den er innenfor displayrrrr
            if (yRand == 1 || yRand == -1){
                // Den har beveget seg i y-retning
                this.yMoves++;
            }
            this.ypos =  ypos + yRand;
        }


    }
}