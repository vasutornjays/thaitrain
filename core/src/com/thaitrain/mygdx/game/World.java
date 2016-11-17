package com.thaitrain.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class World {
	
	Lever leverTop;
	Lever leverDown;
	private ArriveTrain arriveTrain;
	int POINT = 0;
	int LIFE = 3;
	int trainNum = 0;
	int removeTrainAtWay;
	int PERSON_TRAIN = 1;
	int CARGO_TRAIN = 2;
	int COMBI_TRAIN = 3;
	int WAY_LEFT = 1;
	int WAY_RIGHT = 2;
	
	World(ThaitrainGame thaitrainGame){
		
		arriveTrain = new ArriveTrain(this);
		arriveTrain.addTrain("one",WAY_LEFT,CARGO_TRAIN); // init_train
		arriveTrain.addTrain("two",WAY_RIGHT,PERSON_TRAIN);
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
		int ranType = MathUtils.random(1,3);
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
