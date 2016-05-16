package breaking.bones3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import breaking.bones3.screens.PlayScreen;
import breaking.bones3.screens.TelaAbertura;

public class PlayGame extends Game {
	public SpriteBatch batch;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 800;
	public static final int V_WIDTH = 600;
	public static final int V_HEIGHT = 480;
	public static final float PPM = 100; //pixel per meter

	public static final short DEFAULT_BIT = 1;
	public static final short PLAYER_BIT = 2;
	public static final short PECAS_BIT = 4;
	public static final short PAREDE_BIT = 8;
	public static final short PEDRA_BIT = 4;
	public static final short OSSO_BIT = 8;
	public static final short DOOR_BIT = 8;
	public static final short DESTROY_BIT = 16;



	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new TelaAbertura(this));

	}

	@Override
	public void render () {
		super.render();
	}
}
