package com.thaitrain.mygdx.game;

import java.util.ArrayList;

public class ArriveTrain {
	
	private ArrayList<Train> trainArr;
	
	 public ArriveTrain() {
	        trainArr = new ArrayList<Train>();
	    }
	 
	public void addTrain(String TrainName,int type,int x,int y) {
        trainArr.add(new Train(x,y));
    }
	
	public ArrayList<Train> gettrainArr() {
		return trainArr;
	}
	
	public void removeTrain(int index) {
		trainArr.remove(index);
	}
	
	public void update() {
		for(int i = 0;i<trainArr.size();i++)
		{
			trainArr.get(i).update();
		}
	}
	
	public int getSize(){
		return trainArr.size();
	}

	public Train getTrainAtIndex(int index) {
		return trainArr.get(index);
	}
}
