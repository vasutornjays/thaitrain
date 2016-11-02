package com.thaitrain.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Train {
	Texture trainImg;
	Texture trainImgTurn;
	private Vector2 position;
	private Rectangle clickBox;
	int stage = 0; 
	static int AT_STATION = 0;
	static int AT_PLATFORM = 1;
	static int AT_DEPART = 2;
	static int AT_CARGO = 3;
	static int FIN = 4;
	static int AT_TURNPOINT = 5;
	static int STARTDOWNX = 860;
	static int STARTDOWNY = 180;
	static int STARTTOPX = 0;
	static int STARTTOPY = 320;
	boolean CANGOTOCARGO = false;
	int  PLATFORM_X;
	int DEPART_X;
	int CARGO_X;
	int  PLATFORM_Y;
	int DEPART_Y;
	int CARGO_Y;
	int TURNPOINT_X;
	int TURNPOINT_Y;
	float TRAIN_SPEED; 		
	int RIGHTWAY;
	int WAY;
	
	
	
	public Train(int type,int way){
		WAY = way;
		if(WAY == 1){
			position = new Vector2(STARTDOWNX,STARTDOWNY);
			clickBox = new Rectangle(STARTDOWNX,STARTDOWNY,150,50);
			PLATFORM_X = 400;
			DEPART_X = -150;
			TURNPOINT_X = 200;
			CARGO_X = 100;
			CARGO_Y = 20;
			if(type == 1){
				trainImg = new Texture("TRAIN01.png");
				trainImgTurn = new Texture("badlogic.jpg");
				RIGHTWAY = AT_DEPART;
				TRAIN_SPEED = (float) 1.5;
			}
			else if(type == 2){
				trainImg = new Texture("TRAIN02.png");
				trainImgTurn = new Texture("badlogic.jpg");
				RIGHTWAY = AT_CARGO;
				TRAIN_SPEED = (float) 1.0;
			}
		}
		if(WAY == 2){
			position = new Vector2(STARTTOPX,STARTTOPY);
			clickBox = new Rectangle(STARTTOPX,STARTTOPY,150,50);
			PLATFORM_X = 400;
			DEPART_X = 800;
			TURNPOINT_X = 600;
			CARGO_X = 700;
			CARGO_Y = 500;
			if(type == 1){
				trainImg = new Texture("TRAIN01.png");
				trainImgTurn = new Texture("badlogic.jpg");
				RIGHTWAY = AT_DEPART;
				TRAIN_SPEED = (float) -1.5;
			}
			else if(type == 2){
				trainImg = new Texture("TRAIN02.png");
				trainImgTurn = new Texture("badlogic.jpg");
				RIGHTWAY = AT_CARGO;
				TRAIN_SPEED = (float) -1.0;
			}
		}
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Rectangle getClickBox(){
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
			if(!positionCheck(AT_PLATFORM)) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if(positionCheck(AT_PLATFORM))
			{
				return AT_PLATFORM;
			}
		}
		if(stage == AT_DEPART) {
			if(!positionCheck(AT_DEPART)) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if(positionCheck(AT_DEPART))
			{
				return AT_DEPART;
			}
		}
		if(stage == AT_CARGO) {
			if(!positionCheck(AT_CARGO) && CANGOTOCARGO){
				position.x -= TRAIN_SPEED/2;
				clickBox.x -= TRAIN_SPEED/2;
				position.y -= TRAIN_SPEED/2;
				clickBox.y -= TRAIN_SPEED/2;
			}
			if(positionCheck(AT_CARGO)) {
				return AT_CARGO;
			}
			if(!positionCheck(AT_TURNPOINT)) {
				position.x -=TRAIN_SPEED;
				clickBox.x -=TRAIN_SPEED;
			}
			if(positionCheck(AT_TURNPOINT))
			{
				CANGOTOCARGO = true;
			}
		}
		return AT_STATION;
	}
	
	public void Quit () {
		if(moveTo() == RIGHTWAY) { 
			stage = FIN;
		}
	}
	
	public boolean positionCheck(int destination) {
		if(WAY == 1) {
			if(destination == AT_PLATFORM) {
				if(position.x > PLATFORM_X){
					return false;
				}
				else if(position.x <= PLATFORM_X){
					return true;
				}
			
			}
			if(destination == AT_DEPART) {
				if(position.x > DEPART_X){
					return false;
				}
				else if(position.x <= DEPART_X){
					return true;
				}
				
			}
			
			if(destination == AT_TURNPOINT) {
				if(position.x > TURNPOINT_X){
					return false;
				}
				else if(position.x <= TURNPOINT_X){
					return true;
				}
			}
			
			if(destination == AT_CARGO) {
				if(position.y > CARGO_Y){
					return false;
				}
				else if(position.y <= CARGO_Y){
					return true;
				}	
			}
		}
		if(WAY == 2) {
			if(destination == AT_PLATFORM) {
				if(position.x < PLATFORM_X){
					return false;
				}
				else if(position.x >= PLATFORM_X){
					return true;
				}
			
			}
			if(destination == AT_DEPART) {
				if(position.x < DEPART_X){
					return false;
				}
				else if(position.x >= DEPART_X){
					return true;
				}
			}
			if(destination == AT_TURNPOINT) {
				if(position.x < TURNPOINT_X){
					return false;
				}
				else if(position.x >= TURNPOINT_X){
					return true;
				}
			}
			
			if(destination == AT_CARGO) {
				if(position.y <= CARGO_Y){
					return false;
				}
				else if(position.y >= CARGO_Y){
					return true;
				}	
			}
		}
		return false;
	}
}