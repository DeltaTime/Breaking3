/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breaking.bones3.screens;

import breaking.bones3.PlayGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;


/**
 *
 * @author Matheus
 */
public class TelaAbertura implements Screen{
    private PlayGame game;
    private OrthographicCamera camera;
    
    
    private Sprite imglogo;
    private Sprite imgtitulo;
    private Sprite imgdeltatime;
    private Texture textureimglogo;
    private Texture textureimgtitulo;
    private Texture textureimgdeltatime;
    
    
    private long starttime = TimeUtils.millis();
    
    public TelaAbertura(PlayGame game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        
        
    }
    
    @Override
    public void show() {
        
        textureimglogo = new Texture("boneslogo.png");
        textureimgtitulo = new Texture("bonestitulo.png");
        textureimgdeltatime = new Texture("deltatimelogo.png");
        
        imglogo = new Sprite(textureimglogo);
        imglogo.setOrigin(imglogo.getWidth()/2, imglogo.getHeight()/2);
        imglogo.setPosition(((Gdx.graphics.getWidth()/2) - (imglogo.getWidth()/2)), ((Gdx.graphics.getHeight()/2) - (imglogo.getHeight()/2))+50);
        
        imgtitulo = new Sprite(textureimgtitulo);
        imgtitulo.setOrigin(imgtitulo.getWidth()/2, imgtitulo.getHeight()/2);
        imgtitulo.setPosition(((Gdx.graphics.getWidth()/2) - (imgtitulo.getWidth()/2)), ((Gdx.graphics.getHeight()/2) - ((imgtitulo.getHeight()/2) + 30 + (imglogo.getHeight()/2))));
        
        imgdeltatime = new Sprite(textureimgdeltatime);
        imgdeltatime.setOrigin(imgdeltatime.getWidth()/2, imgdeltatime.getHeight()/2);
        imgdeltatime.setPosition(((Gdx.graphics.getWidth()) - (imgdeltatime.getWidth())), ((Gdx.graphics.getHeight()) - (imgdeltatime.getHeight())));
        }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        
        game.batch.begin();
        imglogo.draw(game.batch);
        game.batch.end();
        game.batch.begin();
        imgtitulo.draw(game.batch);
        game.batch.end();
        game.batch.begin();
        imgdeltatime.draw(game.batch);
        game.batch.end();




        if(Gdx.input.isTouched()){
            game.setScreen(new Menu(game));
            dispose();
        }
    }    
    @Override
    public void resize(int width, int heigth) {
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
        
        }

    

    

    

    
    
}
