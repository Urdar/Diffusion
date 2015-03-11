/**
 * Created by jens on 03.03.15.
 */

import processing.core.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.geom.*;



public class Simulator extends PApplet {

    public static void main(String args[]) {
        PApplet.main(new String[]{"--present", "Simulator"});
    }



    // The current step of the simulation.
    private int step = 0;
    private int stage;

    private static int particleAmount = 500;

    boolean pause = false;

    // List of particles
    Particle[] particles = new Particle[particleAmount];

    public void setup() {

        size(displayWidth, displayHeight);    // Fullskjerm

        //  size(300, 300);
        stage = 1;
        smooth();
        background(255);
        noStroke();
        fill(0, 255, 0);
        frameRate(30);

//        Plassere ut numOfParticles antall partikler
        for (int i = 0; i < particles.length; i++) { // Initialize each particle using a for loop
            particles[i] = new Particle((displayWidth / 2), (displayHeight / 2), (i % 255), (i % 255), (0));
            // Kommentar dfd f
        }


    }


    public void draw() {
        if (stage == 1) {
            background(0);
            PFont myFont;
            myFont = createFont("Arial", 25);
            textFont(myFont);
            textAlign(CENTER);
            textSize(32);
            fill(255, 0, 0);
            text("enJOY ThE DIFFusION SIMulaTOR", (displayWidth / 2), (displayHeight / 2));
            text("displayWidth" + displayWidth + "displayHeight" + displayHeight, (displayWidth / 2), (displayHeight / 2)-100);

            fill(255, 255, 255);
            text("Press 'R' to run, 'S' to stop, P to pause", (displayWidth / 2), (displayHeight / 2) + 40);

            if (keyPressed) {
                if (key == 'r' || key == 'R') {
                    stage = 2;
                }
            }

        }


        if (stage == 2) {

            if (pause != true) {

                background(255);

                for (int i = 0; i < particles.length; i++) {
                    fill(particles[i].getColR(), particles[i].getColG(), particles[i].getColB());
                    ellipse(particles[i].getXpos(), particles[i].getYpos(), particles[i].getWidth(), particles[i].getHeight());

//         Flytte de
                    particles[i].move(displayWidth, displayHeight);

                }
                step++;

                if (keyPressed) {
                    if (key == 'p') {

                        if (pause == false) {
                            pause = true;
                        } else {
                            pause = false;
                        }
                    }

                    if (key == 's' || key == 'S') {
                        this.setup();
                        stage = 1;
                    }

                    if (key == 'q' || key == 'Q') {

                        stage = 3;
                    }

                }


            } else {
                if (keyPressed) {
                    if (key == 'r') {

                        if (pause == false) {
                            pause = true;
                        } else {
                            pause = false;
                        }
                    }
                }

            }


        }

        if (stage == 3) {
            // Oppsummere og gi statistikk

            // Totalt antall steg
            int xMoves = 0;
            int yMoves = 0;

            for (int i = 0; i < particles.length; i++) {
                xMoves = xMoves + particles[i].getxMoves();
                yMoves = yMoves + particles[i].getyMoves();
            }

            // Distanse mellom partikler

            // Loope igjennom array, lage en ny array som har object, avstand til neste




            // Antall objekter
            // Antall mulige steg
            // Antall steg x retning
            // antall steg y retning
            // Avg antall steg

           // Max antall steg
           // min antall steg
           // avg antall steg
          //  totalt antall steg

          //  minste distanse
          //  største distanse
          //  avg distanse

            PFont myFont;
            myFont = createFont("Arial", 25);
            textFont(myFont);
            textAlign(CENTER);
            textSize(32);
            fill(255, 0, 0);
            String myString =   "Oppsummering\n" +
                                "\nAntall partikler: " + particleAmount +
                                "\nMulige steg: " + step +
                                "\nSteg i x-retning: " + xMoves/particleAmount +
                                "\nSteg i y-retning: " + yMoves/particleAmount


                    ;
            text(myString, (displayWidth / 2), (displayHeight / 2));

        }

    }
}