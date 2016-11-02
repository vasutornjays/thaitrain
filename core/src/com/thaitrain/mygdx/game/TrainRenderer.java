package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TrainRenderer {
	
	private ArriveTrain arrivetrain;
	private ThaitrainGame thaitrainGame;
	private World world;
	
	public TrainRenderer(ThaitrainGame thaitrainGame,World world){
		
		this.thaitrainGame = thaitrainGame;
		arrivetrain = world.gettrainArr();
	}
	
	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		for(int i = 0;i<arrivetrain.getSize();i++) {
			if(arrivetrain.getTrainAtIndex(i).CANGOTOCARGO){
				batch.draw(arrivetrain.getTrainAtIndex(i).trainImgTurn, (int)arrivetrain.getTrainAtIndex(i).getPosition().x, (int)arrivetrain.getTrainAtIndex(i).getPosition().y);
			}
			else {
				batch.draw(arrivetrain.getTrainAtIndex(i).trainImg, (int)arrivetrain.getTrainAtIndex(i).getPosition().x, (int)arrivetrain.getTrainAtIndex(i).getPosition().y);
			}
		}
        batch.end();
//        System.out.println(Gdx.input.getX());
//        System.out.println(Gdx.input.getY());
    }

}
