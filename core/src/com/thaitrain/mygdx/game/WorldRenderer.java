package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	
	private ThaitrainGame thaitrainGame;
	private World world;
	private TrainRenderer trainRenderer;
	private Texture BGImg;
	
	WorldRenderer(ThaitrainGame thaitrainGame,World world){
		BGImg = new Texture("MAP01.png");
		this.thaitrainGame = thaitrainGame;
		trainRenderer = new TrainRenderer(thaitrainGame,world);
	}

	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		batch.draw(BGImg,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		trainRenderer.render(delta);
	}

}
