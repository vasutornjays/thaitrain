package com.thaitrain.mygdx.game;

import java.util.ArrayList;

public class ArriveTrain {
	
	private ArrayList<Train> trainArr;
	private World world;
	
	 public ArriveTrain(World world) {
	        trainArr = new ArrayList<Train>();
	        this.world = world;
	    }
	 
	public void addTrain(String TrainName,int way,int type) {
        trainArr.add(new Train(way,type,world));
    }
	
	public ArrayList<Train> gettrainArr() {
		return trainArr;
	}
	
	public void removeTrain(int index) {
		trainArr.remove(index);
	}
	
	public void update() {
		for(int i = 0;i<trainArr.size();i++) {
			trainArr.get(i).update();
		}
	}
	
	public int getSize() {
		return trainArr.size();
	}

	public Train getTrainAtIndex(int index) {
		return trainArr.get(index);
	}
}
