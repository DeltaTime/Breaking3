package breaking.bones3.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import breaking.bones3.PlayGame;
import breaking.bones3.sprites.Bau;
import breaking.bones3.sprites.Parede;
import breaking.bones3.sprites.Porta;
import breaking.bones3.sprites.Vasos;

/**
 * Created by wolos on 12/05/2016.
 */
public class B2WorldCreator {
    
    private World world;
    private TiledMap map;
    
    public B2WorldCreator(World world, TiledMap map){
        this.world = world;
        this.map = map;
        
        //create body and fixture variables
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;


        //CHAO PAREDES
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / PlayGame.PPM, (rect.getY() + rect.getHeight() / 2) / PlayGame.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / PlayGame.PPM, rect.getHeight() / 2 / PlayGame.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = PlayGame.OBJECT_BIT;
            body.createFixture(fdef);
        }


        //Parede
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Parede(world, map, rect);
        }

        //Bau
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Bau(world, map, rect);
        }

        //Vasos
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Vasos(world, map, rect);
        }

        //Porta
        for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Porta(world, map, rect);
        }






        


















    }



}
