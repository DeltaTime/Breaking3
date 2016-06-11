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
import com.badlogic.gdx.math.Vector3;


/**
 *
 * @author Matheus
 */
public class Dificuldade implements Screen {
    
    private PlayGame game;
    private OrthographicCamera camera;
    private Vector3 click_posicao;
    
    private Texture texture_facil;
    private Texture texture_normal;
    private Texture texture_dificil;
    private Texture texture_voltar;
    private Texture texture_background;
    private Sprite sprite_facil;
    private Sprite sprite_normal;
    private Sprite sprite_dificil;
    private Sprite sprite_voltar;
    private Sprite sprite_background;

    
    public Dificuldade(PlayGame game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        click_posicao = new Vector3();


}



    
    
    @Override
    public void show() {
        texture_voltar = new Texture("voltar.png");
        sprite_voltar = new Sprite(texture_voltar);
        sprite_voltar.setOrigin(sprite_voltar.getWidth()/2, sprite_voltar.getHeight()/2);
        sprite_voltar.setPosition(((Gdx.graphics.getWidth()/2) - (texture_voltar.getWidth()/2)), 160);
        
        texture_dificil = new Texture("dificil.png");
        sprite_dificil = new Sprite(texture_dificil);
        sprite_dificil.setOrigin(sprite_dificil.getWidth()/2, sprite_dificil.getHeight()/2);
        sprite_dificil.setPosition(((Gdx.graphics.getWidth()/2) - (texture_dificil.getWidth()/2)), 220);
        
        texture_normal = new Texture("normal.png");
        sprite_normal = new Sprite(texture_normal);
        sprite_normal.setOrigin(sprite_normal.getWidth()/2, sprite_normal.getHeight()/2);
        sprite_normal.setPosition(((Gdx.graphics.getWidth()/2) - (texture_normal.getWidth()/2)), 280);
        
        texture_facil = new Texture("facil.png");
        sprite_facil = new Sprite(texture_facil);
        sprite_facil.setOrigin(sprite_facil.getWidth()/2, sprite_facil.getHeight()/2);
        sprite_facil.setPosition(((Gdx.graphics.getWidth()/2) - (texture_facil.getWidth()/2)), 340);
        
        
        texture_background = new Texture("bonesbackground.png");
        sprite_background = new Sprite(texture_background);
        sprite_background.setOrigin(sprite_background.getWidth()/2, sprite_background.getHeight()/2);
        sprite_background.setPosition(((Gdx.graphics.getWidth()/2) - (texture_background.getWidth()/2)), 0);
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        //game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        sprite_voltar.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_dificil.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_normal.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_facil.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_background.draw(game.batch);
        game.batch.end();
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_facil.getX() && click_posicao.x < (sprite_facil.getX() + sprite_facil.getWidth())){
                if(click_posicao.y > sprite_facil.getY() && click_posicao.y < (sprite_facil.getY() + sprite_facil.getHeight())){
                    game.setScreen(new PlayScreenCasa(game,5.65f,5.57f, 0, 3));
                    dispose();
                }
            }
        }
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_normal.getX() && click_posicao.x < (sprite_normal.getX() + sprite_normal.getWidth())){
                if(click_posicao.y > sprite_normal.getY() && click_posicao.y < (sprite_normal.getY() + sprite_normal.getHeight())){
                    game.setScreen(new PlayScreenCasa(game,5.65f,5.57f, 0, 3));
                    dispose();
                }
            }
        }
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_dificil.getX() && click_posicao.x < (sprite_dificil.getX() + sprite_dificil.getWidth())){
                if(click_posicao.y > sprite_dificil.getY() && click_posicao.y < (sprite_dificil.getY() + sprite_dificil.getHeight())){
                    game.setScreen(new PlayScreenCasa(game,5.65f,5.57f, 0, 3));
                    dispose();
                }
            }
        }
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_voltar.getX() && click_posicao.x < (sprite_voltar.getX() + sprite_voltar.getWidth())){
                if(click_posicao.y > sprite_voltar.getY() && click_posicao.y < (sprite_voltar.getY() + sprite_voltar.getHeight())){
                    game.setScreen(new Menu(game));
                    dispose();
                }
            }
        }
        
    }

    @Override
    public void resize(int width, int height) {
        
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
