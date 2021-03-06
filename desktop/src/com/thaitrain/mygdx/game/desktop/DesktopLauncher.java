package com.thaitrain.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thaitrain.mygdx.game.ThaitrainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ThaitrainGame.WIDTH;
        config.height = ThaitrainGame.HEIGHT;
		new LwjglApplication(new ThaitrainGame(), config);
	}
}
