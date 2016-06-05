package breaking.bones3.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.screens.PlayScreenCasa;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by wolos on 19/05/2016.
 */
public abstract class ObjetosInterativos extends Sprite {
    protected World world;
    protected TextureAtlas atlas;

    public Body b2body;

    public ObjetosInterativos(World world, TextureAtlas atlas, float x, float y){
        this.world = world;
        this.atlas = atlas;
        setPosition(x,y);
        defineObjeto();

    }

    protected abstract void defineObjeto();
    public abstract void hitonColision(Player userData);




}
