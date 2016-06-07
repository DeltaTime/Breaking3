package breaking.bones3.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Input;

import breaking.bones3.PlayGame;
import breaking.bones3.scenes.Hud;
//import breaking.bones3.sprites.Bloco;
import breaking.bones3.sprites.Enemy1;
import breaking.bones3.sprites.Player;
import breaking.bones3.tools.B2WorldCreator;
import breaking.bones3.tools.WorldContactListener;

/**
 * Created by wolos on 11/05/2016.
 */
public class PlayScreenBoss implements Screen {
    //Sprites
    private Player player;
    private Enemy1 enemy1;
    //private Bloco bloco;



    private PlayGame game;

    private TextureAtlas atlas;

    //playScreen Variaveis
    private OrthographicCamera gameCam;
    private Viewport gameport;
    private Hud hud;

    // TileMap Variaveis
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    // Box2D variaveis
    private World world;
    private Box2DDebugRenderer b2dr;

    //sounds
    private Music music;

    public PlayScreenBoss(PlayGame game){
        this.game = game;

        atlas = new TextureAtlas("PlayGamePackege.pack");

        //Camera seguir o jogador
        gameCam = new OrthographicCamera();
        gameport = new FitViewport(PlayGame.V_WIDTH/PlayGame.PPM,PlayGame.V_HEIGHT/PlayGame.PPM,gameCam);

        //Criando a hud
        hud = new Hud(game.batch);

        //carregar o map e configurar
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("cavernaboss.tmx");
        renderer = new OrthogonalTiledMapRenderer(map,1/PlayGame.PPM);

        //centralizar a camera
        gameCam.position.set(gameport.getScreenWidth()/2, gameport.getScreenHeight()/2,0);

        //criando o box
        world = new World(new Vector2(0,0),true); // para colocar gravidade setar o segundo parametro -10
        b2dr = new Box2DDebugRenderer();

        //criar o mundo com objetos
        new B2WorldCreator(world, map);


        player = new Player(world, atlas);
        player.b2body.setTransform(7.69f, 11.15f, 0);



        world.setContactListener(new WorldContactListener());

        //Play MUSIC
       // music = PlayGame.maneger.get("audio/music/mario_music.ogg", Music.class);
        //music.setLooping(true);
       //music.play();

        //enemy1 = new Enemy1(world, atlas, 5.0f, 5.0f);
        
        //OBJETOS
        //bloco = new Bloco(this,1.0f,1.5f);


    }

    public TextureAtlas getAtlas(){
        return atlas;


    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
        //deixa ele parado qdo nao estiver imput
        player.b2body.setLinearVelocity(0,0);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&& player.b2body.getLinearVelocity().x >= -0.8) {
            //gameCam.position.x -= 2 * dt;
            player.b2body.applyLinearImpulse(new Vector2(-0.3f, 0), player.b2body.getWorldCenter(), true);


        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&& player.b2body.getLinearVelocity().x <= 0.8) {
            //gameCam.position.x += 2 * dt;
            player.b2body.applyLinearImpulse(new Vector2(0.3f, 0), player.b2body.getWorldCenter(), true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && player.b2body.getLinearVelocity().y <= 0.8) {
            //gameCam.position.y += 2 * dt;

            player.b2body.applyLinearImpulse(new Vector2(0, 0.3f), player.b2body.getWorldCenter(), true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&& player.b2body.getLinearVelocity().y >= -0.8) {
            //gameCam.position.y -= 2 * dt;
            //if(Gdx.input.isTouched())
            player.b2body.applyLinearImpulse(new Vector2(0, -0.3f), player.b2body.getWorldCenter(), true);
        }
        if(player.b2body.getLinearVelocity().x != 0 | player.b2body.getLinearVelocity().y != 0){

            System.out.print("PlayerX:" + player.getX() + " PlayerY: " + player.getY());
            System.out.println("\n");

        }


    }


    public void update(float dt){
        handleInput(dt);
        world.step(1/60f,6,2);
        player.update(dt);
        //enemy1.update(dt);
        hud.update(dt);
        //bloco.update(dt);

        // fixar a camera com o player
        gameCam.position.x = player.b2body.getPosition().x;
        gameCam.position.y = player.b2body.getPosition().y;

        //atualizar a camera com a correta posicao
        gameCam.update();

        //renderizar tudo
        renderer.setView(gameCam);



    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Render gamemap
        renderer.render();

        //render Box2DDebugLines camera principal
        b2dr.render(world,gameCam.combined);
        //desenha a HUD
        hud.stage.draw();
        //o q a camera da hud ver.
        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.begin();
        player.draw(game.batch);
        //enemy1.draw(game.batch);
        //bloco.draw(game.batch);

        game.batch.end();

        if ((7.60f <= player.getX() && player.getX() <= 7.77f) && (11.34f <= player.getY() && player.getY()<= 11.39f)){
            game.setScreen(new PlayScreenCaverna(game));
            dispose();
        }
        
        




    }

    public TiledMap getMap(){
        return map;
    }

    public  World getWorld(){
        return world;
    }


    @Override
    public void resize(int width, int height) {
        gameport.update(width,height);
        //gameCam.update();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();

    }
}

