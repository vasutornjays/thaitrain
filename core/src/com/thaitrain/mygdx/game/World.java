package com.thaitrain.mygdx.game;

public class World {
	
	private ThaitrainGame thaitrainGame;
	private Train train;
	private Train train2;
	Lever leverTop;
	Lever leverDown;
	
	World(ThaitrainGame thaitrainGame){
		
		this.thaitrainGame = thaitrainGame;
		train = new Train(860,194);
		leverTop = new Lever(0,0);
		leverDown = new Lever(0,122);
		}
	
	Train getTrain() {
		return train;
	}
	
	Lever getLeverTop() {
		return leverTop;
	}
	
	Lever getLeverDown() {
		return leverDown;
	}

	public void update(float delta) {
        train.update();
    }
}
