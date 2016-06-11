package breaking.bones3.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import breaking.bones3.PlayGame;
import breaking.bones3.screens.PlayScreenCasa;
import breaking.bones3.screens.PlayScreenVila;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by wolos on 12/05/2016.
 */
public class Enemy1 extends Sprite {
    public enum State{WALKING, STANDING}
    public State currentState;
    public State previousState;
    public World world;
    public Body b2body;
    public TextureAtlas atlas;
    private TextureRegion playerStands;
    private Animation playWalkink;
    private Animation playStand;
    private float stateTimer;
    private boolean walkingRight;
    private int pontos;
    private float x;
    private float y;



    public Enemy1(World world, TextureAtlas atlas){
        super(atlas.findRegion("InimigoDireita"));
        this.world = world;
        this.x = 0;
        this.y = 0;

        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        walkingRight = true;
        super.setPosition(600.0f,7.0f);


        Array<TextureRegion> frames = new Array<TextureRegion>();
        //andar aimation
        for(int i = 0; i < 3; i++){
            //frames.add(new TextureRegion(getTexture(),i * 32,0,31,31));//busca os frames de 31 pixel na imagem
            frames.add(new TextureRegion(atlas.findRegion("InimigoDireita"), i * 21, 0, 24, 24));
        }

        playWalkink = new Animation(0.1f,frames);
        frames.clear();



        definePlayer();
        playerStands = new TextureRegion(getTexture(),atlas.findRegion("InimigoDireita").getRegionX(),atlas.findRegion("InimigoDireita").getRegionY(),atlas.findRegion("InimigoDireita").getRegionHeight(),31);//31 largura do frame
        setBounds(0,0,16/PlayGame.PPM, 16/PlayGame.PPM);
        setRegion(playerStands);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth()/2,b2body.getPosition().y - getHeight()/2);
        //deslocamento do inimigo

        b2body.applyLinearImpulse(new Vector2(x, y), b2body.getWorldCenter(), true);
        setRegion(getFrame(dt));


    }

    public TextureRegion getFrame(float dt){
        currentState = getState();
        TextureRegion region = playerStands;
        switch (currentState){
            case WALKING:
                region = playWalkink.getKeyFrame(stateTimer, true);
                break;
            case STANDING:
                region = playerStands;
                break;



        }
        if((b2body.getLinearVelocity().x < 0 || !walkingRight) && !region.isFlipX()){
            region.flip(true,false);
            walkingRight = false;

        }
        else if((b2body.getLinearVelocity().x > 0 || walkingRight) && region.isFlipX()){
            region.flip(true,false);
            walkingRight = true;
        }
        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;
        return region;

    }

    public State getState(){
        if(b2body.getLinearVelocity().x != 0 || b2body.getLinearVelocity().x != 0) {
            return State.WALKING;
        }

        else{
            return State.STANDING;

        }

    }



    public void definePlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(16/PlayGame.PPM,16/PlayGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(9/ PlayGame.PPM);
        fdef.filter.categoryBits = PlayGame.ENEMY_BIT;
        // player pode colidir
        fdef.filter.maskBits = PlayGame.GROUND_BIT | PlayGame.DOOR_BIT | PlayGame.PECAS_BIT | PlayGame.PEDRA_BIT | PlayGame.OSSO_BIT | PlayGame.CORACAO_BIT | PlayGame.ENEMY_BIT | PlayGame.OBJECT_BIT | PlayGame.PLAYER_BIT | PlayGame.ENEMY_COLISION_COLISION;

        fdef.shape = shape;
        b2body.createFixture(fdef);




    }


}
