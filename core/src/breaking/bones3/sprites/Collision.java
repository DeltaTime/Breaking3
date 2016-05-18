package breaking.bones3.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.screens.PlayScreen;

/**
 * Created by wolos on 12/05/2016.
 */
public class Collision extends InteractiveTileObject {
    public Collision(PlayScreen screen, Rectangle bounds){

        super(screen,bounds);
        fixture.setUserData(this);

    }

    @Override
    public void onEspadaHit() {

    }
}
