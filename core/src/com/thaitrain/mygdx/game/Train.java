package com.thaitrain.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Train {
	Texture trainImg;
	Texture trainImgTurn;
	private Vector2 position;
	private Rectangle clickBox;
	private World world;
	int STAGE = 0;
	static int PERSON_TRAIN = 1;
	static int CARGO_TRAIN = 2;
	static int COMBI_TRAIN = 3;
	static int WAY_1 = 1;
	static int WAY_2 = 2;
	static int WAY_3 = 3;
	static int WAY_4 = 4;
	static int AT_STATION = 0;
	static int AT_PLATFORM = 1;
	static int AT_DEPART = 2;
	static int AT_CARGO = 3;
	static int FIN = 4;
	static int AT_TURNPOINT = 5;
	static int STARTDOWNX = 860;
	static int STARTDOWNY = 200;
	static int STARTTOPX = 0;
	static int STARTTOPY = 285;
	boolean CANGOTOCARGO = false;
	int DIR;
	int  PLATFORM_X;
	int DEPART_X;
	int CARGO_X;
	int  PLATFORM_Y;
	int DEPART_Y;
	int CARGO_Y;
	int TURNPOINT_X;
	int TURNPOINT_Y;
	float TRAIN_SPEED; 		
	int RIGHTWAY;
	int WRONGWAY;
	int WAY;
	int TYPE;
	int TIME_WAIT;
	int TIME_NOW;
	int TIME_PERSONLOAD;
	int TIME_CARGOLOAD;
	int HEART = 5;
	int map_shift = 510;
	
	
	
	public Train(int way,int type,World world) {
		WAY = way;
		TYPE = type;
		this.world = world;
		setTrainChar();
		setTrainImg();
		TIME_NOW = TIME_WAIT;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getClickBox() {
		return clickBox;
	}
	
	public int nextStage() {
		return ++STAGE;
	}
	
	public int currentStage() {
		return STAGE;
	}
	
	public int getWay() {
		return WAY;
	}
	
	public void update() {
		moveTo();
		quit();
		TIME_NOW--;
		heartCheck();
		dropPerson();
		dropCargo();
	}
	
	public void setTrainImg() {
		if (TYPE == PERSON_TRAIN && (WAY == WAY_1 || WAY == WAY_3)) {
			trainImg = new Texture("trainPassR.png");
			trainImgTurn = new Texture("trainPassR.png");
		}
		if (TYPE == PERSON_TRAIN && (WAY == WAY_2 || WAY == WAY_4)) {
			trainImg = new Texture("trainPassL.png");
			trainImgTurn = new Texture("trainPassL.png");
		}
		if (TYPE == CARGO_TRAIN && (WAY == WAY_1 || WAY == WAY_3)) {
			trainImg = new Texture("trainCargoR.png");
			trainImgTurn = new Texture("trainCargoR.png");
		}
		if (TYPE == CARGO_TRAIN && (WAY == WAY_2 || WAY == WAY_4)) {
			trainImg = new Texture("trainCargoL.png");
			trainImgTurn = new Texture("trainCargoL.png");
		}
		if (TYPE == COMBI_TRAIN && (WAY == WAY_1 || WAY == WAY_3)) {
			trainImg = new Texture("trainCombiR.png");
			trainImgTurn = new Texture("trainCombiR.png");
		}
		if (TYPE == COMBI_TRAIN && (WAY == WAY_2 || WAY == WAY_4)) {
			trainImg = new Texture("trainCombiL.png");
			trainImgTurn = new Texture("trainCombiL.png");
		}
		
	}
	
	public void setTrainChar() {
		if (WAY == WAY_2) {
			position = new Vector2(STARTDOWNX,STARTDOWNY + map_shift);
			clickBox = new Rectangle(STARTDOWNX,STARTDOWNY + map_shift,150,50);
			PLATFORM_X = 400;
			DEPART_X = -150;
			TURNPOINT_X = 300;
			CARGO_X = 300;
			CARGO_Y = 100 + map_shift;
			DIR = 1;
		} else if (WAY == WAY_1) {
			position = new Vector2(STARTTOPX,STARTTOPY + map_shift);
			clickBox = new Rectangle(STARTTOPX,STARTTOPY + map_shift,150,50);
			PLATFORM_X = 400;
			DEPART_X = 800;
			TURNPOINT_X = 680;
			CARGO_X = 680;
			CARGO_Y = 300 + map_shift;
			DIR = -1;
		} else if (WAY == WAY_4) {
			position = new Vector2(STARTDOWNX,STARTDOWNY);
			clickBox = new Rectangle(STARTDOWNX,STARTDOWNY,150,50);
			PLATFORM_X = 400;
			DEPART_X = -150;
			TURNPOINT_X = 300;
			CARGO_X = 300;
			CARGO_Y = 100;
			DIR = 1;
		} else if (WAY == WAY_3) {
			position = new Vector2(STARTTOPX,STARTTOPY);
			clickBox = new Rectangle(STARTTOPX,STARTTOPY,150,50);
			PLATFORM_X = 400;
			DEPART_X = 800;
			TURNPOINT_X = 680;
			CARGO_X = 680;
			CARGO_Y = 300;
			DIR = -1;
		}
		
		/// TRAIN TYPE ///
		
			/// PERSON TRAIN ///
		
		if (TYPE == PERSON_TRAIN) {
			RIGHTWAY = AT_DEPART;
			WRONGWAY = AT_CARGO;
			TRAIN_SPEED = (float) 1.2 * DIR;
			TIME_WAIT = 1000;
			TIME_PERSONLOAD = 500;
			TIME_CARGOLOAD = 0;
			
			/// CARGO_TRAIN ///
			
		} else if (TYPE == CARGO_TRAIN) {
			RIGHTWAY = AT_CARGO;
			WRONGWAY = AT_DEPART;
			TRAIN_SPEED = (float) 1 * DIR;
			TIME_WAIT = 1200;
			TIME_PERSONLOAD = 0;
			TIME_CARGOLOAD = 500;
		} else if (TYPE == COMBI_TRAIN) {
			RIGHTWAY = AT_CARGO;
			WRONGWAY = AT_DEPART;
			TRAIN_SPEED = (float) 1 * DIR;
			TIME_WAIT = 1700;
			TIME_PERSONLOAD = 400;
			TIME_CARGOLOAD = 500;
		}
		
	}
	
	public int moveTo() {
		if (STAGE == AT_PLATFORM) {
			if(!Gamelogic.positionCheck(AT_PLATFORM,this,WAY)) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if(Gamelogic.positionCheck(AT_PLATFORM,this,WAY) && dropPerson())
			{
				return AT_PLATFORM;
			}
		}
		if (STAGE == AT_DEPART) {
			if (!Gamelogic.positionCheck(AT_DEPART,this,WAY)) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if (Gamelogic.positionCheck(AT_DEPART,this,WAY))
			{
				return AT_DEPART;
			}
		}
		if (STAGE == AT_CARGO) {
			if (!Gamelogic.positionCheck(AT_CARGO,this,WAY) && CANGOTOCARGO) {
				position.x -= TRAIN_SPEED/2;
				clickBox.x -= TRAIN_SPEED/2;
				position.y -= TRAIN_SPEED/2;
				clickBox.y -= TRAIN_SPEED/2;
			}
			if (Gamelogic.positionCheck(AT_CARGO,this,WAY) && dropCargo()) {
				return AT_CARGO;
			}
			if (!Gamelogic.positionCheck(AT_TURNPOINT,this,WAY)) {
				position.x -=TRAIN_SPEED;
				clickBox.x -=TRAIN_SPEED;
			}
			if (Gamelogic.positionCheck(AT_TURNPOINT,this,WAY)) {
				CANGOTOCARGO = true;
			}
		}
		return AT_STATION;
	}
	
	public void heartCheck() {
		if (TIME_NOW >= TIME_WAIT) {
			HEART = 5;
		}
		else if (TIME_NOW >= TIME_WAIT*80/100) {
			HEART = 4;
		}
		else if (TIME_NOW >= TIME_WAIT*60/100) {
			HEART = 4;
		}
		else if (TIME_NOW >= TIME_WAIT*40/100) {
			HEART = 3;
		}
		else if (TIME_NOW >= TIME_WAIT*20/100) {
			HEART = 2;
		}
		else if (TIME_NOW >= 0) {
			HEART = 1;
		}
	}
	
	public void quit() {
		if (moveTo() == RIGHTWAY && (TIME_PERSONLOAD+TIME_CARGOLOAD) <=0) { 
			world.POINT++ ;
			STAGE = FIN;
		}
		else if (moveTo() == WRONGWAY || TIME_NOW <= 0) {
			STAGE = FIN;
			world.LIFE = world.LIFE - 1;
		}
	}
	
	public boolean dropPerson() {
		if (Gamelogic.positionCheck(AT_PLATFORM,this,WAY)) {
			TIME_PERSONLOAD--;
			if (TIME_PERSONLOAD <=0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dropCargo() {
		if (Gamelogic.positionCheck(AT_CARGO,this,WAY)) {
			TIME_CARGOLOAD--;
			//System.out.println(TIME_CARGOLOAD);
			if (TIME_CARGOLOAD <=0) {
				return true;
			}
		}
		return false;
	}
	
}