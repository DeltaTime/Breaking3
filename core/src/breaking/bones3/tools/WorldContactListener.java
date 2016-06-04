package breaking.bones3.tools;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import breaking.bones3.PlayGame;
import breaking.bones3.sprites.Enemy;
import breaking.bones3.sprites.InteractiveTileObject;
import breaking.bones3.sprites.Player;

/**
 * Created by wolos on 16/05/2016.
 */
public class WorldContactListener implements ContactListener{

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;
        
        if(fixA.getUserData() == "espada" || fixB.getUserData() == "espada"){
            Fixture espada = fixA.getUserData() == "espada" ? fixA : fixB;
            Fixture object = espada == fixA ? fixB : fixA;

            if(object.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject)object.getUserData()).onEspadaHit();

            }

        }
        
        
        switch (cDef){
            case PlayGame.ENEMY_COLISION_COLISION | PlayGame.PLAYER_BIT:
                if(fixA.getFilterData().categoryBits == PlayGame.ENEMY_COLISION_COLISION)
                    ((Enemy)fixA.getUserData()).hitonColision((Player) fixB.getUserData());
                else if(fixB.getFilterData().categoryBits == PlayGame.ENEMY_COLISION_COLISION)
                    ((Enemy)fixB.getUserData()).hitonColision((Player) fixB.getUserData());

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
