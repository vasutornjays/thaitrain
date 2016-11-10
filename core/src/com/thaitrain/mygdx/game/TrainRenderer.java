package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TrainRenderer {
	
	private ArriveTrain arrivetrain;
	private ThaitrainGame thaitrainGame;
	private World world;
	private Train train;
	Texture fullHeart;
	Texture emptyHeart;
	Texture human;
	Texture box;
	
	public TrainRenderer(ThaitrainGame thaitrainGame,World world){
		
		this.thaitrainGame = thaitrainGame;
		arrivetrain = world.gettrainArr();
		emptyHeart = new Texture("heart_empty.png");
		fullHeart = new Texture("heart_full.png");
		human = new Texture("human.png");
		box = new Texture("box.png");
	}
	
	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		
		for(int i = 0;i<arrivetrain.getSize();i++) {
			train = arrivetrain.getTrainAtIndex(i);
			if (train.CANGOTOCARGO) {
				batch.draw(train.trainImgTurn, (int)train.getPosition().x, (int)train.getPosition().y);
			}
			else {
				batch.draw(train.trainImg, (int)train.getPosition().x, train.getPosition().y);
			}
			if (train.HEART == 5) {
				batch.draw(fullHeart, (int)train.getPosition().x, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+20, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+40, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+60, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+80, (int)train.getPosition().y + 60);
			}
			if (train.HEART == 4) {
				batch.draw(fullHeart, (int)train.getPosition().x, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+20, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+40, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+60, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+80, (int)train.getPosition().y + 60);
			}
			if (train.HEART == 3) {
				batch.draw(fullHeart, (int)train.getPosition().x, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+20, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+40, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+60, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+80, (int)train.getPosition().y + 60);
			}
			if (train.HEART == 2) {
				batch.draw(fullHeart, (int)train.getPosition().x, (int)train.getPosition().y + 60);
				batch.draw(fullHeart, (int)train.getPosition().x+20, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+40, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+60, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+80, (int)train.getPosition().y + 60);
			}
			if (train.HEART == 1) {
				batch.draw(fullHeart, (int)train.getPosition().x, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+20, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+40, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+60, (int)train.getPosition().y + 60);
				batch.draw(emptyHeart, (int)train.getPosition().x+80, (int)train.getPosition().y + 60);
			}
			if (train.TIME_PERSONLOAD > 0) {
				batch.draw(human, (int)train.getPosition().x+100, (int)train.getPosition().y + 60);
			}
			if (train.TIME_CARGOLOAD > 0) {
				batch.draw(box, (int)train.getPosition().x+120, (int)train.getPosition().y + 60);
			}
		}
        batch.end();
//        System.out.println(Gdx.input.getX());
//        System.out.println(Gdx.input.getY());
    }

}
