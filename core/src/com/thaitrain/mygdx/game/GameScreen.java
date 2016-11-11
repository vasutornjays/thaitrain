package com.thaitrain.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
	static Vector2 mousepress;
	boolean isClick = false;
	Lever leverTop;
	Lever leverDown;
	
	public GameScreen(ThaitrainGame thaitrainGame) {
		this.thaitrainGame = thaitrainGame;
		world = new World(thaitrainGame);
		worldRenderer = new WorldRenderer(thaitrainGame,world);
		arrivetrain = world.gettrainArr();
		leverTop = world.getLeverTop();
		leverDown = world.getLeverDown();
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
    }
	
	public void click() {
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && !isClick) {
        	isClick = true;
        }
        if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && isClick) {
        	isClick = false;
        	
        	for(int i = 0;i<arrivetrain.getSize();i++) {
        		if(arrivetrain.getTrainAtIndex(i).WAY == 1){
        			if(checkTagetClick(arrivetrain.getTrainAtIndex(i).getClickBox()) && arrivetrain.getTrainAtIndex(i).currentStage() == 0) {
        				arrivetrain.getTrainAtIndex(i).STAGE = 1;
        			} else if(checkTagetClick(arrivetrain.getTrainAtIndex(i).getClickBox()) && leverDown.Leverposition && arrivetrain.getTrainAtIndex(i).dropPerson()) {
        				arrivetrain.getTrainAtIndex(i).STAGE = 2;
        			} else if(checkTagetClick(arrivetrain.getTrainAtIndex(i).getClickBox()) && !leverDown.Leverposition && arrivetrain.getTrainAtIndex(i).dropPerson()) {
        				arrivetrain.getTrainAtIndex(i).STAGE = 3;
        			}
        		}
        		if(arrivetrain.getTrainAtIndex(i).WAY == 2){
        			if(checkTagetClick(arrivetrain.getTrainAtIndex(i).getClickBox()) && arrivetrain.getTrainAtIndex(i).currentStage() == 0) {
        				arrivetrain.getTrainAtIndex(i).STAGE = 1;
        			} else if(checkTagetClick(arrivetrain.getTrainAtIndex(i).getClickBox()) && leverTop.Leverposition && arrivetrain.getTrainAtIndex(i).dropPerson()) {
        				arrivetrain.getTrainAtIndex(i).STAGE = 2;
        			} else if(checkTagetClick(arrivetrain.getTrainAtIndex(i).getClickBox()) && !leverTop.Leverposition && arrivetrain.getTrainAtIndex(i).dropPerson()) {
        				arrivetrain.getTrainAtIndex(i).STAGE = 3;
        			}
        		}
        	}
        	if(checkTagetClick(leverTop.getClickBox())) {
        		leverTop.Clicked();
        	}
        	if(checkTagetClick(leverDown.getClickBox())) {
        		leverDown.Clicked();
        	}
        }
	}
	
	private boolean checkTagetClick(Rectangle Taget) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), -Gdx.input.getY() + 522, 0);

        if (Taget.contains(touchPos.x, touchPos.y)) {
            return true;
        } else {
            return false;
        }
	}

}
