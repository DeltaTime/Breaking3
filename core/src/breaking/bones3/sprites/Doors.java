package breaking.bones3.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;

/**
 * Created by wolos on 12/05/2016.
 */
public class Doors extends InteractiveTileObject{



    public Doors(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(PlayGame.DOOR_BIT);
    }
    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Porta");
        setCategoryFilter(PlayGame.DESTROY_BIT);

    }
}
