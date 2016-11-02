package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TrainRenderer {
	
	private Texture trainImg;
	private ArriveTrain arrivetrain;
	private ThaitrainGame thaitrainGame;
	private World world;
	
	public TrainRenderer(ThaitrainGame thaitrainGame,World world){
		
		trainImg = new Texture("TRAIN01.png");
		this.thaitrainGame = thaitrainGame;
		arrivetrain = world.gettrainArr();
	}
	
	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		for(int i = 0;i<arrivetrain.getSize();i++) {
			batch.draw(trainImg, (int)arrivetrain.getTrainAtIndex(i).getPosition().x, (int)arrivetrain.getTrainAtIndex(i).getPosition().y);
		}
        batch.end();
        System.out.println(Gdx.input.getX());
        System.out.println(Gdx.input.getY());
    }

}
