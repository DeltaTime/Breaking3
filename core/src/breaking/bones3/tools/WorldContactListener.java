package breaking.bones3.tools;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import breaking.bones3.PlayGame;
import breaking.bones3.scenes.Hud;
import breaking.bones3.sprites.Enemy;
import breaking.bones3.sprites.InteractiveTileObject;
import breaking.bones3.sprites.Player;
import breaking.bones3.sprites.Porta;
import com.badlogic.gdx.Gdx;

/**
 * Created by wolos on 16/05/2016.
 */
public class WorldContactListener implements ContactListener{

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;
   
        
        switch (cDef){
            case PlayGame.PLAYER_BIT | PlayGame.ENEMY_BIT:
                if(fixA.getFilterData().categoryBits == PlayGame.PLAYER_BIT){
                    Gdx.app.log("Colisao: Player -> ","Inimigo");
                    Hud.reduzirVida(1);
                    }
            case PlayGame.PLAYER_BIT | PlayGame.OBJECT_BIT:
                if(fixA.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(fixA.getUserData().getClass())){
                ((InteractiveTileObject)fixA.getUserData()).onEspadaHit();
                

        }

        
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
