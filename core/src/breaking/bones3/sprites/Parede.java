package breaking.bones3.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;
import breaking.bones3.scenes.Hud;
import breaking.bones3.screens.PlayScreen;

/**
 * Created by wolos on 16/05/2016.
 */
public class Parede extends InteractiveTileObject {

    public Parede(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(PlayGame.GROUND_BIT);
    }

    
    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Parede");
    }
}
