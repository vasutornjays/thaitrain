package com.thaitrain.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class World {
	
	Lever lever1;
	Lever lever2;
	Lever lever3;
	Lever lever4;
	private ArriveTrain arriveTrain;
	int POINT = 0;
	int LIFE = 3;
	int trainNum = 0;
	int removeTrainAtWay;
	int PERSON_TRAIN = 1;
	int CARGO_TRAIN = 2;
	int COMBI_TRAIN = 3;
	
	World(ThaitrainGame thaitrainGame){
		
		arriveTrain = new ArriveTrain(this);
		arriveTrain.addTrain("one",Train.WAY_1,CARGO_TRAIN); // init_train
		arriveTrain.addTrain("two",Train.WAY_2,PERSON_TRAIN);
		arriveTrain.addTrain("three",Train.WAY_3,CARGO_TRAIN); // init_train
		arriveTrain.addTrain("four",Train.WAY_4,PERSON_TRAIN);
		lever1 = new Lever(592,827);
		lever2 = new Lever(0,632);
		lever3 = new Lever(592,317);
		lever4 = new Lever(0,122);
		}
	
	ArriveTrain gettrainArr() {
		return arriveTrain;
	}
	
	Lever getLever1() {
		return lever1;
	}
	
	Lever getLever2() {
		return lever2;
	}
	
	Lever getLever3() {
		return lever3;
	}
	
	Lever getLever4() {
		return lever4;
	}
	
	
	public void spawnTrain(int way) {
		int ranType = MathUtils.random(1,3);
		arriveTrain.addTrain("(String)trainNum",way,ranType);
		trainNum ++;
	}
	
	private void quitFormStation() {
		for (int i = 0;i<arriveTrain.getSize();i++) {
			if (arriveTrain.getTrainAtIndex(i).STAGE == Train.FIN) {
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
