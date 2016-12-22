package Player;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.assets.AssetManager;
//import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Main;

//import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.TimerTask;
//import java.util.Vector;

import Background.Bench;
import Background.FastFood;

/**
 * Created by Sava on 01.03.2016.
 */
public class Player {
    public boolean heal1, heal2, heal3;
    public boolean inBus = false;
    public int busNumber = 0;
    public int bus_index = 0;
    public int payment = 2;
    public int age = 18;
    public Stamina stamina;
    public boolean inDep;
    public boolean inPoliceCar;
    public boolean stealingMarket, stealingCafe, stealingFF;
    public int stealSkill;
    public boolean atschool;
    public boolean relaxing;
    public float basic_y;
    public Timer tm1, tm2, tm3;
    public boolean atFastFood;
    public boolean walking_r, walking_l;
    public float basicHeight;
    public boolean sitting1, isSitting;
    public int foodBought;
    public boolean drinkingcoffee, droppingcoffee;
    public boolean withFood;
    public boolean issleeping;
    public int count, count_dr;
    public boolean issmoking, dropping;
    public boolean athome, atmarket, atcafe;
    public boolean varExist;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Variants sleep;
    public Variants eat;
    public Variants relax;
    public Variants goOut;
    public Variants Buy, Buy2, Buy3, GoOut, Buy1, GoOut1, Eat1, Eat2, Eat3, GoOut2, back;
    int index;
    int index2;
    public int index_dr;
    public int sm_index;
    int index_sit;
    public float sm_time, drinkTime;
    public boolean movingRight = false;
    public boolean movingLeft = false;
    public Texture stay, stayWithFood;
    public ArrayList<Texture> anim;
    public ArrayList<Texture> anim2;
    public ArrayList<Texture> runRight;
    public ArrayList<Texture> runLeft;
    public ArrayList<Texture> smoking;
    public ArrayList<Texture> withFood1, withFood2;
    public ArrayList<Texture> drinking;
    public ArrayList<Texture> sitting2;
    public Texture texture;
    public float width;
    public float height;
    public Vector2 position;
    public float speed;
    public float speed1;
    public Vector2 touchPos;
    public Timer.Task t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    public Main main;
    public boolean kicked = false;
    public boolean minusMoneyDone = false;
    public boolean runningR = false;
    public boolean runningL = false;
    public boolean inHospital = false;

