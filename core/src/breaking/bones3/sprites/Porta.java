package breaking.bones3.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;

/**
 * Created by wolos on 07/06/2016.
 */
public class Porta extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    public Porta(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        //tileSet = map.getTileSets().getTileSet("Bones_C");
        fixture.setUserData(this);
        setCategoryFilter(PlayGame.PECAS_BIT);
    }

    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Porta");
    }
}
