package com.thaitrain.mygdx.game;

public class World {
	
	private ThaitrainGame thaitrainGame;
	private Train train;
	
	World(ThaitrainGame thaitrainGame){
		
		this.thaitrainGame = thaitrainGame;
		train = new Train(860,194);
		}
	
	Train getTrain() {
		return train;
	}

	public void update(float delta) {
        train.update();
    }
}
