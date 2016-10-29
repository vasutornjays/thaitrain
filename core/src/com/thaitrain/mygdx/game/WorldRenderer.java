package com.thaitrain.mygdx.game;

public class WorldRenderer {
	
	private ThaitrainGame thaitrainGame;
	private World world;
	private TrainRenderer trainRenderer;
	
	WorldRenderer(ThaitrainGame thaitrainGame,World world){
		this.thaitrainGame = thaitrainGame;
		trainRenderer = new TrainRenderer(thaitrainGame,world);
	}

	public void render(float delta) {
		trainRenderer.render(delta);
	}

}
