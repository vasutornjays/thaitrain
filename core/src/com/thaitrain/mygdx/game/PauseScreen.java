package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PauseScreen extends ScreenAdapter {
	ThaitrainGame thaitraingame;
	BitmapFont font;
	
	public PauseScreen(ThaitrainGame thaitraingame){
		this.thaitraingame = thaitraingame;
		font = new BitmapFont();
		
	}

	
	public void render(float delta){
		resumeCheck();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = thaitraingame.batch;

        batch.begin();
        font.setColor(Color.RED);
        font.draw(batch, "PAUSE", 400, 300);
//        batch.setShader(GrayscaleShader.grayscaleShader);
        batch.end();
	}
	
	public void resumeCheck(){
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)&&!thaitraingame.escPress){
			thaitraingame.resumeGame();
		} else if(thaitraingame.escPress&&!Gdx.input.isKeyPressed(Keys.ESCAPE))
			thaitraingame.escPress = false;		
	}
}
