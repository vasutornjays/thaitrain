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
	static int WAY_DOWN = 1;
	static int WAY_TOP = 2;
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
	
	
	
	public Train(int way,int type,World world) {
		WAY = way;
		TYPE = type;
		this.world = world;
		setTrainChar();
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
	
	public void setTrainChar() {
		if (WAY == WAY_DOWN) {
			position = new Vector2(STARTDOWNX,STARTDOWNY);
			clickBox = new Rectangle(STARTDOWNX,STARTDOWNY,150,50);
			PLATFORM_X = 400;
			DEPART_X = -150;
			TURNPOINT_X = 200;
			CARGO_X = 200;
			CARGO_Y = 70;
			DIR = 1;
		} else if (WAY == WAY_TOP) {
			position = new Vector2(STARTTOPX,STARTTOPY);
			clickBox = new Rectangle(STARTTOPX,STARTTOPY,150,50);
			PLATFORM_X = 400;
			DEPART_X = 800;
			TURNPOINT_X = 600;
			CARGO_X = 600;
			CARGO_Y = 400;
			DIR = -1;
		}
		
		/// TRAIN TYPE ///
		
			/// PERSON TRAIN ///
		
		if (TYPE == PERSON_TRAIN) {
			trainImg = new Texture("trainPass.png");
			trainImgTurn = new Texture("trainPass.png");
			RIGHTWAY = AT_DEPART;
			WRONGWAY = AT_CARGO;
			TRAIN_SPEED = (float) 9 * DIR;
			TIME_WAIT = 300;
			TIME_PERSONLOAD = 50;
			TIME_CARGOLOAD = 0;
			
			/// CARGO_TRAIN ///
			
		} else if (TYPE == CARGO_TRAIN) {
			trainImg = new Texture("train.png");
			trainImgTurn = new Texture("train.png");
			RIGHTWAY = AT_CARGO;
			WRONGWAY = AT_DEPART;
			TRAIN_SPEED = (float) 5 * DIR;
			TIME_WAIT = 300;
			TIME_PERSONLOAD = 0;
			TIME_CARGOLOAD = 50;
		}
	}
	
	public int moveTo() {
		if (STAGE == AT_PLATFORM) {
			if(!positionCheck(AT_PLATFORM)) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if(positionCheck(AT_PLATFORM) && dropPerson())
			{
				return AT_PLATFORM;
			}
		}
		if (STAGE == AT_DEPART) {
			if (!positionCheck(AT_DEPART)) {
				position.x -= TRAIN_SPEED;
				clickBox.x -= TRAIN_SPEED;
			}
			if (positionCheck(AT_DEPART))
			{
				return AT_DEPART;
			}
		}
		if (STAGE == AT_CARGO) {
			if (!positionCheck(AT_CARGO) && CANGOTOCARGO) {
				position.x -= TRAIN_SPEED/2;
				clickBox.x -= TRAIN_SPEED/2;
				position.y -= TRAIN_SPEED/2;
				clickBox.y -= TRAIN_SPEED/2;
			}
			if (positionCheck(AT_CARGO) && dropCargo()) {
				return AT_CARGO;
			}
			if (!positionCheck(AT_TURNPOINT)) {
				position.x -=TRAIN_SPEED;
				clickBox.x -=TRAIN_SPEED;
			}
			if (positionCheck(AT_TURNPOINT)) {
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
		if (moveTo() == WRONGWAY || TIME_NOW <= 0) {
			world.POINT --;
			//System.out.println(world.POINT);
			STAGE = FIN;
		}
		if (moveTo() == RIGHTWAY && (TIME_PERSONLOAD+TIME_CARGOLOAD) <=0) { 
			world.POINT ++;
			//System.out.println(world.POINT);
			STAGE = FIN;
		}
	}
	
	public boolean dropPerson() {
		if (positionCheck(AT_PLATFORM)) {
			TIME_PERSONLOAD--;
			//System.out.println(TIME_PERSONLOAD);
			if (TIME_PERSONLOAD <=0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dropCargo() {
		if (positionCheck(AT_CARGO)) {
			TIME_CARGOLOAD--;
			//System.out.println(TIME_CARGOLOAD);
			if (TIME_CARGOLOAD <=0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean positionCheck(int destination) {
		if (WAY == 1) {
			if (destination == AT_PLATFORM) {
				if (position.x > PLATFORM_X) {
					return false;
				} else if (position.x <= PLATFORM_X) {
					return true;
				}
			}
			if (destination == AT_DEPART) {
				if (position.x > DEPART_X) {
					return false;
				} else if (position.x <= DEPART_X) {
					return true;
				}
			}
			if (destination == AT_TURNPOINT) {
				if (position.x > TURNPOINT_X) {
					return false;
				}
				else if (position.x <= TURNPOINT_X) {
					return true;
				}
			}
			if (destination == AT_CARGO) {
				if (position.y > CARGO_Y) {
					return false;
				} else if(position.y <= CARGO_Y) {
					return true;
				}	
			}
		}
		if (WAY == 2) {
			if (destination == AT_PLATFORM) {
				if (position.x < PLATFORM_X) {
					return false;
				} else if (position.x >= PLATFORM_X) {
					return true;
				}
			}
			if (destination == AT_DEPART) {
				if (position.x < DEPART_X) {
					return false;
				} else if (position.x >= DEPART_X) {
					return true;
				}
			}
			if (destination == AT_TURNPOINT) {
				if (position.x < TURNPOINT_X) {
					return false;
				} else if (position.x >= TURNPOINT_X) {
					return true;
				}
			}
			if (destination == AT_CARGO) {
				if (position.y <= CARGO_Y) {
					return false;
				} else if (position.y >= CARGO_Y) {
					return true;
				}	
			}
		}
		return false;
	}
}