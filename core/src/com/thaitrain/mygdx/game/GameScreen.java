package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private ThaitrainGame thaitrainGame;
	private Train train;
	World world;
	private WorldRenderer worldRenderer;
	static Vector2 mousepress;
	
	public GameScreen(ThaitrainGame thaitrainGame){
		this.thaitrainGame = thaitrainGame;
		world = new World(thaitrainGame);
		worldRenderer = new WorldRenderer(thaitrainGame,world);
		train = world.getTrain();
	}
	
	@Override
    public void render(float delta) {
    	update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
        	train.stage = 1;
        }
 
        worldRenderer.render(delta);
    }
	
	private void update(float delta) {
    	world.update(delta);
    }

}
