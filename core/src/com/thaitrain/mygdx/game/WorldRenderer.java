package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	
	private ThaitrainGame thaitrainGame;
	private TrainRenderer trainRenderer;
	private Texture BGImg;
	private Texture LeverRightImg;
	private Texture LeverLeftImg;
	private Lever leverTop;
	private Lever leverDown;
	BitmapFont scoreBitmap;
	private World world;
	String pointrender;
	
	WorldRenderer(ThaitrainGame thaitrainGame,World world){
		BGImg = new Texture("MAP.jpg");
		this.world = world;
		LeverRightImg = new Texture("leverRH.png");
		LeverLeftImg = new Texture("leverLH.png");
		this.thaitrainGame = thaitrainGame;
		trainRenderer = new TrainRenderer(thaitrainGame,world);
		leverTop = world.getLeverTop();
		leverDown = world.getLeverDown();
		scoreBitmap = new BitmapFont();
	}

	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		batch.draw(BGImg,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if(leverTop.Leverposition) {
			batch.draw(LeverRightImg,(int)leverTop.getPosition().x,(int)leverTop.getPosition().y);
		}
		else {
			batch.draw(LeverLeftImg,(int)leverTop.getPosition().x,(int)leverTop.getPosition().y);
		}
		if(leverDown.Leverposition) {
			batch.draw(LeverRightImg,(int)leverDown.getPosition().x,(int)leverDown.getPosition().y);
		}
		else {
			batch.draw(LeverLeftImg,(int)leverDown.getPosition().x,(int)leverDown.getPosition().y);
		}
		pointrender = "POINT : " + world.POINT;
		scoreBitmap.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		scoreBitmap.draw(batch,pointrender, 55, 480);
		batch.end();
		trainRenderer.render(delta);
	}

}
