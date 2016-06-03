package breaking.bones3.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;

import breaking.bones3.PlayGame;
import breaking.bones3.scenes.Hud;
import breaking.bones3.screens.PlayScreen;

/**
 * Created by wolos on 18/05/2016.
 */
public class Enemy1 extends Enemy {
    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;
    private int vida = 100;


    @Override
    public void hitonColision(Player userData) {
     setToDestroy = true;
    }

    @Override
    protected void defineEnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(),getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(9 / PlayGame.PPM);
        fdef.filter.categoryBits = PlayGame.ENEMY_BIT;
        // player pode colidir
        fdef.filter.maskBits = PlayGame.GROUND_BIT | PlayGame.DOOR_BIT | PlayGame.PECAS_BIT | PlayGame.PEDRA_BIT | PlayGame.OSSO_BIT | PlayGame.CORACAO_BIT | PlayGame.ENEMY_BIT | PlayGame.OBJECT_BIT | PlayGame.PLAYER_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);

        //create the colision
        PolygonShape colisao = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-10,10).scl(1/PlayGame.PPM);
        vertice[1] = new Vector2(10,10).scl(1/PlayGame.PPM);
        vertice[2] = new Vector2(-10,-10).scl(1/PlayGame.PPM);
        vertice[3] = new Vector2(10,-10).scl(1/PlayGame.PPM);
        colisao.set(vertice);

        fdef.shape = colisao;
        fdef.restitution = 0.5f;
        fdef.filter.categoryBits = PlayGame.ENEMY_BIT;
        b2body.createFixture(fdef).setUserData(this);

    }

    public Enemy1(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        for (int i = 0; i < 4; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("InimigoDireita"), i * 21, 0, 24, 24));
        walkAnimation = new Animation(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 16 / PlayGame.PPM, 16 / PlayGame.PPM);
        setToDestroy = false;
        destroyed = false;


    }

    @Override
    public void onEspadaHit() {
        Gdx.app.log("Colisao", "Inimigo1");
        Hud.addScore(500);
        PlayGame.maneger.get("audio/sfx/breakblock.wav", Sound.class).play();
    }

    public void update(float dt) {
        stateTime += dt;
        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
            setRegion(new TextureRegion(screen.getAtlas().findRegion("InimigoDireita"), 1 * 21, 0, 24, 24));

        }
        else if(!destroyed) {
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion(walkAnimation.getKeyFrame(stateTime, true));

        }


    }


}
