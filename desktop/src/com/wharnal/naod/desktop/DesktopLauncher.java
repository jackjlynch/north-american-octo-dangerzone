package com.wharnal.naod.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.wharnal.naod.NaodGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "North American Octo-dangerzone";
		config .width = 1024;
		config.height = 256;
		new LwjglApplication(new NaodGame(), config);
	}
}
