package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ThaitrainGame extends Game {
	public SpriteBatch batch;
	public static final int HEIGHT = 1044;
    public static final int WIDTH = 1017;
    public GameScreen gameScreen;
    public boolean escPress;
	
	@Override
	public void create () {
	    batch = new SpriteBatch();
	    gameScreen = new GameScreen(this);
	    setScreen(gameScreen);
	    escPress = false;
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public void pauseGame() {
		//System.out.println("pause");
    	setScreen(new PauseScreen(this));
		escPress = true;
	}
	
	public void resumeGame() {
		setScreen(gameScreen);
		escPress = true;
	}
	
	public void overGame() {
    	setScreen(new PauseScreen(this));
    	escPress = true;
	}
}
