package com.thaitrain.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Train {
	private Vector2 position;
	private Rectangle clickBox;
	int stage = 0; 
	static int AT_STATION = 0;
	static int AT_PLATFORM = 1;
	static int AT_DEPART = 2;
	static int AT_CARGO = 3;
	static int FIN = 4;
	static int TRAIN_SPEED = 5;
	static int DESTINATION = AT_DEPART;
	
	
	public Train(int x,int y){
		position = new Vector2(x,y);
		clickBox = new Rectangle(x,y,138,46);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Rectangle getClickBox(){
		System.out.println(clickBox.getX());
		System.out.println(clickBox.getY());
		return clickBox;
	}
	
	public int nextStage() {
		return ++stage;
	}
	
	public int currentStage() {
		return stage;
	}
	
	public void update() {
		moveTo();
		Quit();
	}
	
	public int moveTo() {
		if(stage == AT_PLATFORM) {
			if(position.x > 400) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if(position.x == 400)
			{
				return AT_PLATFORM;
			}
		}
		if(stage == AT_DEPART) {
			if(position.x > -200) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if(position.x == -200)
			{
				return AT_DEPART;
			}
		}
		if(stage == AT_CARGO) {
			if(position.y > 0) {
				position.y -=TRAIN_SPEED;
				clickBox.y -=TRAIN_SPEED;
			}
			if(position.y == 0)
			{
				return AT_CARGO;
			}
		}
		return AT_STATION;
	}
	
	public void Quit () {
		if(moveTo() == DESTINATION) { 
			stage = FIN;
		}
	}
	
}