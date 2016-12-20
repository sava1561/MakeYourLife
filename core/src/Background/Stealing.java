package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

import Player.Player;

/**
 * Created by Sava on 24.03.2016.
 */
public class Stealing {
    public Timer tm, tm1;
    public Texture current;
    public static ArrayList<Texture> timer;
    public static ArrayList<Texture> car;
    public Texture currentCar;
    public float x, y, width, height, p_x, p_y, p_w, p_h;
    public int index = -1;
    public int indexPolice = -1;
    public boolean goPolice, policeStay, staying;
    public static Player p;
    public static OrthographicCamera c;
    public static TopPanel panel;
    public static Arrows arrows;
    public static Error error;
    public static PoliceDep dep;
    public boolean stop;

    public Stealing(float x, float y, Player player, OrthographicCamera camera, TopPanel panel, Arrows arrows, Error error, PoliceDep dep) {
        stop = false;
        Stealing.dep = dep;
        Stealing.error = error;
        Stealing.arrows = arrows;
        Stealing.panel = panel;
        p = player;
        c = camera;
        staying = false;
        policeStay = false;
        car = new ArrayList<Texture>();
        for (int i = 1; i < 10; i++) {
            car.add(new Texture(Gdx.files.internal("car/0000" + i + ".png")));
        }
        for (int i = 10; i < 40; i++) {
            car.add(new Texture(Gdx.files.internal("car/000" + i + ".png")));
        }
        tm = new Timer();
        width = height = Gdx.graphics.getHeight() / 6;
        this.x = x;
        this.y = y;
        p_x = 0;
        p_x = Gdx.graphics.getHeight() / 8;
        p_w = 5 * Gdx.graphics.getWidth() / 16;
        p_y = Gdx.graphics.getHeight() / 4 - Gdx.graphics.getHeight() / 26;
        currentCar = car.get(0);
        p_h = currentCar.getHeight() * (p_w / currentCar.getWidth());
        timer = new ArrayList<Texture>();
        current = new Texture(Gdx.files.internal("timer/1.png"));
        for (int i = 1; i < 15; i++) {
            timer.add(new Texture(Gdx.files.internal("timer/" + i + ".png")));
        }
        goPolice = false;
        tm1 = new Timer();
        index = -1;

    }

    public boolean drawTimer = false;

    public void draw(SpriteBatch batch) {
        if (p.stealingFF && !goPolice && !policeStay)
            p_x = p.position.x - Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 10 - Gdx.graphics.getWidth() / 2;
        if (drawTimer)
            batch.draw(current, x, y, width, height);
        if (goPolice || policeStay) {
            batch.draw(currentCar, p_x, p_y, p_w, p_h);
        }
        if (!staying) {
            if (p_x + p_w / 2 >= x && p_x + p_w / 2 <= x + Gdx.graphics.getWidth() / 150) {
                drawTimer = false;
                policeStay = true;
                goPolice = false;
                stay();
            } else if (p_x + p_w >= p.position.x - Gdx.graphics.getWidth() / 2) {
//                System.out.println("Error is here");
                p.inPoliceCar = true;
            }

        }

    }

    public void stay() {
        tm.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                policeStay = false;
                goPolice = true;
                goCar();
                if (p.stealingMarket)
                    p.inPoliceCar = true;
                if (p.stealingCafe)
                    p.inPoliceCar = true;
                if (p.stealingFF) {
                    p.inPoliceCar = true;
//                    System.out.println("Error is here1");
                }
                driveHim(dep);
            }
        }, 1.5f);
        staying = true;
    }

    public void goTimer() {
        drawTimer = true;
        if (index == -1)
            index = 0;
        System.out.println("koko");
        tm.scheduleTask(new Timer.Task() {
            @Override
            public void run() {

                if (index < timer.size()) {
                    current = timer.get(index);
                    if (!stop)
                        index++;
                    goTimer();
                } else {
                    goPolice = true;
                    goCar();
                }

            }
        }, 0.4f);
    }

    public void goCar() {
        if (goPolice) {
//            System.out.println("huy");
            if (indexPolice == -1)
                indexPolice = 0;
            tm.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    if (indexPolice < car.size()) {
                        currentCar = car.get(indexPolice);
                        if (!stop) {
                            indexPolice += 4;
                            p_x += Gdx.graphics.getWidth() / 115;
                        }
                        goCar();
                    } else {
                        indexPolice = 0;
                        goCar();
                    }
                }
            }, 0.0001f);
//            goCar();
        }
    }

    public void driveHim(final PoliceDep dep) {
        tm.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                if (p.stealingMarket || p.stealingCafe || p.stealingFF) {
                    arrows.update(dep.x + 3 * dep.width / 8 - p.position.x);
                    error.x += dep.x + 3 * dep.width / 8 - p.position.x;
                    panel.update(dep.x + 3 * dep.width / 8 - p.position.x);
                    c.position.x += dep.x + 3 * dep.width / 8 - p.position.x;
                    p.position.x += dep.x + 3 * dep.width / 8 - p.position.x;
                    p.kicked = true;
                    p.internet.x += p.position.x + p.width / 2 - (p.smoke.x + p.smoke.width / 2);
                    p.call.x += p.position.x + p.width / 2 - (p.smoke.x + p.smoke.width / 2);
                    p.smoke.x += p.position.x + p.width / 2 - (p.smoke.x + p.smoke.width / 2);
//                    p.stayUp();
                }
                staying = false;
                policeStay = false;
                p.inPoliceCar = false;
                p.stealingMarket = false;
                p.stealingFF = false;
                p.stealingCafe = false;
                p.inDep = true;
                p_x = 0 - p_w;
                goPolice = false;
                index = -1;
            }
        }, 2.5f);

    }

    public void update(float x) {
        this.x += x;
    }

    public void stop() {
        stop = true;
    }

    public void resume() {
        stop = false;
    }
}
