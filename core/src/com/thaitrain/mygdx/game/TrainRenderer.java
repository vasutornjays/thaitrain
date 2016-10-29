package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TrainRenderer {
	
	private Texture trainImg;
	private Train train;
	private ThaitrainGame thaitrainGame;
	private World world;
	
	public TrainRenderer(ThaitrainGame thaitrainGame,World world){
		
		trainImg = new Texture("TRAIN01.png");
		this.thaitrainGame = thaitrainGame;
		train = world.getTrain();
	}
	
	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
        batch.draw(trainImg, (int)train.getPosition().x, (int)train.getPosition().y);
        batch.end();
        System.out.println(Gdx.input.getX());
        System.out.println(Gdx.input.getY());
    }

}
