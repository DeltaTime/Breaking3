/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breaking.bones3.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import breaking.bones3.PlayGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Matheus
 */
public class Ajuda implements Screen{
    
    private PlayGame game;
    private OrthographicCamera camera;
    private Vector3 click_posicao;
    
    private Texture texture_comandos;
    private Texture texture_voltar;
    private Texture texture_background;
    private Sprite sprite_comandos;
    private Sprite sprite_voltar;
    private Sprite sprite_background;
    
    public Ajuda(PlayGame game){
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
        sprite_voltar.setPosition(((Gdx.graphics.getWidth()/2) - (texture_voltar.getWidth()/2)), 130);
        
        texture_comandos = new Texture("comandos.png");
        sprite_comandos = new Sprite(texture_comandos);
        sprite_comandos.setOrigin(sprite_comandos.getWidth()/2, sprite_comandos.getHeight()/2);
        sprite_comandos.setPosition(((Gdx.graphics.getWidth()/2) - (texture_comandos.getWidth()/2)), 150);
        
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
        
        game.batch.begin();
        sprite_voltar.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_comandos.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_background.draw(game.batch);
        game.batch.end();
        
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
