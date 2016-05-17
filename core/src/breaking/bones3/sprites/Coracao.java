package breaking.bones3.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;

/**
 * Created by wolos on 17/05/2016.
 */
public class Coracao extends InteractiveTileObject {

    public Coracao(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(PlayGame.CORACAO_BIT);
    }
    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Coracao");
        setCategoryFilter(PlayGame.DESTROY_BIT);
        getCell().setTile(null);

    }
}