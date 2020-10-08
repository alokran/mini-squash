package com.project.game.view;

import processing.core.PApplet;

public class ScoreView extends AbstractView{

    private int score;

    public ScoreView(PApplet display, int score) {
        super(display);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void update() {

    }

    public void drawScore(float screenWidth) {
        display.textFont(display.createFont("Times New Roman", 24));
        display.fill(0);
        display.text("Score: " + score, screenWidth/2.0f, 24);
    }
}
