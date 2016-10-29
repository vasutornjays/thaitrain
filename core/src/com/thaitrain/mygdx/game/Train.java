package com.thaitrain.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Train {
	private Vector2 position;
	
	private Texture trainImg;
	
	public Train(int x,int y){
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void update(){
		
	}
	
}