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
	private Lever leverTop;
	private Lever leverDown;
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
		leverTop = world.getLeverTop();
		leverDown = world.getLeverDown();
		scoreBitmap = new BitmapFont();
	}

	public void render(float delta) {
		SpriteBatch batch = thaitrainGame.batch;
		batch.begin();
		batch.draw(BGImg,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (leverTop.Leverposition) {
			batch.draw(leverRightImg,(int)leverTop.getPosition().x,(int)leverTop.getPosition().y);
		}
		else {
			batch.draw(leverLeftImg,(int)leverTop.getPosition().x,(int)leverTop.getPosition().y);
		}
		if (leverDown.Leverposition) {
			batch.draw(leverRightImg,(int)leverDown.getPosition().x,(int)leverDown.getPosition().y);
		}
		else {
			batch.draw(leverLeftImg,(int)leverDown.getPosition().x,(int)leverDown.getPosition().y);
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
