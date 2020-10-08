package com.project.game.view;

import processing.core.PApplet;

public class BallView extends AbstractView {

    private float diameter;
    private float xSpeed;
    private float ySpeed;

    private int xDirection;
    private int yDirection;

    private float x;
    private float y;

    private final float defaultLaunchSpeed;

    public BallView(PApplet display, float diameter, float xSpeed, float ySpeed, float defaultLaunchSpeed, int xDirection, int yDirection) {
        super(display);
        this.diameter = diameter;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.defaultLaunchSpeed = defaultLaunchSpeed;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float radius) {
        this.diameter = radius;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getDefaultLaunchSpeed() {
        return defaultLaunchSpeed;
    }

    @Override
    public void update() {
        if (xSpeed == 0 && ySpeed == 0){
            this.xSpeed = 0;
            this.ySpeed = defaultLaunchSpeed;
        }
    }

    public void drawBall(PaddleView paddleView, ScoreView scoreView, int screenWidth){
        int paddleX = paddleView.getPaddleX();
        int paddleY = paddleView.getPaddleY();
        float paddleWidth = paddleView.getWidth();

        int score = scoreView.getScore();

        if(xSpeed == 0 && ySpeed == 0) {
            x = paddleX + paddleWidth/2;
            y = paddleY - diameter/2;
        }

        if (x <= 0){
            xDirection = 1;
        } else if (x >= screenWidth){
            xDirection = -1;
        }

        if (y <= 0){
            yDirection = 1;
        } else if (y >= paddleY - diameter/2 && x >= paddleX && x <= paddleX + paddleWidth){
            if(xSpeed!=0 || ySpeed!=0) {
                score++;
            }
            xSpeed = defaultLaunchSpeed* PApplet.abs(x - paddleX - paddleWidth/2)/(paddleWidth/2);
            if (x < paddleX + paddleWidth/2){
                xDirection = -1;
            } else {
                xDirection = 1;
            }
            yDirection = -1;
        } else if (y >= paddleY){
            score = 0;
            xSpeed = 0;
            ySpeed = 0;
        }

        scoreView.setScore(score);
        x = x + xDirection * xSpeed;
        y = y + yDirection * ySpeed;

        display.fill(51, 255, 81);
        display.circle(x, y, diameter);
    }
}