    public Player(final Main main) {
        heal1 = heal2 = heal3 = false;
        position = new Vector2();
        inDep = false;
        inPoliceCar = false;
        stealingMarket = stealingCafe = stealingFF = false;
        stealSkill = 0;
        atschool = false;
        relaxing = false;
        this.main = main;
        tm1 = new Timer();
        tm2 = new Timer();
        createTask();
        walking_l = walking_r = false;
        droppingcoffee = false;
        count_dr = 0;
        index_dr = 0;
        index_sit = 0;
        foodBought = 0;
        atFastFood = false;
        sitting1 = false;
        isSitting = false;
        drinkingcoffee = false;
        withFood = false;
        dropping = false;
        count = 0;
        issleeping = false;
        issmoking = false;
        athome = false;
        atcafe = false;
        atmarket = false;
        varExist = false;
        touchPos = new Vector2();
        index = 0;
        index2 = 0;
        sm_index = 0;
        sm_time = 0.05f;
        drinkTime = 0.12f;
        anim = new ArrayList<Texture>();
        smoking = new ArrayList<Texture>();


//        anim.add(new Texture(Gdx.files.internal("animation/frame-0010801.png")));
        anim2 = new ArrayList<Texture>();
        create1();
        speed = 0;
        speed1 = 0;
        texture = new Texture(Gdx.files.internal("background/player.png"));
        stay = new Texture(Gdx.files.internal("animation/stay.png"));
        width = Gdx.graphics.getWidth() / 23;
        height = 8 * (texture.getHeight() * (width / texture.getWidth())) / 11;//3/11
        basicHeight = height;
        position = new Vector2();
        position.x = Gdx.graphics.getWidth() / 2 - width / 2;
        position.y = Gdx.graphics.getHeight() / 4 - Gdx.graphics.getHeight() / 24;
        texture = stay;
        smoke1();
        drink();
        sit();
        smoke = new Variants(position.x + width / 2 - 8 * height / 8, 5 * position.y / 4 + height, 8 * height / 4, "circles/smoke.png");//position.x - 9 * height / 4, position.y + 2 * width / 3, 8 * height / 4,
        call = new Variants(position.x - 9 * height / 4, position.y + 2 * width / 3, 8 * height / 4, "circles/call.png");
        internet = new Variants(position.x + width + height / 4, position.y + 2 * width / 3, 8 * height / 4, "circles/internet.png");// position.x - 9 * height / 4, position.y + 2 * width / 3, 8 * height / 4
        sleep = new Variants(position.x + width / 2 + 15 * Gdx.graphics.getWidth() / 58, Gdx.graphics.getHeight() / 4 + width / 2, 2 * height, "circles/sleep.png");
        relax = new Variants(position.x + width / 2 + 15 * Gdx.graphics.getWidth() / 58, sleep.y + 2 * width, 2 * height, "circles/relax.png");
        eat = new Variants(position.x + width / 2 + 15 * Gdx.graphics.getWidth() / 58, relax.y + 2 * width, 2 * height, "circles/eat.png");
        goOut = new Variants(position.x + width / 2 + 15 * Gdx.graphics.getWidth() / 58, eat.y + 2 * width, 2 * height, "circles/goout.png");
        GoOut = new Variants(Gdx.graphics.getWidth() + 15 * Gdx.graphics.getWidth() / 35, 0, 2 * height, "circles/goout.png");
        Buy = new Variants(GoOut.x, Gdx.graphics.getHeight() / 4 + 2 * height / 2 + 2 * height / 3, GoOut.width, "circles/buy1.png");//Gdx.graphics.getWidth() + width;
        GoOut.y = Buy.y + Buy.height + height / 3;
        Buy2 = new Variants(GoOut.x, Gdx.graphics.getHeight() / 4 + height / 2 + height / 3, GoOut.width, "circles/buy2.png");//Gdx.graphics.getWidth() + width;
        Buy3 = new Variants(GoOut.x, Gdx.graphics.getHeight() / 4, GoOut.width, "circles/buy3.png");//Gdx.graphics.getWidth() + width;
        GoOut1 = new Variants(Gdx.graphics.getWidth() + 8 * Gdx.graphics.getWidth() / 35 + Gdx.graphics.getWidth() / 12 + 3 * Gdx.graphics.getWidth() / 8 + 8 * Gdx.graphics.getWidth() / 35, Gdx.graphics.getHeight() / 4 + 7 * height / 6, 2 * height, "circles/goout.png");
        Buy1 = new Variants(GoOut1.x, Gdx.graphics.getHeight() / 4 + height / 2, GoOut1.width, "circles/coffee.png");
        back = new Variants(position.x + width / 2 - GoOut1.width / 2, position.y + 2 * height + 7 * height / 8, GoOut1.width, "background/back.png");
        basic_y = position.y;
        tm3 = new Timer();
        stamina = new Stamina(this);
        runRight = new ArrayList<Texture>();
        for (int i = 5; i < 10; i++) {
            runRight.add(new Texture(Gdx.files.internal("run/0000" + i + ".png")));
        }
        for (int i = 10; i < 22; i++) {
            runRight.add(new Texture(Gdx.files.internal("run/000" + i + ".png")));
        }
        runLeft = new ArrayList<Texture>();
        for (int i = 5; i < 10; i++) {
            runLeft.add(new Texture(Gdx.files.internal("run_left/0000" + i + ".png")));
        }
        for (int i = 10; i < 22; i++) {
            runLeft.add(new Texture(Gdx.files.internal("run_left/000" + i + ".png")));
        }
        runR();
        runL();
    }

    public void setFastFood(FastFood fastFood) {
        GoOut2 = new Variants(fastFood.x + 5 * fastFood.width / 4, GoOut.y, GoOut.width, "circles/goout.png");
        Eat1 = new Variants(GoOut2.x, Buy.y, GoOut2.width, "circles/eat1.png");
        Eat2 = new Variants(GoOut2.x, Buy2.y, GoOut2.width, "circles/eat2.png");
        Eat3 = new Variants(GoOut2.x, Buy3.y, GoOut2.width, "circles/eat3.png");
    }

    public void ontouch() {
        if (Gdx.input.justTouched()) {
            touchPos.x = Gdx.input.getX() + position.x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchPos.y = Gdx.input.getY();
            if (touchPos.x > position.x && touchPos.x < position.x + width && touchPos.y > Gdx.graphics.getHeight() - position.y - height && touchPos.y < Gdx.graphics.getHeight() - position.y && !athome) {
                if (!withFood)
                    texture = stay;
                else {
                    texture = stayWithFood;
                }
                width = Gdx.graphics.getWidth() / 23;
                varExist = varExist != true;
            }
        }
    }

