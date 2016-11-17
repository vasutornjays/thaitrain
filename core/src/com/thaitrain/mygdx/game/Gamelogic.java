package com.thaitrain.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Gamelogic {

	
	public static boolean positionCheck(int destination,Train train,int WAY) {
		
		Vector2 position = train.getPosition();
		
		if (WAY == 2) {
			if (destination == Train.AT_PLATFORM) {
				if (position.x > train.PLATFORM_X) {
					return false;
				} else if (position.x <= train.PLATFORM_X) {
					return true;
				}
			}
			if (destination == Train.AT_DEPART) {
				if (position.x > train.DEPART_X) {
					return false;
				} else if (position.x <= train.DEPART_X) {
					return true;
				}
			}
			if (destination == Train.AT_TURNPOINT) {
				if (position.x > train.TURNPOINT_X) {
					return false;
				}
				else if (position.x <= train.TURNPOINT_X) {
					return true;
				}
			}
			if (destination == Train.AT_CARGO) {
				if (position.y > train.CARGO_Y) {
					return false;
				} else if(position.y <= train.CARGO_Y) {
					return true;
				}	
			}
		}
		if (WAY == 1) {
			if (destination == Train.AT_PLATFORM) {
				if (position.x < train.PLATFORM_X) {
					return false;
				} else if (position.x >= train.PLATFORM_X) {
					return true;
				}
			}
			if (destination == Train.AT_DEPART) {
				if (position.x < train.DEPART_X) {
					return false;
				} else if (position.x >= train.DEPART_X) {
					return true;
				}
			}
			if (destination == Train.AT_TURNPOINT) {
				if (position.x < train.TURNPOINT_X) {
					return false;
				} else if (position.x >= train.TURNPOINT_X) {
					return true;
				}
			}
			if (destination == Train.AT_CARGO) {
				if (position.y <= train.CARGO_Y) {
					return false;
				} else if (position.y >= train.CARGO_Y) {
					return true;
				}	
			}
		} else if (WAY == 4) {
			if (destination == Train.AT_PLATFORM) {
				if (position.x > train.PLATFORM_X) {
					return false;
				} else if (position.x <= train.PLATFORM_X) {
					return true;
				}
			}
			if (destination == Train.AT_DEPART) {
				if (position.x > train.DEPART_X) {
					return false;
				} else if (position.x <= train.DEPART_X) {
					return true;
				}
			}
			if (destination == Train.AT_TURNPOINT) {
				if (position.x > train.TURNPOINT_X) {
					return false;
				}
				else if (position.x <= train.TURNPOINT_X) {
					return true;
				}
			}
			if (destination == Train.AT_CARGO) {
				if (position.y > train.CARGO_Y) {
					return false;
				} else if(position.y <= train.CARGO_Y) {
					return true;
				}	
			}
		} else if (WAY == 3) {
			if (destination == Train.AT_PLATFORM) {
				if (position.x < train.PLATFORM_X) {
					return false;
				} else if (position.x >= train.PLATFORM_X) {
					return true;
				}
			}
			if (destination == Train.AT_DEPART) {
				if (position.x < train.DEPART_X) {
					return false;
				} else if (position.x >= train.DEPART_X) {
					return true;
				}
			}
			if (destination == Train.AT_TURNPOINT) {
				if (position.x < train.TURNPOINT_X) {
					return false;
				} else if (position.x >= train.TURNPOINT_X) {
					return true;
				}
			}
			if (destination == Train.AT_CARGO) {
				if (position.y <= train.CARGO_Y) {
					return false;
				} else if (position.y >= train.CARGO_Y) {
					return true;
				}	
			}
		}
		return false;
	}
}
