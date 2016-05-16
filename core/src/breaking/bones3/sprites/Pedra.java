package breaking.bones3.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;

/**
 * Created by wolos on 16/05/2016.
 */
public class Pedra extends InteractiveTileObject {
    public Pedra(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(PlayGame.PEDRA_BIT);




    }

    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Pedra");
        setCategoryFilter(PlayGame.DESTROY_BIT);


    }
}
