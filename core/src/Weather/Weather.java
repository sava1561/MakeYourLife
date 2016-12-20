package Weather;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Main;

import java.util.ArrayList;
import java.util.Random;

import Background.Time;
import Player.Player;
import javafx.scene.Camera;

/**
 * Created by Sava on 18.04.2016.
 */
public class Weather {
    public boolean rain = false;
    public boolean snowy = true;
    public ArrayList<Rain> drops;
    public ArrayList<Snow> snow;
    public ArrayList<Puddle> puddles;
    public Texture rainy,snowy1;
    public Timer timer, timer1;
    public Random random;
    public Player player;
    public float dist = 0;
    public Time time;
    public int random_int;
//    public Lightning l1, l2;

    public Weather(Player player, final Main main, Time time) {
        this.time=time;
//        l1 = new Lightning();
//        l2 = new Lightning();
        timer = new Timer();
        timer1 = new Timer();
        this.player = player;
        random = new Random();
        snow=new ArrayList<Snow>();
        drops = new ArrayList<Rain>();
        for (int i = 0; i < 1200; i++) {
            drops.add(new Rain(main));
        }
        for (int i = 0; i < 600; i++) {
            snow.add(new Snow(main));
        }
        rainy = new Texture(Gdx.files.internal("background/rainy.png"));
        snowy1 = new Texture(Gdx.files.internal("background/snowy.png"));
        updateWeather();
        puddles = new ArrayList<Puddle>();
        for (int i = 0; i < 40; i++) {
            puddles.add(new Puddle(main));
        }
    }

    public void updateWeather() {
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                if(time.months==1 || time.months==0 || time.months==11){
                    random_int=random.nextInt(1000);
                    if(random_int<=700){
                     snowy=true;
                    }else{
                        snowy=false;
                    }
                    rain=false;
                }else {
                    rain = random.nextBoolean();
                    snowy=false;
                }
                if (rain == true)
                    timer1.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            puddles.get(0).begin = true;
                        }
                    }, 2f);
                updateWeather();
            }
        }, 120f);
    }

    public void draw(SpriteBatch batch, OrthographicCamera camera,boolean pause) {
        if (rain) {
            for (int i = 0; i < drops.size(); i++)
                drops.get(i).draw(batch,pause);
            batch.draw(rainy, camera.position.x - Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
        if (snowy) {
            for (int i = 0; i < snow.size(); i++)
                snow.get(i).draw(batch,pause);
            batch.draw(snowy1, camera.position.x - Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
        update();
    }

    public void drawPuddles(SpriteBatch batch) {
        if (rain && puddles.get(0).begin) {
            for (int i = 0; i < puddles.size(); i++) {
                puddles.get(i).draw(batch);
            }
        }
    }

    public void update() {
//        drops.get(1).y=
        if (player.position.x >= Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2 + dist) {
            for (int i = 0; i < drops.size(); i++)
                drops.get(i).x += Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2;
            for (int i = 0; i < snow.size(); i++)
                snow.get(i).x += Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2;
            dist += Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2;
        } else if (player.position.x - Gdx.graphics.getWidth() / 2 <= dist) {
            for (int i = 0; i < drops.size(); i++)
                drops.get(i).x -= Gdx.graphics.getWidth();
            for (int i = 0; i < snow.size(); i++)
                snow.get(i).x -= Gdx.graphics.getWidth();
            dist -= Gdx.graphics.getWidth();
        }
    }

}
