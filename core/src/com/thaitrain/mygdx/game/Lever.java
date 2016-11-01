package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Lever {
	private Vector2 position;
	boolean Leverposition = true;
	private Rectangle clickBox;
	
	public Lever(int x,int y) {
		position = new Vector2(x,y);
		clickBox = new Rectangle(x,y,138,46);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Rectangle getClickBox() {
		return clickBox;
	}
	
	public void Clicked(){
		Leverposition = !Leverposition;
	}
			
}
