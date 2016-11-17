package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	
	private ThaitrainGame thaitrainGame;
	private TrainRenderer trainRenderer;
	private Texture BGImg;
	private Texture leverRightImg;
	private Texture leverLeftImg;
	private Texture money;
	Lever lever1;
	Lever lever2;
	Lever lever3;
	Lever lever4;
	BitmapFont scoreBitmap;
	private World world;
	String pointrender;
	static int heartBoxSize = 60;
	
	WorldRenderer(ThaitrainGame thaitrainGame,World world){
		BGImg = new Texture("MAPFULL.png");
		this.world = world;
		leverRightImg = new Texture("leverRH.png");
		leverLeftImg = new Texture("leverLH.png");
		money = new Texture("money.png");
		this.thaitrainGame = thaitrainGame;
		trainRenderer = new TrainRenderer(thaitrainGame,world);
		lever1 = world.getLever1();
		lever2 = world.getLever2();
		lever3 = world.getLever3();
		lever4 = world.getLever4();
		scoreBitmap = new BitmapFont();
	}

	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		batch.draw(BGImg,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (lever1.Leverposition) {
			batch.draw(leverRightImg,(int)lever1.getPosition().x,(int)lever1.getPosition().y);
		}
		else {
			batch.draw(leverLeftImg,(int)lever1.getPosition().x,(int)lever1.getPosition().y);
		}
		if (lever2.Leverposition) {
			batch.draw(leverRightImg,(int)lever2.getPosition().x,(int)lever2.getPosition().y);
		}
		else {
			batch.draw(leverLeftImg,(int)lever2.getPosition().x,(int)lever2.getPosition().y);
		}
		if (lever3.Leverposition) {
			batch.draw(leverRightImg,(int)lever3.getPosition().x,(int)lever3.getPosition().y);
		}
		else {
			batch.draw(leverLeftImg,(int)lever3.getPosition().x,(int)lever3.getPosition().y);
		}
		if (lever4.Leverposition) {
			batch.draw(leverRightImg,(int)lever4.getPosition().x,(int)lever4.getPosition().y);
		}
		else {
			batch.draw(leverLeftImg,(int)lever4.getPosition().x,(int)lever4.getPosition().y);
		}
		for(int i = 0;i<world.LIFE;i++) {
			batch.draw(money,300 + (i * heartBoxSize),300);
		}
		pointrender = "POINT : " + world.POINT;
		scoreBitmap.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		scoreBitmap.draw(batch,pointrender, 55, 480);
		batch.end();
		trainRenderer.render(delta);
	}

}