    public void draw(SpriteBatch batch) {
//        batch.begin();
        if (inPoliceCar) {
            stealingMarket = false;
            stealingCafe = false;
            stealingFF = false;
        }
        batch.draw(texture, position.x, position.y, width, height);
        stamina.draw(batch);
        if (varExist) {
            smoke.draw(batch);
            call.draw(batch);
            internet.draw(batch);
        }
//        batch.end();
    }

    public void drawMarket(SpriteBatch batch) {
        if (atmarket) {
            Buy.draw(batch);
            Buy2.draw(batch);
            Buy3.draw(batch);
            GoOut.draw(batch);
        }
    }

    public void drawFastFood(SpriteBatch batch) {
        if (atFastFood) {
            GoOut2.draw(batch);
            Eat1.draw(batch);
            Eat2.draw(batch);
            Eat3.draw(batch);
        }
    }

    public void drawHome(SpriteBatch batch) {
        if (athome && !issleeping) {
            goOut.y = eat.y + 2 * width;
            sleep.draw(batch);
            eat.draw(batch);
            relax.draw(batch);
            goOut.draw(batch);
        } else if (athome && issleeping) {
            goOut.y = relax.y;
            goOut.draw(batch);
        }
    }

    public void drawCafe(SpriteBatch batch) {
        if (atcafe) {
            Buy1.draw(batch);
            GoOut1.draw(batch);
        }
    }

    public void runLeft() {
        speed = 0;
        position.x -= speed1;
        smoke.x -= speed1;
        call.x -= speed1;
        back.x -= speed;
        internet.x -= speed1;
        movingRight = false;
        runningR = false;
        movingLeft = false;
        runningL = true;
    }

    public void runRight() {
        speed1 = 0;
        position.x += speed;
        smoke.x += speed;
        call.x += speed;
        internet.x += speed;
        back.x += speed;
        movingRight = false;
        runningR = true;
        movingLeft = false;
        runningL = false;
    }

    public void moveRight() {
        speed1 = 0;
        position.x += speed;
        smoke.x += speed;
        call.x += speed;
        back.x += speed;
        internet.x += speed;
        movingRight = true;
        movingLeft = false;
        runningR = false;
    }

    public void moveLeft() {
        speed = 0;
        position.x -= speed1;
        smoke.x -= speed1;
        call.x -= speed1;
        back.x -= speed;
        internet.x -= speed1;
        movingLeft = true;
        movingRight = false;
        runningR = false;
    }

    public void sit() {
        if (sitting1) {
            tm1.scheduleTask(t11, 0.05f);
        }
    }

    public void drink() {
        if (drinkingcoffee && !droppingcoffee) {
            width = texture.getWidth() * (height / texture.getHeight());
            tm1.scheduleTask(t10, drinkTime);
        } else {
            tm1.scheduleTask(t9, 0.05f);
        }
    }

    public void drink1() {
        tm2.scheduleTask(t8, 0.1f);
    }

    public void smoke1() {
        if (issmoking && !dropping) {
            width = texture.getWidth() * (height / texture.getHeight());
            tm1.scheduleTask(t6, sm_time);
        } else {
            tm1.scheduleTask(t5, 0.1f);
        }
    }

    public void dropCigarette() {
        tm2.scheduleTask(t4, 0.1f);
    }

