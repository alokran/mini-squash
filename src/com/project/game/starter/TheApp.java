package com.project.game.starter;


import com.project.game.controller.ViewController;
import com.project.game.view.BallView;
import com.project.game.view.PaddleView;
import com.project.game.view.ScoreView;
import processing.core.PApplet;

import java.util.Arrays;

public class TheApp extends PApplet {

	private int screenWidth;
	private int screenHeight;

	private PaddleView paddleView;
	private BallView ballView;
	private ScoreView scoreView;

	private ViewController viewController;

	@Override
	public void settings() {
		screenWidth = 400;
		screenHeight = (int) (screenWidth*1.5);
		size(screenWidth, screenHeight);
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(50);
		paddleView = new PaddleView(this, screenHeight/60.0f, screenWidth/5.0f, screenHeight/300.0f);
		ballView = new BallView(this, screenWidth/20.0f, 0, 0, screenHeight/100.0f, 1, -1);
		scoreView = new ScoreView(this, 0);
		viewController = new ViewController(Arrays.asList(paddleView, ballView));
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(51, 161, 255);
		scoreView.drawScore(screenWidth);
		paddleView.drawPaddle(screenWidth, screenHeight);
		ballView.drawBall(paddleView, scoreView, screenWidth);
	}
	
	//Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		viewController.handleEvent();
	}
}
