package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class GameScreen extends ScreenAdapter {
	
	private ThaitrainGame thaitrainGame;
	private ArriveTrain arrivetrain;
	World world;
	private WorldRenderer worldRenderer;
	private Train train;
	static Vector2 mousepress;
	boolean isClick = false;
	Lever lever1;
	Lever lever2;
	Lever lever3;
	Lever lever4;
	int nowStage = 2;
	int PLAY = 0;
	int PAUSE = 1;
	int GAMEOVER = 2;
	
	public GameScreen(ThaitrainGame thaitrainGame) {
		this.thaitrainGame = thaitrainGame;
		world = new World(thaitrainGame);
		worldRenderer = new WorldRenderer(thaitrainGame,world);
		arrivetrain = world.gettrainArr();
		lever1 = world.getLever1();
		lever2 = world.getLever2();
		lever3 = world.getLever3();
		lever4 = world.getLever4();
	}
	
	@Override
    public void render(float delta) {
    	update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        click();
        worldRenderer.render(delta);
    }
	
	private void update(float delta) {
    	world.update(delta);
    	pauseCheck();
    }
	
	public void click() {
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && !isClick) {
        	isClick = true;
        }
        if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && isClick) {
        	isClick = false;
        	
        	for(int i = 0;i<arrivetrain.getSize();i++) {
        		train = arrivetrain.getTrainAtIndex(i);
        		if (train.WAY == 1) {
        			if(checkTagetClick(train.getClickBox()) && train.currentStage() == 0) {
        				train.STAGE = 1;
        			} else if(checkTagetClick(train.getClickBox()) && lever1.Leverposition && train.dropPerson()) {
        				train.STAGE = 2;
        			} else if(checkTagetClick(train.getClickBox()) && !lever1.Leverposition && train.dropPerson()) {
        				train.STAGE = 3;
        			}
        		}
        		if (train.WAY == 2) {
        			if (checkTagetClick(train.getClickBox()) && train.currentStage() == 0) {
        				train.STAGE = 1;
        			} else if (checkTagetClick(train.getClickBox()) && lever2.Leverposition && train.dropPerson()) {
        				train.STAGE = 2;
        			} else if (checkTagetClick(train.getClickBox()) && !lever2.Leverposition && train.dropPerson()) {
        				train.STAGE = 3;
        			}
        		}
        		if (train.WAY == 3) {
        			if(checkTagetClick(train.getClickBox()) && train.currentStage() == 0) {
        				train.STAGE = 1;
        			} else if(checkTagetClick(train.getClickBox()) && lever3.Leverposition && train.dropPerson()) {
        				train.STAGE = 2;
        			} else if(checkTagetClick(train.getClickBox()) && !lever3.Leverposition && train.dropPerson()) {
        				train.STAGE = 3;
        			}
        		}
        		if (train.WAY == 4) {
        			if (checkTagetClick(train.getClickBox()) && train.currentStage() == 0) {
        				train.STAGE = 1;
        			} else if (checkTagetClick(train.getClickBox()) && lever4.Leverposition && train.dropPerson()) {
        				train.STAGE = 2;
        			} else if (checkTagetClick(train.getClickBox()) && !lever4.Leverposition && train.dropPerson()) {
        				train.STAGE = 3;
        			}
        		}
        	}
        	if(checkTagetClick(lever1.getClickBox())) {
        		lever1.Clicked();
        	}
        	if(checkTagetClick(lever2.getClickBox())) {
        		lever2.Clicked();
        	}
        	if(checkTagetClick(lever3.getClickBox())) {
        		lever3.Clicked();
        	}
        	if(checkTagetClick(lever4.getClickBox())) {
        		lever4.Clicked();
        	}
        }
	}
	
	public void pauseCheck(){
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)&&!thaitrainGame.escPress){
			thaitrainGame.pauseGame();
		} else if (thaitrainGame.escPress&&!Gdx.input.isKeyPressed(Keys.ESCAPE))
			thaitrainGame.escPress = false;
		
	}
	
	private boolean checkTagetClick(Rectangle Taget) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), -Gdx.input.getY() + 1044, 0);

        if (Taget.contains(touchPos.x, touchPos.y)) {
            return true;
        } else {
            return false;
        }
	}

}