    public void walkRight() {
        if (movingRight) {
            walking_r = true;
            walking_l = false;
            try {
                tm1.scheduleTask(t2, 0.01f);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public void runL() {
        if (runningL) {
            walking_r = false;
            walking_l = false;
            runningR = false;
            tm1.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    if (!withFood) {
                        width = texture.getWidth() * (height / texture.getHeight());
                        if (index < runLeft.size() - 1) {
                            index++;
                        } else index = 0;
                        texture = runLeft.get(index);
                        runL();
                    } else {
                        texture = withFood1.get(index);
                        width = texture.getWidth() * (height / texture.getHeight());
                        if (index < withFood1.size() - 1) {
                            index++;
                        } else index = 0;
                        runL();
                    }
                }
            }, 0.04f);
        } else {
            tm1.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    runL();
                }
            }, 0.01f);
        }
    }

    public void runR() {
        if (runningR) {
            walking_r = false;
            walking_l = false;
            runningL = false;
            tm1.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    if (!withFood) {
                        width = texture.getWidth() * (height / texture.getHeight());
                        if (index < runRight.size() - 1) {
                            index++;
                        } else index = 0;
                        texture = runRight.get(index);
                        runR();
                    } else {
                        texture = withFood1.get(index);
                        width = texture.getWidth() * (height / texture.getHeight());
                        if (index < withFood1.size() - 1) {
                            index++;
                        } else index = 0;
                        runR();
                    }
                }
            }, 0.04f);
        } else {
            tm1.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    runR();
                }
            }, 0.01f);
        }
    }

    public void walkLeft() {
        if (movingLeft) {
            walking_l = true;
            walking_r = false;
            try {
                tm2.scheduleTask(t1, 0.01f);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public void create1() {
        for (int i = 2; i < 10; i++) {
            anim.add(main.manager.get("animation" + "/frame-001000" + i + ".png", Texture.class));
            anim2.add(main.manager.get("animation2" + "/frame-001000" + i + ".png", Texture.class));
        }
        for (int i = 10; i < 25; i++) {
            anim.add(main.manager.get("animation" + "/frame-00100" + i + ".png", Texture.class));
            anim2.add(main.manager.get("animation2" + "/frame-00100" + i + ".png", Texture.class));
        }
    }

    public void createTask() {
        t1 = new Timer.Task() {
            @Override
            public void run() {
                if (!withFood) {
                    width = Gdx.graphics.getWidth() / 23;
                    texture = anim2.get(index2);
                    if (index2 < anim2.size() - 1) {
                        index2++;
                    } else index2 = 0;
                    walkLeft();
                } else {
                    texture = withFood2.get(index2);
                    width = texture.getWidth() * (height / texture.getHeight());
                    if (index2 < withFood2.size() - 1) {
                        index2++;
                    } else index2 = 0;
                    walkLeft();
                }
            }
        };
        t2 = new Timer.Task() {
            @Override
            public void run() {
                if (!withFood) {
                    width = Gdx.graphics.getWidth() / 23;
                    if (index < anim.size() - 1) {
                        index++;
                    } else index = 0;
                    texture = anim.get(index);
                    walkRight();
                } else {
                    texture = withFood1.get(index);
                    width = texture.getWidth() * (height / texture.getHeight());
                    if (index < withFood1.size() - 1) {
                        index++;
                    } else index = 0;
                    walkRight();
                }
            }
        };
        t3 = new Timer.Task() {
            @Override
            public void run() {
                issmoking = false;
                dropping = false;
                sm_index = 0;
                width = Gdx.graphics.getWidth() / 23;
            }
        };
        t4 = new Timer.Task() {
            @Override
            public void run() {
                texture = smoking.get(sm_index);
                sm_index++;
                if (sm_index != smoking.size() - 1) {
                    dropCigarette();
                } else {
                    new Timer().scheduleTask(t3, 1f);
                }
            }
        };
        t5 = new Timer.Task() {
            @Override
            public void run() {
                smoke1();
            }
        };
        t6 = new Timer.Task() {
            @Override
            public void run() {
                if (sm_index < 39) {
                    texture = smoking.get(sm_index);
                    sm_index++;
                    smoke1();
                } else if (sm_index >= 39) {

                    sm_time = 0.1f;
                    texture = smoking.get(sm_index);
                    sm_index++;
                    if (sm_index == 40) {
                        sm_time = 1f;
                    }
                    if (sm_index == 51) {
                        sm_index = 39;
//                            sm_time=0.5f;
                        count++;
                    }
                    if (count == 7) {
                        sm_index = 52;
                        count = 0;
//                            issmoking=false;
                        sm_time = 0.05f;
                        dropping = true;
                        dropCigarette();
                    }
                    smoke1();
                }
            }
        };
        t7 = new Timer.Task() {
            @Override
            public void run() {
                index_dr = 0;
                drinkingcoffee = false;
                droppingcoffee = false;
                width = Gdx.graphics.getWidth() / 23;
//                            texture=stay;
            }
        };
        t8 = new Timer.Task() {
            @Override
            public void run() {
                texture = drinking.get(index_dr);
                index_dr++;
                if (index_dr < drinking.size() - 1) {
                    drink1();
                } else {
                    new Timer().scheduleTask(t7, 0.5f);
                }
            }
        };
        t9 = new Timer.Task() {
            @Override
            public void run() {
                drink();
            }
        };
        t10 = new Timer.Task() {
            @Override
            public void run() {
                texture = drinking.get(index_dr);
                index_dr++;
                drinkTime = 0.15f;
                if (index_dr == 8) {
                    drinkTime = 1f;
                }
                if (index_dr == 9) {
                    index_dr = 0;
                    drinkTime = 1f;
                    count_dr++;
                    if (count_dr > 4) {
                        drink1();
                        droppingcoffee = true;
                        index_dr = 9;
                        drinkTime = 0.15f;
                    } else {
                        drink();
                    }
                } else {
                    drink();
                }
            }
        };
        t11 = new Timer.Task() {
            @Override
            public void run() {
                texture = sitting2.get(index_sit);
                width = texture.getWidth() * (height / texture.getHeight());
                index_sit++;
                if (index_sit != sitting2.size() - 1) {
                    sit();
                } else {
                    index_sit = 0;
                    sitting1 = true;
                    isSitting = true;
                }
            }
        };
    }

    public boolean reachedHome(float x, float width) {
        return position.x <= x + width / 2 + width / 3 && position.x > x+width/3;
    }

    public boolean reachedMarket(float x, float width) {
        return position.x + this.width / 2 > x + width - width / 4 && position.x + this.width / 2 < x + width - width / 8;
    }

    public boolean reachedSchool(float x, float width) {
        if (position.x + this.width / 2 > x + width / 2 - width / 12 && position.x + this.width / 2 < x + width / 2 + width / 12) {
            return true;
        }
        return false;
    }

    public boolean reachedCafe(float x, float width) {
        System.out.println(position.x + " " + x + " " + width);
        if (position.x + this.width / 2 > x && position.x + this.width / 2 < x + width / 4) {
            return true;
        }
        return false;
    }

    public boolean reachedBench(Bench bench) {
        if (position.x - width > bench.x && position.x + 2 * width < bench.x + bench.width)
            return true;
        return false;
    }

    public void create3() {
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010028.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010029.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010030.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010031.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010032.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010033.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010034.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010035.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010036.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010037.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010038.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010039.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010040.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010041.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010042.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010043.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010044.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010045.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010046.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010047.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010048.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010049.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010050.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010051.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010052.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010053.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010054.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010055.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010056.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010057.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010058.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010059.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010060.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010061.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010062.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010063.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010064.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010065.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010066.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010067.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010068.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010069.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010070.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010071.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010072.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010073.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010074.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010075.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010076.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010077.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010078.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010079.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010080.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010081.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010082.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010083.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010084.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010085.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010086.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010087.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010088.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010089.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010090.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010091.png")));
        smoking.add(new Texture(Gdx.files.internal("smoking/frame-0010092.png")));
        withFood1 = new ArrayList<Texture>();
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00002.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00003.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00004.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00005.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00006.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00007.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00008.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00009.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00010.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00011.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00012.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00013.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00014.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00015.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00016.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00017.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00018.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00019.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00020.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00021.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00022.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00023.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00024.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00025.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00026.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00027.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00028.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00029.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00030.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00031.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00032.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00033.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00034.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00035.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00036.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00037.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00038.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00039.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00040.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00041.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00042.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00043.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00044.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00045.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00046.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00047.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00048.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00049.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00050.png")));
        withFood1.add(new Texture(Gdx.files.internal("walkingWithFood/00051.png")));
        withFood2 = new ArrayList<Texture>();
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00002.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00003.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00004.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00005.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00006.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00007.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00008.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00009.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00010.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00011.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00012.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00013.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00014.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00015.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00016.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00017.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00018.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00019.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00020.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00021.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00022.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00023.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00024.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00025.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00026.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00027.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00028.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00029.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00030.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00031.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00032.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00033.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00034.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00035.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00036.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00037.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00038.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00039.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00040.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00041.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00042.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00043.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00044.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00045.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00046.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00047.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00048.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00049.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00050.png")));
        withFood2.add(new Texture(Gdx.files.internal("walkingWithFood2/00051.png")));
        stayWithFood = new Texture(Gdx.files.internal("walkingWithFood/00001.png"));
        drinking = new ArrayList<Texture>();
        drinking.add(new Texture(Gdx.files.internal("drinking/00071.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00072.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00073.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00074.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00075.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00076.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00077.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00078.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00079.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00080.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00081.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00082.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00083.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00084.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00085.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00086.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00087.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00088.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00089.png")));
        drinking.add(new Texture(Gdx.files.internal("drinking/00090.png")));
        sitting2 = new ArrayList<Texture>();
        sitting2.add(new Texture(Gdx.files.internal("sitting/00001.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00002.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00003.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00004.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00005.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00006.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00007.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00008.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00009.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00010.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00011.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00012.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00013.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00014.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00015.png")));
        sitting2.add(new Texture(Gdx.files.internal("sitting/00016.png")));
    }
}
