package com.thaitrain.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TrainRenderer {
	
	private ArriveTrain arrivetrain;
	private ThaitrainGame thaitrainGame;
	private Train train;
	Texture fullHeart;
	Texture emptyHeart;
	Texture human;
	Texture box;
	static int heartSize = 20;
	
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
			int x = (int)train.getPosition().x;
			int y = (int)train.getPosition().y;
			int heartPos = 0;
			if (train.CANGOTOCARGO) {
				batch.draw(train.trainImg, x, y, 0, 0, 150, 50, 1, 1, 40, 0 , 0, 150, 50, false, false);
			}
//			draw(Texture texture,
//	                 float x,
//	                 float y,
//	                 float originX,
//	                 float originY,
//	                 float width,
//	                 float height,
//	                 float scaleX,
//	                 float scaleY,
//	                 float rotation,
//	                 int srcX,
//	                 int srcY,
//	                 int srcWidth,
//	                 int srcHeight,
//	                 boolean flipX,
//	                 boolean flipY)
			else {
				batch.draw(train.trainImg, x, y);
			}
			for(int j = 0;j<train.HEART;j++) {
				batch.draw(fullHeart, x + heartPos, y + 60);
				heartPos += heartSize;
			}
			for(int j = 0;j<5 - train.HEART;j++) {
				batch.draw(emptyHeart, x + heartPos, y + 60);
				heartPos += heartSize;
			}
			if (train.TIME_PERSONLOAD > 0) {
				batch.draw(human, x + 100, y + 60);
			}
			if (train.TIME_CARGOLOAD > 0) {
				batch.draw(box, x + 120, y + 60);
			} 
		}
        batch.end();
//        System.out.println(Gdx.input.getX());
//        System.out.println(Gdx.input.getY());
    }

}
