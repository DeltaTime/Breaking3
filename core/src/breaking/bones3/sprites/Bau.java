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
public class Bau extends InteractiveTileObject {

    private static TiledMapTileSet tileSet;
    private final int BLANK_OBJECT = 44; // tem q pegar do mesmo tile set ID do tile
    
    public Bau(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        tileSet = map.getTileSets().getTileSet("Bones_C");
        fixture.setUserData(this);
        setCategoryFilter(PlayGame.PECAS_BIT);
    }
    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Bau");
        //setCategoryFilter(PlayGame.DESTROY_BIT); // destroi
       //getCell().setTile(null); // desaparece a figura
        getCell().setTile(tileSet.getTile(363));
        //Hud.addScore(0);
        PlayGame.maneger.get("audio/sfx/breakblock.wav", Sound.class).play();

    }
}
