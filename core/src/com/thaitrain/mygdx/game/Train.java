package com.thaitrain.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Train {
	private Vector2 position;
	private GameScreen gameScreen;
	private Texture trainImg;
	int stage = 0; 
	
	public Train(int x,int y){
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public int nextStage() {
		return ++stage;
	}
	
	public int currentStage() {
		return stage;
	}
	
	public void update() {
		if(stage == 1){
			position.x -= 5;
		}
	}
	
}