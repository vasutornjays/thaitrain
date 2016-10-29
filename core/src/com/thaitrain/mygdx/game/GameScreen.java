package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
	
	private ThaitrainGame thaitrainGame;
	private Train train;
	World world;
	private WorldRenderer worldRenderer;
	
	public GameScreen(ThaitrainGame thaitrainGame){
		this.thaitrainGame = thaitrainGame;
		world = new World(thaitrainGame);
		worldRenderer = new WorldRenderer(thaitrainGame,world);
	}
	
	@Override
    public void render(float delta) {
    	update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldRenderer.render(delta);
    }
	
	private void update(float delta) {
    	world.update(delta);
    }

}
