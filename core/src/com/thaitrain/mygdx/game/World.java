package com.thaitrain.mygdx.game;

public class World {
	
	private ThaitrainGame thaitrainGame;
	Lever leverTop;
	Lever leverDown;
	private ArriveTrain arriveTrain;
	
	World(ThaitrainGame thaitrainGame){
		
		this.thaitrainGame = thaitrainGame;
		arriveTrain = new ArriveTrain();
		arriveTrain.addTrain("one",1,2);
		arriveTrain.addTrain("two",2,1);
		leverTop = new Lever(592,317);
		leverDown = new Lever(0,122);
		}
	
	ArriveTrain gettrainArr() {
		return arriveTrain;
	}
	
	Lever getLeverTop() {
		return leverTop;
	}
	
	Lever getLeverDown() {
		return leverDown;
	}

	public void update(float delta) {
        arriveTrain.update();
    }
}
