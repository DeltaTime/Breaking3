package breaking.bones3.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;
import breaking.bones3.screens.PlayScreenCasa;

/**
 * Created by wolos on 12/05/2016.
 */
public abstract class InteractiveTileObject extends Sprite {

    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;

    public InteractiveTileObject(World world, TiledMap map, Rectangle bounds){
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX()+ bounds.getWidth()/2)/ PlayGame.PPM, (bounds.getY()+ bounds.getHeight()/2)/PlayGame.PPM);

        body = world.createBody(bdef);

        shape.setAsBox(bounds.getWidth()/2/PlayGame.PPM,bounds.getHeight()/2/PlayGame.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);


    }

    public abstract void onEspadaHit(); // COLISAO

    public void setCategoryFilter (short filterBit){
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);


    }

    public TiledMapTileLayer.Cell getCell(){
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(2); // esqueleto grande exemplo da layer
        return layer.getCell((int)(body.getPosition().x * PlayGame.PPM /16),
                (int)(body.getPosition().y * PlayGame.PPM / 16));

    }



}
