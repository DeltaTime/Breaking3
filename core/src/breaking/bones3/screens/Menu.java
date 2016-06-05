/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breaking.bones3.screens;

import breaking.bones3.PlayGame;
import com.badlogic.gdx.Application;
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
public class Menu implements Screen {
    
    private PlayGame game;
    private OrthographicCamera camera;
    private Vector3 click_posicao;
    
    private Texture texture_novojogo;
    private Texture texture_dificuldade;
    private Texture texture_ajuda;
    private Texture texture_sair;
    private Sprite sprite_novojogo;
    private Sprite sprite_dificuldade;
    private Sprite sprite_ajuda;
    private Sprite sprite_sair;
    
    public Menu(PlayGame game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        click_posicao = new Vector3();
        
        
    }
    
    
    @Override
    public void show() {
        texture_sair = new Texture("sair.png");
        sprite_sair = new Sprite(texture_sair);
        sprite_sair.setOrigin(sprite_sair.getWidth()/2, sprite_sair.getHeight()/2);
        sprite_sair.setPosition(((Gdx.graphics.getWidth()/2) - (texture_sair.getWidth()/2)), 60);
        
        texture_ajuda = new Texture("ajuda.png");
        sprite_ajuda = new Sprite(texture_ajuda);
        sprite_ajuda.setOrigin(sprite_ajuda.getWidth()/2, sprite_ajuda.getHeight()/2);
        sprite_ajuda.setPosition(((Gdx.graphics.getWidth()/2) - (texture_ajuda.getWidth()/2)), 160);
        
        texture_dificuldade = new Texture("dificuldade.png");
        sprite_dificuldade = new Sprite(texture_dificuldade);
        sprite_dificuldade.setOrigin(sprite_dificuldade.getWidth()/2, sprite_dificuldade.getHeight()/2);
        sprite_dificuldade.setPosition(((Gdx.graphics.getWidth()/2) - (texture_dificuldade.getWidth()/2)), 260);
        
        texture_novojogo = new Texture("novojogo.png");
        sprite_novojogo = new Sprite(texture_novojogo);
        sprite_novojogo.setOrigin(sprite_novojogo.getWidth()/2, sprite_novojogo.getHeight()/2);
        sprite_novojogo.setPosition(((Gdx.graphics.getWidth()/2) - (texture_novojogo.getWidth()/2)), 360);
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        //game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        sprite_sair.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_ajuda.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_dificuldade.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_novojogo.draw(game.batch);
        game.batch.end();
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_novojogo.getX() && click_posicao.x < (sprite_novojogo.getX() + sprite_novojogo.getWidth())){
                if(click_posicao.y > sprite_novojogo.getY() && click_posicao.y < (sprite_novojogo.getY() + sprite_novojogo.getHeight())){
                    game.setScreen(new PlayScreenBoss(game));
                    dispose();
                }
            }
        }
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_dificuldade.getX() && click_posicao.x < (sprite_dificuldade.getX() + sprite_dificuldade.getWidth())){
                if(click_posicao.y > sprite_dificuldade.getY() && click_posicao.y < (sprite_dificuldade.getY() + sprite_dificuldade.getHeight())){
                    game.setScreen(new Dificuldade(game));
                    dispose();
                }
            }
        }
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_ajuda.getX() && click_posicao.x < (sprite_ajuda.getX() + sprite_ajuda.getWidth())){
                if(click_posicao.y > sprite_ajuda.getY() && click_posicao.y < (sprite_ajuda.getY() + sprite_ajuda.getHeight())){
                    game.setScreen(new Ajuda(game));
                    dispose();
                }
            }
        }
        
        if(Gdx.input.isTouched()){
            click_posicao.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click_posicao);
            if(click_posicao.x > sprite_sair.getX() && click_posicao.x < (sprite_sair.getX() + sprite_sair.getWidth())){
                if(click_posicao.y > sprite_sair.getY() && click_posicao.y < (sprite_sair.getY() + sprite_sair.getHeight())){
                    Gdx.app.exit();
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
