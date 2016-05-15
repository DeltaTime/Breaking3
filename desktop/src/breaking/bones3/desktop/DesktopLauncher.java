package breaking.bones3.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import breaking.bones3.PlayGame;
import com.badlogic.gdx.Files;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.fullscreen = false;
                config.title = "The Breaking Bones";
                config.resizable = false;
                config.addIcon("boneslogoicon.png",Files.FileType.Local);
                
		new LwjglApplication(new PlayGame(), config);
	}
}
