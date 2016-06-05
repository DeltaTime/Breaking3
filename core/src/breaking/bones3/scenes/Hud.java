package breaking.bones3.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


import java.awt.Color;

import breaking.bones3.PlayGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by wolos on 11/05/2016.
 */
public class Hud implements Disposable {
    public Stage stage;



    private Viewport viewport;

    private static Integer score;
    private Integer vidas;
    private float timeCount;
    private float worldTimer;
    private static Label scoreLabel;
    private Label vidasLabel;
    private Label scoreLabelTexto;
    private Label vidasLabelTexto;
    private Label countDown;
    private Object textStyle;
    private BitmapFont font;

    public Hud(SpriteBatch sb){
        score = 0;
        vidas = 3;
        
        font = new BitmapFont(Gdx.files.internal("bones.fnt"));

        viewport = new FitViewport(PlayGame.V_WIDTH, PlayGame.V_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        
        
        

        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        vidasLabel = new Label(String.format("%01d", vidas), new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        scoreLabelTexto = new Label("Score", new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE));
        vidasLabelTexto = new Label("LIFE", new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE));

        table.add(scoreLabelTexto).expand().padTop(-200);
        table.add(vidasLabelTexto).expand().padTop(-200);
        table.row(); // pula uma linha
        table.add(scoreLabel).expand().padTop(-640);
        table.add(vidasLabel).expand().padTop(-640);


        stage.addActor(table);


    }

    @Override
    public void dispose() {
        stage.dispose();

    }

    public void update(float dt){
       timeCount += dt;
        if(timeCount >=1){// 1 segundo
           worldTimer --;
            //countDown.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }


    }

    public static void addScore(int value){
        score += value;
        scoreLabel.setText(String.format("%06d", score));

    }


}
