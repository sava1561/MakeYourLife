package Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.GameScreen;

import java.util.ArrayList;

import Weather.Puddle;
import Weather.Rain;
import Weather.Snow;

/**
 * Created by Roman on 13.07.2016.
 */
public class Menu {
    public boolean on_play = false;
    public Vector2 touchPos;
    public Texture background;
    public Texture play, play_touched,cont;
    public Texture sound;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    public float p_x, p_y, p_width, p_height,c_x,c_y;
    public float s_x, s_y, s_width, s_height;
    public float b_height;
    public GameScreen screen;
    public ArrayList<Rain> drops;
    public ArrayList<Puddle> puddles;
    public ArrayList<Snow> snowflakes;
    public int type;
    public boolean close=false;

    public Menu(GameScreen screen, int type) { //1-rain 2-snow 0-sun
        this.type =type;
        this.screen = screen;
        touchPos = new Vector2();
        if (type == 1) {
            background = new Texture(Gdx.files.internal("menu/1_rain.png"));
        } else if (type == 2) {
            background = new Texture(Gdx.files.internal("menu/snowwy.png"));
        } else {
            background = new Texture(Gdx.files.internal("menu/1.png"));
        }
        play_touched = new Texture(Gdx.files.internal("menu/2_2.png"));
        play = new Texture(Gdx.files.internal("menu/2.png"));
        cont=new Texture(Gdx.files.internal("menu/continue.png"));
        sound = new Texture(Gdx.files.internal("menu/3.png"));
        if (type == 1) {
            puddles = new ArrayList<Puddle>(6);
            for (int i = 0; i < 6; i++) {
                puddles.add(new Puddle(screen.main, 1));
            }
            drops = new ArrayList<Rain>(600);
            for (int i = 0; i < 600; i++) {
                drops.add(new Rain(screen.main));
            }
        } else if (type == 2) {
            snowflakes = new ArrayList<Snow>(500);
            for (int i = 0; i < 500; i++) {
                snowflakes.add(new Snow(screen.main));
            }
        }
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.setProjectionMatrix(camera.combined);
        p_width = Gdx.graphics.getWidth() / 4;
        p_height = play.getHeight() * (p_width / play.getWidth());
        p_x = Gdx.graphics.getWidth() / 4 - p_width / 2;
        c_x = 3*Gdx.graphics.getWidth()/4 - p_width / 2;
        p_y = Gdx.graphics.getHeight() / 2 - p_height / 2;
        s_width = p_width / 3;
        s_height = sound.getHeight() * (s_width / sound.getWidth());
        s_x = Gdx.graphics.getWidth() - 3 * s_width / 2;
        s_y = Gdx.graphics.getHeight() - 3 * s_height / 2;
        b_height = background.getHeight() * (Gdx.graphics.getWidth() / background.getWidth());
    }

    public void draw() {
        if(!close) {
            batch.begin();
            batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            if (type == 1) {
                for (int i = 0; i < puddles.size(); i++) {
                    puddles.get(i).draw(batch);
                }
                for (int i = 0; i < drops.size(); i++) {
                    drops.get(i).draw(batch);
                }
            } else if (type == 2) {
                for (int i = 0; i < snowflakes.size(); i++) {
                    snowflakes.get(i).draw(batch);
                }
            }
            if (!on_play) {
                batch.draw(play, p_x, p_y, p_width, p_height);
                batch.draw(cont, c_x, p_y, p_width, p_height);
            }
            else {
                batch.draw(play_touched, p_x, p_y, p_width, p_height);
                batch.draw(cont, c_x, p_y, p_width, p_height);
            }
            batch.draw(sound, s_x, s_y, s_width, s_height);
            batch.end();
            ontouchPlay();
        }
    }

    public void ontouchPlay() {
        if (Gdx.input.justTouched()) {
            touchPos.x = Gdx.input.getX();
            System.out.println(Gdx.input.getX());
            touchPos.y = Gdx.input.getY();
            if (touchPos.x >= p_x && touchPos.x <= p_x + p_width && touchPos.y >= Gdx.graphics.getHeight() - p_y - p_height && touchPos.y <= Gdx.graphics.getHeight() - p_y) {
                on_play=true;
                new Timer().scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        screen.background = true;
                        close=true;
                    }
                }, 1.3f);
                screen.bck.toppanel.toMax();
                screen.bck.toppanel.time.minute = 0;
                screen.bck.toppanel.time.hour = 12;
            }
        }
    }
}
