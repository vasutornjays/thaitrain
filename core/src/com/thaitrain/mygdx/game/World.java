package com.thaitrain.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

public class World {
	
	Lever leverTop;
	Lever leverDown;
	private ArriveTrain arriveTrain;
	int POINT = 3;
	int trainNum = 0;
	int removeTrainAtWay;
	int PERSON_TRAIN = 1;
	int CARGO_TRAIN = 2;
	int WAY_DOWN = 1;
	int WAY_TOP = 2;
	
	World(ThaitrainGame thaitrainGame){
		
		arriveTrain = new ArriveTrain(this);
		arriveTrain.addTrain("one",1,CARGO_TRAIN); // init_train
		arriveTrain.addTrain("two",2,PERSON_TRAIN);
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
	
	public void spawnTrain(int way) {
		int ranType = MathUtils.random(1,2);
		arriveTrain.addTrain("(String)trainNum",way,ranType);
		trainNum ++;
	}
	
	private void quitFormStation() {
		for (int i = 0;i<arriveTrain.getSize();i++) {
			if (arriveTrain.getTrainAtIndex(i).STAGE == 4) {
				removeTrainAtWay = arriveTrain.getTrainAtIndex(i).WAY;
				arriveTrain.removeTrain(i);
				spawnTrain(removeTrainAtWay);
			}
		}
	}

	public void update(float delta) {
        arriveTrain.update();
        quitFormStation();
    }
}
