package com.project.game.view;

import processing.core.PApplet;

public class PaddleView extends AbstractView {

    private float height;
    private float width;
    private float bottomPadding;

    private int paddleX;
    private int paddleY;

    public PaddleView(PApplet display, float height, float width, float bottomPadding) {
        super(display);
        this.height = height;
        this.width = width;
        this.bottomPadding = bottomPadding;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getBottomPadding() {
        return bottomPadding;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return paddleY;
    }

    @Override
    public void update() {

    }

    public void drawPaddle(int screenWidth, int screenHeight){
        paddleX = (screenWidth < display.mouseX + width)?(int) (screenWidth - width):display.mouseX;
        paddleY = (int) (screenHeight - height - bottomPadding);

        display.fill(255, 156, 51);
        display.rect(paddleX, paddleY, width, height);
    }
}
