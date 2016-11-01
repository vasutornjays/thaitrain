package com.thaitrain.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Train {
	private Vector2 position;
	private GameScreen gameScreen;
	private Texture trainImg;
	private Rectangle clickBox;
	int stage = 0; 
	
	public Train(int x,int y){
		position = new Vector2(x,y);
		clickBox = new Rectangle(x,y,138,46);
//		System.out.println(clickBox.x);
//		System.out.println(clickBox.y);
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
	}
	
	public void moveTo() {
		if(stage == 1) {
			if(position.x > 400) {
				position.x -= 5;
				clickBox.x -= 5;
//				System.out.println(clickBox.x);
//				System.out.println(clickBox.y);
			}
		}
		if(stage == 2) {
			if(position.x > -200) {
				position.x -= 5;
				clickBox.x -= 5;
//				System.out.println(clickBox.x);
//				System.out.println(clickBox.y);
			}
		}
	}
	
}