package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Main;

import java.util.ArrayList;
import java.util.Random;

import Health.Health;
import Notification.Notification;
import Player.*;
import Player.PeopleVal;
import Player.Player;
import Support.Texture;
import Weather.Weather;
import roadActions.Bus;
import roadActions.Car;

//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.Texture;
//import java.util.Comparator;

//import roadActions.Bus;
//
public class Background {
    public ArrayList<Lamp> lamps;
    public Random random;
    public int moneyStolen = 0, moneyStolen1;
    public static int situation;
    public Notification n1;
    public boolean winter = false;
    public Tip tip;
    public boolean make_ontouch = true;
    public ArrayList<Health> hearts;
    public ArrayList<Car> cars;
    public Variables variables;
    public PositionArrow positionArrow;
    public Weather weather;
    public Timer timer, timer1, timer2;
    public Stealing stealing, stealing1, stealing2;
    public Hospital hospital;
    public Error error;
    public Sleep sleep;
    public Food food;
    public ArrayList<Float> zooms;
    //    public ButtonListener btn;
    public ArrayList<Bench> benches;
    public ArrayList<Bush> bushes;
    public TopPanel toppanel;
    public Cafe cafe;
    public FastFood fastFood;
    public School school;
    public Market market;
    public Arrows arrow;
    public Player player;
    public ArrayList<Flower> flowers;
    public ArrayList<Road> roads;
    public ArrayList<Sky> skies;
    public ArrayList<Tree> trees;
    public Home home;
    public final Main game;
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public String direction;
    public float c_add = 0.2f;
    public float st_add = 0.05f;
    public String error1;
    public ArrayList<People> peoples;
    public PeopleVal val;
    public PoliceDep policeDep;
    public Bus bus;
    public Relax relax;
    public Sign[] sign;
    public Factory factory;
    public Bar bar;

    public Background(final Main game) {
        lamps = new ArrayList<Lamp>();
        timer1 = new Timer();
        timer2 = new Timer();
        random = new Random();
        tip = new Tip();
        variables = new Variables();
        positionArrow = new PositionArrow();
        peoples = new ArrayList<People>();
        zooms = new ArrayList<Float>();
        bushes = new ArrayList<Bush>();
        flowers = new ArrayList<Flower>();
        benches = new ArrayList<Bench>();
        roads = new ArrayList<Road>();
        skies = new ArrayList<Sky>();
        trees = new ArrayList<Tree>();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        this.game = game;
        float roadX = -Gdx.graphics.getWidth() * 3;
        for (int i = 0; i < 8; i++) {
            roads.add(new Road(roadX));
            if (roadX == -Gdx.graphics.getWidth() * 3)
                skies.add(new Sky(roadX, roadX, game));
            if (roadX != -Gdx.graphics.getWidth() * 3)
                skies.add(new Sky(roadX, skies.get(i - 1).t_x + Gdx.graphics.getWidth(), game));
            skies.get(i).width = roads.get(i).width;
            roadX += roads.get(0).width;
        }
        skies.add(new Sky(roadX, skies.get(skies.size() - 3).t_x + Gdx.graphics.getWidth(), game));
        skies.add(new Sky(roadX, skies.get(skies.size() - 2).t_x + Gdx.graphics.getWidth(), game));
        skies.add(new Sky(roadX, skies.get(skies.size() - 1).t_x + Gdx.graphics.getWidth(), game));
        player = new Player(game);
        home = new Home(player, game);
        arrow = new Arrows(player.position.x + player.width / 2 + 8 * player.width - Gdx.graphics.getWidth() / 24 - Gdx.graphics.getWidth() / 40, Gdx.graphics.getWidth() / 40 + player.position.x + player.width / 2 - 8 * player.width, player.position.x + player.width / 2 - 4 * player.width - Gdx.graphics.getWidth() / 14, player.position.x + player.width / 2 + 4 * player.width, game);
        market = new Market(player);
        cafe = new Cafe(player, game);
        toppanel = new TopPanel(camera, player);
        trees.add(new Tree(market.x + market.width / 2 + Gdx.graphics.getWidth() / 8, market.y, "background/Tree1.png", "background/Tree1_snow.png"));
        benches.add(new Bench(cafe.x + cafe.width + cafe.width / 10, player, game)); //0
        trees.add(new Tree(benches.get(0).x + benches.get(0).width, cafe.y, "background/Tree2.png", "background/Tree2_snow.png"));
        trees.add(new Tree(home.position.x + 2 * home.width, cafe.y, "background/Tree3.png", "background/Tree3_snow.png"));
        game.add = 1;
        trees.add(new Tree(home.position.x + 8 * home.width / 5, cafe.y, "background/Tree2.png", "background/Tree2_snow.png"));
        flowers.add(new Flower(cafe.x - Gdx.graphics.getWidth() / 20, cafe.y, 1, game));
        flowers.add(new Flower(market.x - Gdx.graphics.getWidth() / 14, cafe.y, 0, game));
        benches.add(new Bench(trees.get(1).x + trees.get(1).width + trees.get(1).width / 3, player, game));//1
        school = new School(benches.get(1).x + benches.get(1).width / 3 + benches.get(1).width, player);
        flowers.add(new Flower(trees.get(1).x + trees.get(1).width - trees.get(1).width / 3, Gdx.graphics.getHeight() / 4, 0, game));
        game.add = 2;
        benches.add(new Bench(school.position.x + school.width + school.width / 35, player, game));// i=2
        trees.add(new Tree(benches.get(2).x + benches.get(2).width, cafe.y, "background/Tree1.png", "background/Tree1_snow.png")); //i=4
        trees.add(new Tree(trees.get(4).x + 11 * trees.get(4).width / 10, cafe.y, "background/Tree2.png", "background/Tree2_snow.png")); //i=5
        trees.add(new Tree(trees.get(5).x + 11 * trees.get(5).width / 10, cafe.y, "background/Tree1.png", "background/Tree1_snow.png"));//i=6
        benches.add(new Bench(trees.get(6).x + 2 * trees.get(6).width / 3, player, game));//3
        game.add = 3;
        trees.add(new Tree(benches.get(benches.size() - 3).x + benches.get(benches.size() - 3).width, cafe.y, "background/Tree3.png", "background/Tree3_snow.png"));
        bushes.add(new Bush(trees.get(trees.size() - 7).x + trees.get(trees.size() - 7).width / 2, game));
        fastFood = new FastFood(trees.get(trees.size() - 2).x + 11 * (trees.get(trees.size() - 2).width) / 10 + 8 * benches.get(0).width / 10, player, game);
        trees.add(new Tree(fastFood.x + fastFood.width + fastFood.width / 4, cafe.y, "background/Tree3.png", "background/Tree3_snow.png"));
        trees.add(new Tree(home.position.x - trees.get(trees.size() - 1).width, cafe.y, "background/Tree3.png", "background/Tree3_snow.png"));
        trees.add(new Tree(home.position.x - trees.get(trees.size() - 1).width * 2, cafe.y, "background/Tree1.png", "background/Tree1_snow.png"));//i=10
        game.add = 4;
        benches.add(new Bench(fastFood.x + fastFood.width + fastFood.width / 4 + trees.get(0).width, player, game));//4
        benches.add(new Bench(trees.get(10).x - Bench.width, player, game));//5
        trees.add(new Tree(benches.get(5).x - 2 * trees.get(6).width / 3, cafe.y, "background/Tree2.png", "background/Tree2_snow.png"));//11
        factory = new Factory(trees.get(11).x - 8 * Gdx.graphics.getWidth() / 10);
        trees.add(new Tree(factory.x - 3 * trees.get(0).width / 2, cafe.y, "background/Tree1.png", "background/Tree1_snow.png"));//12
        bar = new Bar(trees.get(12).x - 8 * Gdx.graphics.getWidth() / 35);
        benches.add(new Bench(bar.x - Bench.width, player, game));//6
        hospital = new Hospital(benches.get(benches.size() - 3).x + benches.get(0).width / 3 + benches.get(0).width, player, game);
        player.setFastFood(fastFood);
        player.create3();
        game.add = 5;
        food = new Food(home, game);
        sleep = new Sleep(home);
        relax = new Relax(home);
        error = new Error(player);
        val = new PeopleVal(cafe, market, fastFood, game, school);
        val.create3();
        val.create1();
        val.create2();
        for (int i = 0; i < 1; i++) {
            peoples.add(new People(benches, game, val, toppanel));
        }
        game.add = 6;
        trees.add(new Tree(hospital.position.x + hospital.width, Gdx.graphics.getHeight() / 4, "background/Tree2.png", "background/Tree2_snow.png"));//13

        policeDep = new PoliceDep(player, trees.get(trees.size() - 1).x + 2 * trees.get(0).width);
        stealing = new Stealing(market.x + market.width / 2 - Gdx.graphics.getHeight() / 14, market.y + market.height + Gdx.graphics.getHeight() / 30, player, camera, toppanel, arrow, error, policeDep);
        stealing1 = new Stealing(cafe.x + cafe.width / 2 - Gdx.graphics.getWidth() / 32, cafe.y + cafe.height + Gdx.graphics.getHeight() / 30, player, camera, toppanel, arrow, error, policeDep);
        stealing2 = new Stealing(fastFood.x + fastFood.width / 2 - Gdx.graphics.getWidth() / 14, fastFood.y + fastFood.height + Gdx.graphics.getHeight() / 30, player, camera, toppanel, arrow, error, policeDep);
        game.add = 7;
        weather = new Weather(player, game, toppanel.time);
        timer = new Timer();
//        bus = new Bus(player);
        cars = new ArrayList<Car>();
        cars.add(new Car(2, player, game));
        cars.add(new Car(2, player, game));
        cars.add(new Car(1, player, game));
        cars.add(new Car(1, player, game));
        game.add = 8;
        cars.get(2).x = -4 * cars.get(0).width;
        cars.get(3).x = -16 * cars.get(0).width;
        cars.get(0).x = Gdx.graphics.getWidth() * 7 + 4 * cars.get(0).width;
        cars.get(1).x = Gdx.graphics.getWidth() * 7 + 16 * cars.get(0).width;
        hearts = new ArrayList<Health>();
        for (int i = 0; i < 6; i++) {
            hearts.add(new Health(hospital, i * hospital.width / 5 + hospital.position.x - hospital.width / 40));
        }
        game.add = 10;
//        bus = new Bus(true, roads.size() - 1 * roads.get(0).width, player, camera, toppanel, arrow, error);
        sign = new Sign[2];
        sign[0] = new Sign(policeDep.x + policeDep.width);
        sign[1] = new Sign(-Gdx.graphics.getWidth() * 3 + Gdx.graphics.getWidth() / 2 - sign[0].width);
        n1 = new Notification();

        lamps.add(new Lamp(home.position.x + 2 * home.width / 3));
        lamps.add(new Lamp(market.x + market.width));
        lamps.add(new Lamp(cafe.x + 3 * cafe.width / 2));
        lamps.add(new Lamp(school.position.x + school.width));
        lamps.add(new Lamp(fastFood.x + 2*fastFood.width/3));
        lamps.add(new Lamp(hospital.position.x + hospital.width));
    }

    public float s_add = 0.2f;
    public float steal_add = 1f;

    public void draw() {
        n1.update(player.position.x + player.width / 2);
        n1.ontouch(player.position.x, player.width, player.position.y, arrow, this);
        checkNotice();
        if (toppanel.time.months == 11 || toppanel.time.months == 1 || toppanel.time.months == 0) {
            winter = true;
        } else {
            winter = false;
        }
        if (player.inPoliceCar) {
            toppanel.plusMoney = 0;
        }
        toppanel.ontouch_pause(player.position.x, player.width, player.position.y, arrow);
        if (toppanel.pause)
            pause();
        if (player.inBus) {
            if (player.payment == toppanel.money.money) {
                outTaxi1();
            }
            player.position.x = cars.get(player.busNumber).x + cars.get(0).width / 2 - player.width / 2;
            camera.position.x = cars.get(player.busNumber).x + cars.get(0).width / 2;
//            toppanel.x=player.position.x-player.width/2-Gdx.graphics.getWidth()/2;
            player.internet.x += player.position.x + player.width / 2 - (player.smoke.x + player.smoke.width / 2);
            player.call.x += player.position.x + player.width / 2 - (player.smoke.x + player.smoke.width / 2);
            player.smoke.x += player.position.x + player.width / 2 - (player.smoke.x + player.smoke.width / 2);
            error.x += player.position.x + player.width / 2 - (player.smoke.x + player.smoke.width / 2);
            arrow.update(player.position.x + player.width / 2 - Gdx.graphics.getWidth() / 2 - toppanel.x);
            toppanel.update(player.position.x + player.width / 2 - Gdx.graphics.getWidth() / 2 - toppanel.x);
            if (timer.isEmpty())
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (toppanel.pause == false)
                            player.payment += 1;
                    }
                }, 1.2f);
        } else {
            player.payment = 2;
        }
        if (arrow.change) {
            home.go.touched = false;
            home.go1.touched = false;
            market.go1.touched = false;
            market.Robb1.touched = false;
            market.job1.touched = false;
            cafe.go1.touched = false;
            cafe.Robb1.touched = false;
            cafe.job1.touched = false;
            school.go1.touched = false;
            school.Robb1.touched = false;
            school.job1.touched = false;
            fastFood.go1.touched = false;
            fastFood.Robb1.touched = false;
            fastFood.job1.touched = false;
            variables.moving_cafe = false;
            variables.moving_school = false;
            variables.moving_ff = false;
            variables.moving_home = false;
            variables.moving_market = false;
            variables.moving_hospital = false;
        }
        if (!home.onscreen) {
            home.varExists = false;
        }
        if (!market.onscreen) {
            market.varExists = false;
        }
//        if(!player.onscreen) {
//            player.varExists = false;
//        }
        if (!cafe.onscreen) {
            cafe.varExists = false;
        }
//        if (!bus.onscreen) {
//            bus.varExists = false;
//        }
        if (!fastFood.onscreen) {
            fastFood.varExists = false;
        }
        if (!school.onscreen) {
            school.varExists = false;
        }
        for (int i = 0; i < benches.size(); i++) {
            if (!benches.get(i).onscreen)
                benches.get(i).varExists = false;
        }
//        goBus();
        if (player.stealingMarket && !stealing.stop && !stealing1.stop && !stealing2.stop) {
            if (stealing.index == -1) {
//                System.out.println("koko1");
                stealing.goTimer();
            }
            if (steal_add == 1f) {
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (player.stealingMarket) {
                            if (!player.inPoliceCar) {
                                toppanel.money.money += player.stealSkill / 5 + 3;
                                toppanel.plusMoney = player.stealSkill / 5 + 3;
                                moneyStolen += player.stealSkill / 5 + 3;
                                toppanel.money.y2 = market.y + market.height;
                                toppanel.money.x1 = market.x + market.width / 2;
                                toppanel.money.drawPlusAnimation();
                            }
                        }
                        steal_add = 1f;
                    }
                }, steal_add);
                steal_add += 1f;
            }
        } else if (player.stealingCafe && !stealing.stop && !stealing1.stop && !stealing2.stop) {
            if (stealing1.index == -1) {
//                System.out.println("koko1");
                stealing1.goTimer();
            }
            if (steal_add == 1f) {
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (player.stealingCafe) {
                            if (!player.inPoliceCar) {
                                toppanel.money.money += player.stealSkill / 5 + 2;
                                toppanel.plusMoney = player.stealSkill / 5 + 2;
                                moneyStolen += player.stealSkill / 5 + 2;
                                toppanel.money.y2 = cafe.y + cafe.height;
                                toppanel.money.x1 = cafe.x + cafe.width / 2;
                                toppanel.money.drawPlusAnimation();
                            }
                        }
                        steal_add = 1f;
                    }
                }, steal_add);
                steal_add += 1f;
            }
        } else if (player.stealingFF && !stealing.stop && !stealing1.stop && !stealing2.stop) {
            if (stealing2.index == -1) {
//                System.out.println("koko1");
//                stealing2.index = -1;
                stealing2.goTimer();
            }
            if (steal_add == 1f) {
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (player.stealingFF) {
                            if (!player.inPoliceCar) {
                                toppanel.money.money += player.stealSkill / 4 + 3;
                                toppanel.plusMoney = player.stealSkill / 4 + 3;
                                moneyStolen += player.stealSkill / 4 + 3;
                                toppanel.money.y2 = fastFood.y + fastFood.height;
                                toppanel.money.x1 = fastFood.x + fastFood.width / 2;
                                toppanel.money.drawPlusAnimation();
                            }
                        }
                        steal_add = 1f;
                    }
                }, steal_add);
                steal_add += 1f;
            }
        } else {
            stealing.index = -1;
            stealing1.index = -1;
            stealing2.index = -1;
            toppanel.plusMoney = 0;
            stealing.current = stealing.timer.get(0);
            stealing1.current = stealing1.timer.get(0);
            stealing2.current = stealing2.timer.get(0);
        }
        if (player.inDep) {
            toppanel.time.timespeed = 0.01f;
            if (!player.minusMoneyDone) {
                player.minusMoneyDone = true;
                toppanel.minusMoney = -((int) toppanel.money.money / 3);
                toppanel.money.y1 = policeDep.y + policeDep.height / 2;
                toppanel.money.x1 = policeDep.x + policeDep.width / 2;
                toppanel.money.drawMinusAnimation();
                toppanel.money.money = toppanel.money.money - toppanel.money.money / 3;

                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        toppanel.minusMoney = 0;
                        player.minusMoneyDone = false;
                    }
                }, 13f);
            }
            if (toppanel.h_width > toppanel.maxwidth / 2)
                toppanel.h_width = toppanel.maxwidth / 2;
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    player.inDep = false;
                    player.inPoliceCar = false;
                }
            }, 10f);
        }
        if (player.atschool) {
            toppanel.time.timespeed = 0.07f;
            if (st_add == 0.05f) {
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (player.atschool && toppanel.st_width <= toppanel.maxwidth)
                            toppanel.st_width += toppanel.maxwidth / 800;
                        st_add = 0.05f;
                    }
                }, st_add);
                c_add += 0.05f;
            }
            if (toppanel.time.hour > 13) {
                player.atschool = false;
            }
        }
        if (!player.sitting1) {
            if (player.position.y != player.basic_y) {
                player.position.y = player.basic_y;
            }
        }
        peopleCollision();
        for (int i = 0; i < peoples.size(); i++) {
            if (peoples.get(i).x > player.position.x + player.width / 2 + Gdx.graphics.getWidth() / 2 || peoples.get(i).x + peoples.get(i).width < player.position.x + player.width / 2 - Gdx.graphics.getWidth() / 2) {
                peoples.get(i).onscreen = false;
            } else {
                peoples.get(i).onscreen = true;
            }
        }
        player.width = player.texture.getWidth() * (player.height / player.texture.getHeight());
        if (player.sitting1) {
            if (c_add == 0.2f) {
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (player.sitting1 && toppanel.c_width <= toppanel.maxwidth)
                            toppanel.c_width += toppanel.maxwidth / 800;
                        c_add = 0.2f;
                    }
                }, c_add);
                c_add += 0.2f;
            }
        }
        if (!player.sitting1) {
            player.height = player.basicHeight;
            c_add = 0.2f;
        }
        if (player.issmoking) {
            toppanel.time.timespeed = 2f;
            if (s_add == 0.2f) {
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (player.issmoking && toppanel.c_width <= toppanel.maxwidth) {
                            toppanel.c_width += toppanel.maxwidth / 700;
                            toppanel.h_width -= toppanel.maxwidth / 2200;
                            s_add = 0.2f;
                        }
                    }
                }, s_add);
                s_add += 0.2f;
            }
        }
        if (player.issleeping) {
            toppanel.time.timespeed = 0.007f;
            if (toppanel.s_width >= toppanel.maxwidth - toppanel.maxwidth / 1000) {
                player.issleeping = false;
                player.relaxing = false;
                player.sleep.touched = false;
                player.relax.touched = false;
                toppanel.time.timespeed = 0.3f;
            }
        }
        if (player.relaxing) {
            toppanel.time.timespeed = 0.0001f;
        }
        listen();
        if (!player.issmoking && !player.athome && !player.atmarket && !player.atcafe && !player.issleeping && !player.drinkingcoffee && !player.atFastFood && !player.relaxing && !player.atschool && !player.inDep && make_ontouch) {
            toppanel.time.timespeed = 0.3f;
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital)
                home.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (home.varExists) {
                positionArrow.basY = home.position.y + home.height + positionArrow.height / 5;
                if (positionArrow.previous != 1) {
                    positionArrow.y = positionArrow.basY;
                    positionArrow.previous = 1;
                }
                positionArrow.x = home.position.x + home.width / 2 - positionArrow.width / 2;
                if (!positionArrow.goDown && !positionArrow.goUp)
                    positionArrow.y = home.position.y + home.height + positionArrow.height / 5;
                positionArrow.draw = true;
                market.varExists = false;
                cafe.varExists = false;
                hospital.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                school.varExists = false;
                fastFood.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
                player.varExist = false;
            }
            if (hospital.varExists) {
                positionArrow.basY = hospital.position.y + hospital.height + positionArrow.height / 4;
                if (positionArrow.previous != 6) {
                    positionArrow.y = positionArrow.basY;
                    positionArrow.previous = 6;
                }
                positionArrow.x = hospital.position.x + hospital.width / 2 - positionArrow.width / 2;
                if (!positionArrow.goDown && !positionArrow.goUp)
                    positionArrow.y = hospital.position.y + hospital.height + positionArrow.height / 4;
                positionArrow.draw = true;
                market.varExists = false;
                home.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                cafe.varExists = false;
                school.varExists = false;
                fastFood.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
                player.varExist = false;
            }
//            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus)
//                bus.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (market.drawJobs) {
                market.jobs.get(0).ontouch(player.position.x, player.width, player.position.y);
            }
            if (cafe.drawJobs) {
                cafe.jobs.get(0).ontouch(player.position.x, player.width, player.position.y);
            }
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital && !market.drawJobs)
                market.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital)
                hospital.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (market.varExists) {
                positionArrow.basY = market.y + market.height + positionArrow.height / 3;
                if (positionArrow.previous != 2) {
                    positionArrow.y = positionArrow.basY;
                    positionArrow.previous = 2;
                }
                positionArrow.x = market.x + market.width / 2 - positionArrow.width / 2;
                if (!positionArrow.goDown && !positionArrow.goUp)
                    positionArrow.y = market.y + market.height + positionArrow.height / 3;

                positionArrow.draw = true;
                hospital.varExists = false;
                home.varExists = false;
                cafe.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                school.varExists = false;
                fastFood.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
                player.varExist = false;
            }
            for (int i = 0; i < benches.size(); i++) {
                if (benches.get(i).varExists) {
                    positionArrow.basY = benches.get(i).y + benches.get(i).height + positionArrow.height / 3;
                    if (positionArrow.previous != 2) {
                        positionArrow.y = positionArrow.basY;
                        positionArrow.previous = 2;
                    }
                    positionArrow.x = benches.get(i).x + benches.get(i).width / 2 - positionArrow.width / 2;
                    if (!positionArrow.goDown && !positionArrow.goUp)
                        positionArrow.y = benches.get(i).y + benches.get(i).height + positionArrow.height / 3;

                    positionArrow.draw = true;
                    hospital.varExists = false;
                    home.varExists = false;
                    for (int j = 0; j < cars.size(); j++) {
                        cars.get(j).varExist = false;
                    }
                    market.varExists = false;
                    cafe.varExists = false;
                    school.varExists = false;
                    fastFood.varExists = false;
                    player.varExist = false;
                }
            }
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital && !cafe.drawJobs)
                cafe.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (cafe.varExists) {
                positionArrow.basY = cafe.y + cafe.height + positionArrow.height / 3;
                if (positionArrow.previous != 3) {
                    positionArrow.y = positionArrow.basY;
                    positionArrow.previous = 3;
                }
                positionArrow.x = cafe.x + cafe.width / 2 - positionArrow.width / 2;
                if (!positionArrow.goDown && !positionArrow.goUp)
                    positionArrow.y = cafe.y + cafe.height + positionArrow.height / 3;
                hospital.varExists = false;
                positionArrow.draw = true;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                home.varExists = false;
                market.varExists = false;
                school.varExists = false;
                fastFood.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
                player.varExist = false;
            }
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital)
                fastFood.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (fastFood.varExists) {
                positionArrow.basY = fastFood.y + fastFood.height + positionArrow.height / 3;
                if (positionArrow.previous != 4) {
                    positionArrow.y = positionArrow.basY;
                    positionArrow.previous = 4;
                }
                positionArrow.x = fastFood.x + fastFood.width / 2 - positionArrow.width / 2;
                if (!positionArrow.goDown && !positionArrow.goUp)
                    positionArrow.y = fastFood.y + fastFood.height + positionArrow.height / 3;
                hospital.varExists = false;
                positionArrow.draw = true;
                home.varExists = false;
                cafe.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                school.varExists = false;
                market.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
                player.varExist = false;
            }
            n1.ontouch(player.position.x, player.width, player.position.y, arrow, this);
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital)
                school.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (school.varExists) {
                positionArrow.basY = school.position.y + school.height + positionArrow.height / 5;
                if (positionArrow.previous != 5) {
//                    positionArrow.draw = false;
                    positionArrow.y = positionArrow.basY;
                    positionArrow.previous = 5;
                }
                positionArrow.x = school.position.x + school.width / 2 - positionArrow.width / 2;
                if (!positionArrow.goDown && !positionArrow.goUp)
                    positionArrow.y = school.position.y + school.height + positionArrow.height / 5;
                hospital.varExists = false;
                positionArrow.draw = true;
                home.varExists = false;
                cafe.varExists = false;
                market.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                fastFood.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
                player.varExist = false;
            }
            for (int i = 0; i < benches.size(); i++) {
                if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital)
                    benches.get(i).ontouch(player.position.x, player.width, player.position.y);
                if (benches.get(i).varExists) {
                    for (int j = 0; j < benches.size(); j++) {
                        if (j != i) {
                            benches.get(j).varExists = false;
                        }
                    }
                    hospital.varExists = false;
                    home.varExists = false;
                    cafe.varExists = false;
                    market.varExists = false;
                    school.varExists = false;
                    fastFood.varExists = false;
                    player.varExist = false;
                }
            }
            if (!player.stealingFF && !player.stealingCafe && !player.stealingMarket && !player.inBus && !player.inHospital)
                player.ontouch();
            if (player.varExist) {
                market.varExists = false;
                home.varExists = false;
                hospital.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                cafe.varExists = false;
                school.varExists = false;
                fastFood.varExists = false;
                for (int i = 0; i < benches.size(); i++) {
                    benches.get(i).varExists = false;
                }
            }
        }
        camera.update();


        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i).onscreen)
                roads.get(i).draw(batch, winter);
            roads.get(i).update(camera.position.x);
        }
        for (int i = 0; i < skies.size(); i++) {
//            if(skies.get(i).onscreen)
            skies.get(i).changeSky(toppanel.time);
            skies.get(i).draw(batch, winter);
            skies.get(i).update(camera.position.x);
        }
        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i).onscreen)
                trees.get(i).draw(batch, winter);
            trees.get(i).update(camera.position.x);
        }
        for (int i = 0; i < benches.size(); i++) {
            if (benches.get(i).onscreen)
                benches.get(i).draw(batch, winter);
            benches.get(i).update(camera.position.x);
        }
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).onscreen)
                flowers.get(i).draw(batch, winter);
            flowers.get(i).update(camera.position.x);
        }
        for (int i = 0; i < bushes.size(); i++) {
            if (bushes.get(i).onscreen)
                bushes.get(i).draw(batch, winter);
            bushes.get(i).update(camera.position.x);
        }
        if (!player.athome && !player.atmarket && !player.atcafe && !player.atFastFood && !player.atschool && !player.inPoliceCar && !player.inDep && !player.inBus && !player.inHospital) {
            if (make_ontouch)
                direction = arrow.touch();
            if (direction == "right") {
                if (player.position.x + player.width / 2 <= policeDep.x + policeDep.width / 2) {
                    player.drinkingcoffee = false;
                    player.issmoking = false;
                    player.issmoking = false;
                    player.sm_time = 0.05f;
                    player.drinkTime = 0.15f;
                    player.sm_index = 0;
                    player.index_dr = 0;
                    player.droppingcoffee = false;
                    market.drawJobs = false;
                    cafe.drawJobs = false;
                    player.runningR = false;
                    player.runningL = false;
                    player.stealingMarket = false;
                    player.stealingCafe = false;
                    player.stealingFF = false;
                    player.walking_l = false;
                    player.sitting1 = false;
                    player.speed = Gdx.graphics.getWidth() / 340;
                    player.moveRight();
                    if (player.walking_r == false)
                        player.walkRight();
                    toppanel.update(player.speed);
                    error.x += player.speed;
                    arrow.update(player.speed);

                    camera.position.x += player.speed;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                    if (camera.position.x <= roads.get(0).width * 2.5) {
                    }
                } else {
                    direction = "middle";
                    if (!player.withFood)
                        player.texture = player.stay;
                    else player.texture = player.stayWithFood;
                    camera.position.x = toppanel.x + Gdx.graphics.getWidth() / 2;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                }
            }

            if (direction == "rrun") {
                if (player.position.x + player.width / 2 <= policeDep.x + policeDep.width / 2) {
                    if (player.stamina.width1 < player.stamina.width / 50) {
                        direction = "right";
                        arrow.previous = "right";
                    }
                    player.drinkingcoffee = false;
                    player.issmoking = false;
                    player.sm_time = 0.05f;
                    player.drinkTime = 0.15f;
                    player.sm_index = 0;
                    player.index_dr = 0;
                    cafe.drawJobs = false;
                    player.droppingcoffee = false;
                    player.issmoking = false;
                    player.stealingMarket = false;
                    player.stealingFF = false;
                    market.drawJobs = false;
                    player.stealingCafe = false;
                    player.walking_l = false;
                    player.walking_r = false;
                    player.sitting1 = false;
                    player.issmoking = false;
                    player.speed = Gdx.graphics.getWidth() / 250;
                    player.runRight();
                    toppanel.update(player.speed);
                    error.x += player.speed;
                    arrow.update(player.speed);
                    camera.position.x += player.speed;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);

                    if (camera.position.x <= roads.get(0).width * 2.5) {
                    }
                } else {
                    direction = "middle";
                    if (!player.withFood)
                        player.texture = player.stay;
                    else player.texture = player.stayWithFood;
                    camera.position.x = toppanel.x + Gdx.graphics.getWidth() / 2;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                }
            }
            if (direction == "lrun") {
                player.sitting1 = false;
                player.issmoking = false;
                if (player.position.x >= -Gdx.graphics.getWidth() * 3 + Gdx.graphics.getWidth() / 2) {//home.position.x + home.width / 2 - player.width / 2
                    if (player.stamina.width1 < player.stamina.width / 50) {
                        direction = "left";
                        arrow.previous = "left";
                    } else {
                        player.drinkingcoffee = false;
                        player.issmoking = false;
                        player.sm_time = 0.05f;
                        player.drinkTime = 0.15f;
                        player.sm_index = 0;
                        player.index_dr = 0;
                        cafe.drawJobs = false;
                        market.drawJobs = false;
                        player.droppingcoffee = false;
                        player.issmoking = false;
                        player.stealingCafe = false;
                        player.stealingFF = false;
                        player.stealingMarket = false;
                        player.walking_r = false;
                        player.walking_l = false;
                        player.runningR = false;
                        player.speed1 = Gdx.graphics.getWidth() / 250;
                        player.runLeft();
                        player.runningL = true;
                        arrow.update(-player.speed1);

                        toppanel.update(-player.speed1);
                        error.x -= player.speed1;
                        camera.position.x -= player.speed1;
                        camera.update();
                        batch.setProjectionMatrix(camera.combined);
                    }
                } else {
                    direction = "middle";
                    arrow.previous = "middle";
                    if (!player.withFood)
                        player.texture = player.stay;
                    else player.texture = player.stayWithFood;
                    camera.position.x = toppanel.x + Gdx.graphics.getWidth() / 2;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                }
            }

            if (direction == "left") {
                player.sitting1 = false;
                if (player.position.x >= -Gdx.graphics.getWidth() * 3 + Gdx.graphics.getWidth() / 2) {//home.position.x + home.width / 2 - player.width / 2
                    player.drinkingcoffee = false;
                    player.issmoking = false;
                    player.sm_time = 0.05f;
                    player.drinkTime = 0.15f;
                    player.sm_index = 0;
                    player.index_dr = 0;
                    cafe.drawJobs = false;
                    player.droppingcoffee = false;
                    player.issmoking = false;
                    player.runningR = false;
                    player.runningL = false;
                    market.drawJobs = false;
                    player.stealingCafe = false;
                    player.stealingMarket = false;
                    player.stealingFF = false;
                    player.walking_r = false;
                    player.speed1 = Gdx.graphics.getWidth() / 340;
                    player.moveLeft();
                    if (player.walking_l == false)
                        player.walkLeft();
                    player.walking_l = true;
                    arrow.update(-player.speed1);
                    toppanel.update(-player.speed1);
                    error.x -= player.speed1;
                    camera.position.x -= player.speed1;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                } else {
                    if (!player.withFood)
                        player.texture = player.stay;
                    else player.texture = player.stayWithFood;
                    camera.position.x = toppanel.x + Gdx.graphics.getWidth() / 2;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                }
            }
            if (!player.issmoking && !player.drinkingcoffee)
                if (direction == "middle") {
                    player.walking_r = false;
                    player.walking_l = false;
                    player.runningR = false;
                    player.runningL = false;
                    player.movingRight = false;
                    player.movingLeft = false;
                    player.speed = 0;
                    player.speed1 = 0;
                    if (!player.withFood && !player.sitting1) {
                        player.texture = player.stay;
                        player.width = Gdx.graphics.getWidth() / 23;
                    } else if (!player.sitting1) player.texture = player.stayWithFood;
                    camera.position.x = toppanel.x + Gdx.graphics.getWidth() / 2;
                    camera.update();
                    batch.setProjectionMatrix(camera.combined);
                }
        }
        food.draw(batch, player);
        if (school.onscreen) {
            school.draw(batch, winter);
        }
        if (hospital.onscreen) {
            hospital.draw(batch, winter);
        }
        if (policeDep.onscreen) {
            policeDep.draw(batch, player);
        }
        weather.drawPuddles(batch);

        home.update(camera.position.x);
        market.update(camera.position.x);
        hospital.update(camera.position.x);
        cafe.update(camera.position.x);
        fastFood.update(camera.position.x);
        policeDep.update(camera.position.x);
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).update(camera.position.x);
        }
        market.update(player);
        cafe.update(player);
        hospital.update(player);
        fastFood.update(player);
        school.update(player);
        home.update(player);
        policeDep.update(player);
        for (int i = 0; i < benches.size(); i++) {
            benches.get(i).update(player);
        }
        if (home.onscreen) {
            home.draw(batch);
        }
        if (market.onscreen) {
            market.draw(batch, winter);
        }
        factory.draw(batch);
        bar.draw(batch, winter);
        if (cafe.onscreen) {
            cafe.draw(batch, winter);
        }
        if (fastFood.onscreen) {
            fastFood.draw(batch, winter);
        }
        for (int i = 0; i < peoples.size(); i++) {
            if (!player.issleeping && !player.atschool)
                peoples.get(i).draw(batch);
        }

        for (int i = 0; i < benches.size(); i++) {
            benches.get(i).drawVariants(batch, player);
        }
//        System.out.println(home.onscreen);
        if (player.issleeping) {
            sleep.draw(batch);
        }
        if (player.relaxing) {
            relax.draw(batch);
        }
        if (!player.athome && !player.stealingFF && !player.atmarket && !player.atcafe && !player.atFastFood && !player.atschool && !player.stealingMarket && !player.inPoliceCar && !player.inDep && !player.stealingCafe && !player.inBus && !player.inHospital)
            player.draw(batch);
        if (player.stealingMarket) {
            stealing.draw(batch);
        }
        if (player.stealingCafe) {
            stealing1.draw(batch);
        }
        if (player.stealingFF) {
            stealing2.draw(batch);
        }
        positionArrow.draw(batch);
        if (player.inHospital)
            for (int i = 0; i < 6; i++) {
                hearts.get(i).draw(batch);
            }
        toppanel.draw(batch);
        hospital.drawVariants(batch, player);
        cafe.drawVariants(batch, player);
        market.drawVariants(batch, player);
        school.drawVariants(batch, player);
        fastFood.drawVariants(batch, player);
        home.drawVariants(batch, player);
        player.drawHome(batch);
        player.drawMarket(batch);
        player.drawCafe(batch);
        player.drawFastFood(batch);

        if (player.varExist || home.varExists || cafe.varExists || market.varExists || school.varExists || fastFood.varExists || hospital.varExists) {
            player.back.x = player.position.x + player.width / 2 - player.GoOut1.width / 2;
            if (home.varExists) {
                player.back.y = home.smoke.y + 3 * home.smoke.height / 2;
            } else if (player.varExist) {
                player.back.y = player.smoke.y + 3 * player.internet.height / 2;
            } else {
                player.back.y = fastFood.Robb1.y + 3 * fastFood.Robb1.height / 2;
            }
            if (!player.inBus) {
                player.back.draw(batch);
                player.back.ontouch(player);
                if (player.back.touched) {
                    if (arrow.back != null) {
                        arrow.previous = arrow.back;
                    }
                    player.back.touched = false;
                    player.varExist = false;
                    home.varExists = false;
                    for (int i = 0; i < cars.size(); i++) {
                        cars.get(i).varExist = false;
                    }
                    cafe.varExists = false;
                    hospital.varExists = false;
                    market.varExists = false;
                    school.varExists = false;
                    fastFood.varExists = false;
                }
            }
        }
        for (int i = 0; i < benches.size(); i++) {
            if (benches.get(i).varExists) {
                player.back.x = player.position.x + player.width / 2 - player.GoOut1.width / 2;
                player.back.y = benches.get(i).smoke.y + 3 * benches.get(i).smoke.height / 2;
                player.back.draw(batch);
                player.back.ontouch(player);
                if (player.back.touched) {
                    if (arrow.back != null) {
                        arrow.previous = arrow.back;
                        arrow.back = null;
                    }
                    player.back.touched = false;
                    player.varExist = false;
                    home.varExists = false;
                    cafe.varExists = false;
                    market.varExists = false;
                    for (int j = 0; j < cars.size(); j++) {
                        cars.get(j).varExist = false;
                    }
                    school.varExists = false;
                    hospital.varExists = false;
                    fastFood.varExists = false;
                    benches.get(i).varExists = false;
                }
            }
        }
        sign[0].draw(batch);
        sign[1].draw(batch);
        if (!player.athome && !player.atmarket && !player.atcafe && !player.atFastFood && !player.atschool && !player.inPoliceCar && !player.inDep && !player.inBus && !player.inHospital)
            arrow.draw(batch);
        for (int i = 0; i < cars.size(); i++) {
            if (!cars.get(i).onscreen) {
                cars.get(i).draw(batch, player);
//                cars.get(i).varExist = false;
            } else {
                cars.get(i).draw(batch, player);
            }
        }
        error.draw(batch, error1);


        for (int i = 0; i < skies.size(); i++) {
            skies.get(i).drawFone(batch);
        }
        for (int i = 0; i < lamps.size(); i++) {
            lamps.get(i).draw(batch);
        }
        weather.draw(batch, camera, toppanel.pause);
        if (situation != 4 && situation != 5 && situation != 6)
            n1.draw(batch, situation);
        else {
            if (situation == 6)
                n1.draw(batch, situation, moneyStolen1);
            n1.draw(batch, situation, moneyStolen);
        }
        if (toppanel.pause) {
            toppanel.pause_menu.draw(batch);
        }
        tip.draw(batch, this);

        batch.end();
        if (!market.varExists && !cafe.varExists && !school.varExists && !fastFood.varExists && !home.varExists) {
            positionArrow.draw = false;
        }
    }

    public void eat() {
        if (player.athome) {
            player.eat.ontouch(player);
        }
        if (player.eat.touched) {
            if (food.count > 0) {
                if (toppanel.a_width < toppanel.maxwidth - toppanel.maxwidth / 20) {
                    food.count -= 1;
                    player.relaxing = false;
                    player.issleeping = false;
                    toppanel.time.timespeed = 0.3f;
                    if (toppanel.a_width <= toppanel.maxwidth)
                        toppanel.a_width += toppanel.maxwidth / 8;
                } else {
                    error.begin = true;
                    error1 = "You don't want to eat";
                }
            } else {
                error.begin = true;
                error1 = "You don't have food";
            }
            player.eat.touched = false;
        }
    }

    public void sleep() {
        if (player.athome) {
            player.sleep.ontouch(player);
        }
        if (player.sleep.touched) {
            if (toppanel.s_width < toppanel.maxwidth - toppanel.maxwidth / 15) {
                player.relaxing = false;
                player.sleep.touched = false;
                player.issleeping = true;
            } else {
                player.sleep.touched = false;
                error.begin = true;
                error1 = "You don't want to sleep";
                player.issleeping = false;
            }
        }
    }

    public void relax() {
        if (player.athome) {
            player.relax.ontouch(player);
        }
        if (player.relax.touched) {
            player.issleeping = false;
            player.relax.touched = false;
            player.relaxing = true;
        }
    }

    public void smokeBench() {
        for (int i = 0; i < benches.size(); i++) {
            if (benches.get(i).varExists)
                if (!(player.position.x + player.width < benches.get(i).x || player.position.x > benches.get(i).x + benches.get(i).width)) {
                    benches.get(i).smoke.ontouch(player);
                }
            if (benches.get(i).smoke.touched) {
                benches.get(i).smoke.touched = false;
                benches.get(i).varExists = false;
                arrow.previous = "middle";
                player.issmoking = true;
                toppanel.c_width += toppanel.maxwidth / 20;
                player.movingRight = false;
                player.movingLeft = false;
            }
        }
    }

    public void smoke() {
        if (player.varExist && !player.withFood) {
            player.smoke.ontouch(player);
        }
        if (market.varExists) {
            market.smoke.ontouch(player);
        }
        if (cafe.varExists) {
            cafe.smoke.ontouch(player);
        }
        if (fastFood.varExists) {
            fastFood.smoke.ontouch(player);
        }
        if (school.varExists)
            school.smoke.ontouch(player);
        if (home.varExists)
            home.smoke.ontouch(player);
        if (player.smoke.touched || market.smoke.touched || cafe.smoke.touched || fastFood.smoke.touched || home.smoke.touched || school.smoke.touched) {
            home.smoke.touched = false;
            school.smoke.touched = false;
            school.varExists = false;
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).varExist = false;
            }
            home.varExists = false;
            player.smoke.touched = false;
            player.walking_r = false;
            player.walking_l = false;
            player.runningL = false;
            player.runningR = false;
            market.smoke.touched = false;
            fastFood.smoke.touched = false;
            cafe.smoke.touched = false;
            player.varExist = false;
            market.varExists = false;
            fastFood.varExists = false;
            cafe.varExists = false;
            arrow.previous = "middle";
            player.issmoking = true;
            toppanel.c_width += toppanel.maxwidth / 20;
            player.movingRight = false;
            player.movingLeft = false;
        }
    }

    public void goFastFood() {
        if (fastFood.varExists) {
            fastFood.go1.ontouch(player);
        }
        if (fastFood.go1.touched || fastFood.go.touched) {
            fastFood.varExists = false;
            player.walking_r = false;
            player.walking_l = false;
            player.runningR = false;
            player.runningL = false;
            player.movingRight = false;
            player.movingLeft = false;
            player.speed = 0;
            player.speed1 = 0;
            if (!variables.moving_ff) {
                arrow.previous = "middle";
                variables.moving_ff = true;
            }
            if (arrow.previous.equals("middle")) {
                if (player.position.x < fastFood.x + fastFood.width / 2) {
//                    player.walking_r=false;
//                    player.walking_l=false;
                    arrow.previous = "right";
                    arrow.change = false;
                } else {
//                    player.walking_r=false;
//                    player.walking_l=false;
                    arrow.previous = "left";
                    arrow.change = false;
                }
            }
//            System.out.println("ololol");
            if (player.reachedMarket(fastFood.x, fastFood.width)) {
//                System.out.println(player.position.x);
                toppanel.time.timespeed = 0.3f;
                player.atFastFood = true;
                arrow.previous = "middle";
                player.movingRight = false;
                player.movingLeft = false;
                fastFood.varExists = false;
                market.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                cafe.varExists = false;
                fastFood.varExists = false;
                school.varExists = false;
                home.varExists = false;
                fastFood.go.touched = false;
                fastFood.go1.touched = false;
                variables.moving_ff = false;
            }
        }

    }

    public void outTaxi() {
        if (player.inBus) {
            cars.get(player.busNumber).go_out.ontouch(player);
            if (cars.get(player.busNumber).go_out.touched) {
                make_ontouch = false;
                Var_False();
                toppanel.money.money -= player.payment;
                toppanel.minusMoney = player.payment;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        toppanel.minusMoney = 0;
                    }
                }, 0.7f);
                player.inBus = false;
                cars.get(player.busNumber).varExist = false;
                cars.get(player.busNumber).go_out.touched = false;
                player.bus_index = 0;
                player.busNumber = 0;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        make_ontouch = true;
                    }
                }, 0.5f);
            }
            if (cars.get(player.busNumber).type == 1)
                if (cars.get(player.busNumber).x + cars.get(player.busNumber).width / 2 >= policeDep.x + policeDep.width / 4) {
                    toppanel.money.money -= player.payment;
                    toppanel.minusMoney = player.payment;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            toppanel.minusMoney = 0;
                        }
                    }, 0.7f);
                    player.inBus = false;
                    cars.get(player.busNumber).varExist = false;
                    cars.get(player.busNumber).go_out.touched = false;
                    player.bus_index = 0;
                    player.busNumber = 0;
                }
            if (cars.get(player.busNumber).type == 2) {
                if (cars.get(player.busNumber).x <= -Gdx.graphics.getWidth() / 3 + Gdx.graphics.getWidth() / 2) {
                    toppanel.money.money -= player.payment;
                    toppanel.money.y1 = cars.get(player.busNumber).y + cars.get(player.busNumber).height / 2;
                    toppanel.money.x1 = cars.get(player.busNumber).x + cars.get(player.busNumber).width / 2;
                    toppanel.minusMoney = player.payment;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            toppanel.minusMoney = 0;
                        }
                    }, 1.5f);
                    player.inBus = false;
                    cars.get(player.busNumber).varExist = false;
                    cars.get(player.busNumber).go_out.touched = false;
                    player.bus_index = 0;
                    player.busNumber = 0;
                }
            }
        }
    }

    public void outTaxi1() {
        if (player.inBus) {
            toppanel.money.y1 = cars.get(player.busNumber).y + cars.get(player.busNumber).height / 2;
            toppanel.money.x1 = cars.get(player.busNumber).x + cars.get(player.busNumber).width / 2;
            toppanel.minusMoney = player.payment;
            toppanel.money.money -= player.payment;
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    toppanel.minusMoney = 0;
                }
            }, 0.7f);
            player.inBus = false;
            cars.get(player.busNumber).varExist = false;
            cars.get(player.busNumber).go_out.touched = false;
            player.bus_index = 0;
            player.busNumber = 0;
            if (cars.get(player.busNumber).type == 1)
                if (cars.get(player.busNumber).x + cars.get(player.busNumber).width / 2 >= policeDep.x + policeDep.width / 4) {
                    player.inBus = false;
                    cars.get(player.busNumber).varExist = false;
                    cars.get(player.busNumber).go_out.touched = false;
                    player.bus_index = 0;
                    player.busNumber = 0;
                }
            if (cars.get(player.busNumber).type == 2) {
                if (cars.get(player.busNumber).x <= -Gdx.graphics.getWidth() / 3 + Gdx.graphics.getWidth() / 2) {
                    player.inBus = false;
                }
            }
        }
    }

    public void inTaxi(Car car) {
        if (!player.atcafe && !player.inHospital && !player.atFastFood && !player.athome && !player.atmarket && !player.atschool && !player.inDep && !player.inPoliceCar && !player.stealingFF && !player.stealingMarket && !player.stealingCafe)
            if (car != null) {
                if (car.type == 1)
                    if (car.x + car.width / 2 <= policeDep.x + policeDep.width / 4) {
                        if (toppanel.money.money >= 2) {
                            player.walking_r = false;
                            player.walking_l = false;
                            player.runningR = false;
                            player.runningL = false;
                            player.movingRight = false;
                            player.movingLeft = false;
                            player.speed = 0;
                            player.speed1 = 0;
                            Var_False();
                            player.inBus = true;
                            player.bus_index = car.car_index;
                        } else {
                            error.begin = true;
                            error1 = "You don't have enough money";
                        }
                    } else {
                        error.begin = true;
                        error1 = "You can't go there";
                    }
                if (car.type == 2)
                    if (car.x >= -Gdx.graphics.getWidth() * 3 + Gdx.graphics.getWidth() / 2) {
                        player.walking_r = false;
                        player.walking_l = false;
                        player.runningR = false;
                        player.runningL = false;
                        player.movingRight = false;
                        player.movingLeft = false;
                        player.speed = 0;
                        player.speed1 = 0;
                        Var_False();
                        player.inBus = true;
                        player.bus_index = car.car_index;
                    } else {
                        error.begin = true;
                        error1 = "You can't go there";
                    }
            }
    }

    public void eat1() {
        if (player.atFastFood) {
            player.Eat1.ontouch(player);
        }
        if (player.Eat1.touched) {
            player.Eat1.touched = false;
//            player.withFood = true;
            if (toppanel.money.money >= 2) {
                if (toppanel.a_width < toppanel.maxwidth - toppanel.maxwidth / 20) {
                    toppanel.money.money -= 2;
                    toppanel.c_width += toppanel.maxwidth / 30;
                    toppanel.a_width += toppanel.maxwidth / 15;
                    toppanel.h_width -= toppanel.maxwidth / 30;
                    error1 = null;
                    toppanel.money.y1 = fastFood.y + fastFood.height / 2;
                    toppanel.money.x1 = fastFood.x + fastFood.width / 2;
                    toppanel.minusMoney = 2;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            toppanel.minusMoney = 0;
                        }
                    }, 0.5f);
                } else {
                    error.begin = true;
                    error1 = "You don't want to eat";
                }
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void eat2() {
        if (player.atFastFood) {
            player.Eat2.ontouch(player);
        }
        if (player.Eat2.touched) {
            player.Eat2.touched = false;
//            player.withFood = true;
            if (toppanel.money.money >= 6) {
                if (toppanel.a_width < toppanel.maxwidth - toppanel.maxwidth / 20) {
                    toppanel.money.money -= 6;
                    toppanel.c_width += toppanel.maxwidth / 25;
                    toppanel.a_width += toppanel.maxwidth / 10;
                    toppanel.h_width -= toppanel.maxwidth / 25;
                    toppanel.money.y1 = fastFood.y + fastFood.height / 2;
                    toppanel.money.x1 = fastFood.x + fastFood.width / 2;
                    toppanel.minusMoney = 6;
                    error1 = null;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            toppanel.minusMoney = 0;
                        }
                    }, 0.5f);
                } else {
                    error.begin = true;
                    error1 = "You don't want to eat";
                }
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void eat3() {
        if (player.atFastFood) {
            player.Eat3.ontouch(player);
        }
        if (player.Eat3.touched) {
            player.Eat3.touched = false;
//            player.withFood = true;
            if (toppanel.money.money >= 10) {
                if (toppanel.a_width < toppanel.maxwidth - toppanel.maxwidth / 20) {
                    toppanel.money.money -= 10;
                    toppanel.c_width += toppanel.maxwidth / 20;
                    toppanel.a_width += toppanel.maxwidth / 2;
                    toppanel.h_width -= toppanel.maxwidth / 20;
                    toppanel.money.y1 = fastFood.y + fastFood.height / 2;
                    toppanel.money.x1 = fastFood.x + fastFood.width / 2;
                    toppanel.minusMoney = 10;
                    error1 = null;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            toppanel.minusMoney = 0;
                        }
                    }, 0.5f);
                } else {
                    error.begin = true;
                    error1 = "You don't want to eat";
                }
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void goSchool() {
        if (school.varExists) {
            school.go1.ontouch(player);
        }
        if (school.go.touched || school.go1.touched) {
            if (!(toppanel.time.day.equals("Sun") || toppanel.time.day.equals("Sat"))) {
                if (toppanel.time.hour >= 8 && toppanel.time.hour <= 13) {
                    school.varExists = false;
                    player.walking_r = false;
                    player.walking_l = false;
                    player.runningR = false;
                    player.runningL = false;
                    player.movingRight = false;
                    player.movingLeft = false;
                    player.speed = 0;
                    player.speed1 = 0;
                    if (!variables.moving_school) {
                        arrow.previous = "middle";
                        variables.moving_school = true;
                    }
                    if (arrow.previous.equals("middle")) {
                        if (player.position.x < school.position.x + school.width / 2 - school.width / 12) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                            arrow.previous = "right";
                            arrow.change = false;
//                System.out.println("koko2");
                        } else {
//                    player.walking_r=false;
//                    player.walking_l=false;
                            arrow.previous = "left";
                            arrow.change = false;
                        }
                    }
                    if (player.reachedSchool(school.position.x, school.width)) {
//                System.out.println("koko3");
                        toppanel.time.timespeed = 0.3f;
                        player.atschool = true;
                        arrow.previous = "middle";
                        home.varExists = false;
                        cafe.varExists = false;
                        market.varExists = false;
                        fastFood.varExists = false;
                        school.varExists = false;
                        for (int i = 0; i < cars.size(); i++) {
                            cars.get(i).varExist = false;
                        }
                        school.go.touched = false;
                        school.go1.touched = false;
                        variables.moving_ff = false;
//                zoom();
                    }
                } else {
                    error.begin = true;
                    error1 = "It's not time to go to university,come at 8:00 - 14:00";
                    school.varExists = false;
                    school.go.touched = false;
                    school.go1.touched = false;
                }
            } else {
                error.begin = true;
                error1 = "It's day off";
                school.varExists = false;
                school.go.touched = false;
                school.go1.touched = false;
            }

        }
    }

    public void stealMarket() {
        if (market.varExists) {

            market.Robb1.ontouch(player);

        }
        if (market.Robb.touched || market.Robb1.touched) {
            if (!market.stealed) {
                market.varExists = false;
                player.walking_r = false;
                player.walking_l = false;
                player.runningR = false;
                player.runningL = false;
                player.movingRight = false;
                player.movingLeft = false;
                player.speed = 0;
                player.speed1 = 0;
                if (!variables.moving_market) {
                    arrow.previous = "middle";
                    direction = "middle";
                    variables.moving_market = true;
                }
                if (arrow.previous.equals("middle")) {
                    if (player.position.x < market.x + market.width / 2) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingRight = true;
                        arrow.previous = "right";
                        arrow.change = false;
//                System.out.println("koko2");
                    } else {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingLeft = true;
                        arrow.previous = "left";
                        arrow.change = false;
                    }
                }
                if (player.reachedMarket(market.x, market.width)) {
//                System.out.println("koko3");
                    toppanel.time.timespeed = 0.3f;
                    player.stealingMarket = true;
                    arrow.previous = "middle";
                    player.movingRight = false;
                    player.movingLeft = false;
                    market.varExists = false;
                    market.varExists = false;
                    cafe.varExists = false;
                    for (int i = 0; i < cars.size(); i++) {
                        cars.get(i).varExist = false;
                    }
                    fastFood.varExists = false;
                    school.varExists = false;
                    home.varExists = false;
                    market.Robb.touched = false;
                    market.Robb1.touched = false;
                    market.stealed = true;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            market.stealed = false;
                        }
                    }, 240f);
//                zoom();

                }
            } else {
                market.Robb.touched = market.Robb1.touched = false;
                error1 = "You have recently robbed market,try later!";
                error.begin = true;
            }
        }
    }

    public void jobMarket() {
        if (market.varExists) {
            market.job1.ontouch(player);
        }
        if (market.job.touched || market.job1.touched) {
            market.varExists = false;
            player.walking_r = false;
            player.walking_l = false;
            player.runningR = false;
            player.runningL = false;
            player.movingRight = false;
            player.movingLeft = false;
            player.speed = 0;
            player.speed1 = 0;
            if (!variables.moving_market) {
                arrow.previous = "middle";
                direction = "middle";
                variables.moving_market = true;
            }
            if (arrow.previous.equals("middle")) {
                if (player.position.x < market.x + market.width / 2) {
                    player.movingRight = true;
                    arrow.previous = "right";
                    arrow.change = false;
                } else {
                    player.movingLeft = true;
                    arrow.previous = "left";
                    arrow.change = false;
                }
            }
            if (player.reachedMarket(market.x, market.width)) {
                if (market.jobs.size() != 0) {
                    market.drawJobs = true;
                } else {
                    situation = 11;
                    Notification.exists = true;
                    Notification.exists1 = true;
                    pause();
                }
                arrow.previous = "middle";
                player.movingRight = false;
                player.movingLeft = false;
                market.varExists = false;
                market.varExists = false;
                cafe.varExists = false;
                fastFood.varExists = false;
                school.varExists = false;
                home.varExists = false;
                market.job.touched = false;
                market.job1.touched = false;
            }
        }
    }

    public void jobCafe() {
        if (cafe.varExists) {
            cafe.job1.ontouch(player);
        }
        if (cafe.job.touched || cafe.job1.touched) {
            cafe.varExists = false;
            player.walking_r = false;
            player.walking_l = false;
            player.runningR = false;
            player.runningL = false;
            player.movingRight = false;
            player.movingLeft = false;
            player.speed = 0;
            player.speed1 = 0;
            if (!variables.moving_cafe) {
                arrow.previous = "middle";
                direction = "middle";
                variables.moving_cafe = true;
            }
            if (arrow.previous.equals("middle")) {
                if (player.position.x < cafe.x + cafe.width / 2) {
                    player.movingRight = true;
                    arrow.previous = "right";
                    arrow.change = false;
                } else {
                    player.movingLeft = true;
                    arrow.previous = "left";
                    arrow.change = false;
                }
            }
            if (player.reachedCafe(cafe.x, cafe.width)) {
                if (cafe.jobs.size() != 0) {
                    cafe.drawJobs = true;
                } else {
                    situation = 11;
                    Notification.exists = true;
                    Notification.exists1 = true;
                    pause();
                }
                arrow.previous = "middle";
                player.movingRight = false;
                player.movingLeft = false;
                market.varExists = false;
                cafe.varExists = false;
                fastFood.varExists = false;
                school.varExists = false;
                home.varExists = false;
                cafe.job.touched = false;
                cafe.job1.touched = false;
            }
        }
    }

    public void heal1() {
        if (hospital.varExists) {
            hospital.doctor.ontouch(player);
        }
        if (hospital.doctor.touched) {
            if (toppanel.money.money >= 20) {
                hospital.varExists = false;
                player.walking_r = false;
                player.walking_l = false;
                player.runningR = false;
                player.runningL = false;
                player.movingRight = false;
                player.movingLeft = false;
                player.speed = 0;
                player.speed1 = 0;
                if (!variables.moving_hospital) {
                    arrow.previous = "middle";
                    variables.moving_hospital = true;
                }
                if (arrow.previous.equals("middle")) {
                    if (player.position.x < hospital.position.x + hospital.width / 2) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingRight = true;
                        arrow.previous = "right";
                        arrow.change = false;
//                System.out.println("koko2");
                    } else {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingLeft = true;
                        arrow.previous = "left";
                        arrow.change = false;
                    }
                }
                if (player.reachedSchool(hospital.position.x, hospital.width)) {
//                System.out.println("koko3");
                    toppanel.time.timespeed = 0.3f;
                    player.inHospital = true;
                    player.heal1 = true;
                    arrow.previous = "middle";
                    player.movingRight = false;
                    player.movingLeft = false;
                    hospital.doctor.touched = false;
//                    System.out.println(player.stealingFF + " " + player.inPoliceCar + " " + player.atFastFood);
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            player.inHospital = false;
                            player.heal1 = false;
                        }
                    }, 2.5f);
                    for (int i = 0; i < 6; i++) {
                        hearts.get(i).boom(hospital.height / 10);
                    }
//                zoom();

                }
            } else {
                hospital.doctor.touched = false;
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void heal2() {
        if (hospital.varExists) {
            hospital.part.ontouch(player);
        }
        if (hospital.part.touched) {
            if (toppanel.money.money >= 50) {
                hospital.varExists = false;
                player.walking_r = false;
                player.walking_l = false;
                player.runningR = false;
                player.runningL = false;
                player.movingRight = false;
                player.movingLeft = false;
                player.speed = 0;
                player.speed1 = 0;
                if (!variables.moving_hospital) {
                    arrow.previous = "middle";
                    variables.moving_hospital = true;
                }
                if (arrow.previous.equals("middle")) {
                    if (player.position.x < hospital.position.x + hospital.width / 2) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingRight = true;
                        arrow.previous = "right";
                        arrow.change = false;
//                System.out.println("koko2");
                    } else {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingLeft = true;
                        arrow.previous = "left";
                        arrow.change = false;
                    }
                }
                if (player.reachedSchool(hospital.position.x, hospital.width)) {
//                System.out.println("koko3");
                    toppanel.time.timespeed = 0.3f;
                    player.inHospital = true;
                    player.heal2 = true;
                    arrow.previous = "middle";
                    player.movingRight = false;
                    player.movingLeft = false;
                    hospital.part.touched = false;
//                    System.out.println(player.stealingFF + " " + player.inPoliceCar + " " + player.atFastFood);
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            player.inHospital = false;
                            player.heal2 = false;
                        }
                    }, 2.5f);
                    for (int i = 0; i < 6; i++) {
                        hearts.get(i).boom(hospital.height / 8);
                    }
//                zoom();

                }
            } else {
                hospital.part.touched = false;
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void heal3() {
        if (hospital.varExists) {
            hospital.full.ontouch(player);
        }
        if (hospital.full.touched) {
            if (toppanel.money.money >= 100) {
                hospital.varExists = false;
                player.walking_r = false;
                player.walking_l = false;
                player.runningR = false;
                player.runningL = false;
                player.movingRight = false;
                player.movingLeft = false;
                player.speed = 0;
                player.speed1 = 0;
                if (!variables.moving_hospital) {
                    arrow.previous = "middle";
                    variables.moving_hospital = true;
                }
                if (arrow.previous.equals("middle")) {
                    if (player.position.x < hospital.position.x + hospital.width / 2) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingRight = true;
                        arrow.previous = "right";
                        arrow.change = false;
//                System.out.println("koko2");
                    } else {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingLeft = true;
                        arrow.previous = "left";
                        arrow.change = false;
                    }
                }
                if (player.reachedSchool(hospital.position.x, hospital.width)) {
//                System.out.println("koko3");
                    toppanel.time.timespeed = 0.3f;
                    player.inHospital = true;
                    player.heal3 = true;
                    arrow.previous = "middle";
                    player.movingRight = false;
                    player.movingLeft = false;
                    hospital.full.touched = false;
//                    System.out.println(player.stealingFF + " " + player.inPoliceCar + " " + player.atFastFood);
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            player.inHospital = false;
                            player.heal3 = false;
                        }
                    }, 2.5f);
                    for (int i = 0; i < 6; i++) {
                        hearts.get(i).boom(hospital.height / 7);
                    }
//                zoom();

                }
            } else {
                hospital.full.touched = false;
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void stealFF() {
        if (fastFood.varExists) {

            fastFood.Robb1.ontouch(player);

        }
        if (fastFood.Robb.touched || fastFood.Robb1.touched) {
            if (!fastFood.stealed) {
                fastFood.varExists = false;
                player.walking_r = false;
                player.walking_l = false;
                player.runningR = false;
                player.runningL = false;
                player.movingRight = false;
                player.movingLeft = false;
                player.speed = 0;
                player.speed1 = 0;
                if (!variables.moving_ff) {
                    arrow.previous = "middle";
                    variables.moving_ff = true;
                }
                if (arrow.previous.equals("middle")) {
                    if (player.position.x < fastFood.x + fastFood.width / 2) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingRight = true;
                        arrow.previous = "right";
                        arrow.change = false;
//                System.out.println("koko2");
                    } else {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingLeft = true;
                        arrow.previous = "left";
                        arrow.change = false;
                    }
                }
                if (player.reachedMarket(fastFood.x, fastFood.width)) {
//                System.out.println("koko3");
                    toppanel.time.timespeed = 0.3f;
                    player.stealingFF = true;
                    arrow.previous = "middle";
                    player.movingRight = false;
                    player.movingLeft = false;
                    fastFood.varExists = false;
                    fastFood.Robb.touched = false;
                    fastFood.Robb1.touched = false;
                    fastFood.stealed = true;
//                    System.out.println(player.stealingFF + " " + player.inPoliceCar + " " + player.atFastFood);
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            fastFood.stealed = false;
                        }
                    }, 240f);
//                zoom();

                }
            } else {
                fastFood.Robb.touched = fastFood.Robb1.touched = false;
                error1 = "You have recently robbed fast food cafe,try later!";
                error.begin = true;
            }
        }
    }

    public void stealCafe() {
        if (cafe.varExists) {
            cafe.Robb1.ontouch(player);

        }
        if (cafe.Robb.touched || cafe.Robb1.touched) {
            if (!cafe.stealed) {
                cafe.varExists = false;
                player.walking_r = false;
                player.walking_l = false;
                player.runningR = false;
                player.runningL = false;
                player.movingRight = false;
                player.movingLeft = false;
                player.speed = 0;
                player.speed1 = 0;
                if (!variables.moving_cafe) {
                    arrow.previous = "middle";
                    direction = "middle";
                    variables.moving_cafe = true;
                }
                if (arrow.previous.equals("middle")) {
                    if (player.position.x < cafe.x + cafe.width / 2) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingRight = true;
                        arrow.previous = "right";
                        arrow.change = false;
//                System.out.println("koko2");
                    } else {
//                    player.walking_r = false;
//                    player.walking_l = false;
                        player.movingLeft = true;
                        arrow.previous = "left";
                        arrow.change = false;
                    }
                }
                if (player.reachedCafe(cafe.x, cafe.width)) {
//                System.out.println("koko3");
                    toppanel.time.timespeed = 0.3f;
                    player.stealingCafe = true;
                    arrow.previous = "middle";
                    player.movingRight = false;
                    player.movingLeft = false;
                    cafe.varExists = false;
//                    cafe.varExists = false;
                    home.varExists = false;
                    for (int i = 0; i < cars.size(); i++) {
                        cars.get(i).varExist = false;
                    }
                    market.varExists = false;
                    fastFood.varExists = false;
                    school.varExists = false;
                    cafe.Robb.touched = false;
                    cafe.Robb1.touched = false;
                    cafe.stealed = true;
                    variables.moving_cafe = false;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            cafe.stealed = false;
                        }
                    }, 240f);
//                zoom();

                }
            } else {
                cafe.Robb.touched = cafe.Robb1.touched = false;
                error1 = "You have recently robbed cafe,try later!";
                error.begin = true;
            }
        }
    }

    public void goCafe() {
        if (cafe.varExists) {
            cafe.go1.ontouch(player);
        }
        if (cafe.go.touched || cafe.go1.touched) {
//            System.out.println("koko1");
            player.walking_r = false;
            player.walking_l = false;
            player.runningR = false;
            player.runningL = false;
            player.movingRight = false;
            player.movingLeft = false;
            player.speed = 0;
            player.speed1 = 0;
            if (!variables.moving_cafe) {
                arrow.previous = "middle";
                direction = "middle";
                variables.moving_cafe = true;
            }
            if (arrow.previous.equals("middle")) {
                if (player.position.x < cafe.x + cafe.width / 4) {
                    arrow.previous = "right";
                    cafe.varExists = false;
                    ;
                    arrow.change = false;
                } else {
//                    System.out.println("zashel");
                    arrow.previous = "left";
                    cafe.varExists = false;
                    arrow.change = false;
                }
            }
            if (player.reachedCafe(cafe.x, cafe.width)) {
//                System.out.println("koko3");
                toppanel.time.timespeed = 0.3f;
                player.atcafe = true;
                arrow.previous = "middle";
                cafe.varExists = false;
                home.varExists = false;
                market.varExists = false;
                fastFood.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                school.varExists = false;
                cafe.go.touched = false;
                cafe.go1.touched = false;
                variables.moving_cafe = false;
//                zoom();
            }
        }
    }

    public void outCafe() {
        if (player.atcafe) {
            player.GoOut1.ontouch(player);
        }
        if (player.GoOut1.touched) {
//            unzoom();
            player.atcafe = false;
            cafe.varExists = false;
            player.GoOut1.touched = false;
            player.foodBought = 6;
        }
    }

    public void buyCoffee() {
        if (player.atcafe) {
            player.Buy1.ontouch(player);
        }
        if (player.Buy1.touched) {
            player.movingLeft = false;
            player.movingRight = false;
            player.Buy1.touched = false;
            player.atcafe = false;
            if (toppanel.money.money >= 2) {
                player.drinkingcoffee = true;
                toppanel.c_width += toppanel.maxwidth / 40;
//                System.out.println(player.drinkingcoffee);
                toppanel.money.money -= 2;
                toppanel.s_width += toppanel.maxwidth / 15;
                toppanel.money.y1 = cafe.y + cafe.height / 2;
                toppanel.money.x1 = cafe.x + cafe.width / 2;
                toppanel.minusMoney = 2;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        toppanel.minusMoney = 0;
                    }
                }, 1.5f);
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void buyFood1() {
        if (player.atmarket) {
            player.Buy.ontouch(player);
        }
        if (player.Buy.touched) {
            player.Buy.touched = false;
            player.atmarket = false;
            if (toppanel.money.money >= 5) {
                player.withFood = true;
                player.foodBought = 7;
                toppanel.money.money -= 5;
                toppanel.money.y1 = market.y + market.height / 2;
                toppanel.money.x1 = market.x + market.width / 2;
                toppanel.minusMoney = 5;
                error1 = "You have to carry food to the house";
                error.begin = true;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        toppanel.minusMoney = 0;
                    }
                }, 1.5f);
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void buyFood2() {
        if (player.atmarket) {
            player.Buy2.ontouch(player);
        }
        if (player.Buy2.touched) {
            player.Buy2.touched = false;
            player.atmarket = false;
            if (toppanel.money.money >= 15) {
                player.withFood = true;
                player.foodBought = 16;
                toppanel.money.money -= 15;
                toppanel.money.y1 = market.y + market.height / 2;
                toppanel.money.x1 = market.x + market.width / 2;
                toppanel.minusMoney = 15;
                error1 = "You have to carry food to the house";
                error.begin = true;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        toppanel.minusMoney = 0;
                    }
                }, 1.5f);
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void buyFood3() {
        if (player.atmarket) {
            player.Buy3.ontouch(player);
        }
        if (player.Buy3.touched) {
            player.Buy3.touched = false;
            player.atmarket = false;
            if (toppanel.money.money >= 50) {
                player.withFood = true;
                player.foodBought = 30;
                toppanel.money.money -= 50;
                toppanel.money.y1 = market.y + market.height / 2;
                toppanel.money.x1 = market.x + market.width / 2;
                toppanel.minusMoney = 50;
                error1 = "You have to carry food to the house";
                error.begin = true;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        toppanel.minusMoney = 0;
                    }
                }, 1.5f);
            } else {
                error.begin = true;
                error1 = "You don't have enough money";
            }
        }
    }

    public void jobUniver() {
        if (school.varExists) {

            school.job1.ontouch(player);
        }
        if (school.job.touched || school.job1.touched) {
            if (!(toppanel.time.day.equals("Sun") || toppanel.time.day.equals("Sat"))) {
                if (toppanel.time.hour >= 8 && toppanel.time.hour <= 18) {
                    if (player.age >= 23) {
                        school.varExists = false;
                        player.walking_r = false;
                        player.walking_l = false;
                        player.runningR = false;
                        player.runningL = false;
                        player.movingRight = false;
                        player.movingLeft = false;
                        player.speed = 0;
                        player.speed1 = 0;
                        if (!variables.moving_school) {
                            arrow.previous = "middle";
                            variables.moving_school = true;
                        }
                        if (arrow.previous.equals("middle")) {
                            if (player.position.x < school.position.x + school.width / 2 - school.width / 12) {
//                    player.walking_r = false;
//                    player.walking_l = false;
                                arrow.previous = "right";
                                arrow.change = false;
//                System.out.println("koko2");
                            } else {
//                    player.walking_r=false;
//                    player.walking_l=false;
                                arrow.previous = "left";
                                arrow.change = false;
                            }
                        }
                        if (player.reachedSchool(school.position.x, school.width)) {
//                System.out.println("koko3");
//                        toppanel.time.timespeed = 0.3f;
                            player.atschool = true;
                            arrow.previous = "middle";
                            school.varExists = false;
                            school.go.touched = false;
                            school.go1.touched = false;
                            home.varExists = false;
                            cafe.varExists = false;
                            market.varExists = false;
                            fastFood.varExists = false;
                            school.varExists = false;
                            for (int i = 0; i < cars.size(); i++) {
                                cars.get(i).varExist = false;
                            }
                            variables.moving_school = false;
//                zoom();
                        }
                    } else {
                        error.begin = true;
                        error1 = "You are to young to work here";
                        school.varExists = false;
                        school.job.touched = false;
                        school.job1.touched = false;
                    }
                } else {
                    error.begin = true;
                    error1 = "University not working,come at 8:00 - 18:00";
                    school.varExists = false;
                    school.job.touched = false;
                    school.job1.touched = false;
                }
            } else {
                error.begin = true;
                error1 = "It's day off";
                school.varExists = false;
                school.job.touched = false;
                school.job1.touched = false;
            }

        }
    }

    public void sit() {
        for (int i = 0; i < benches.size(); i++) {
            if (benches.get(i).varExists) {
                if (player.position.x + player.width < benches.get(i).x || player.position.x > benches.get(i).x + benches.get(i).width) {
                    benches.get(i).sit.ontouch(player);
                } else {
                    benches.get(i).sit1.ontouch(player);
                }
            }
            if (benches.get(i).sit.touched || benches.get(i).sit1.touched) {
                if (player.position.x + player.width / 2 < benches.get(i).x + benches.get(i).width / 2) {
                    benches.get(i).varExists = false;
//                    player.walking_r = false;
//                    player.walking_l = false;
                    player.movingRight = true;
                    arrow.previous = "right";
                } else if (player.position.x + player.width / 2 > benches.get(i).x + benches.get(i).width / 2) {
                    benches.get(i).varExists = false;
//                    player.walking_r = false;
//                    player.walking_l = false;
                    player.movingLeft = true;
                    arrow.previous = "left";
                }
                if (player.reachedBench(benches.get(i))) {
                    player.position.y = benches.get(i).y - benches.get(i).height / 6;
                    arrow.previous = "middle";
                    player.movingLeft = false;
                    player.movingRight = false;
                    benches.get(i).sit.touched = false;
                    benches.get(i).sit1.touched = false;
                    player.sitting1 = true;
                    player.sit();
                }
            }
        }
    }

    public void goMarket() {
        if (market.varExists) {
            market.go1.ontouch(player);
        }
        if (market.go.touched || market.go1.touched) {
            market.varExists = false;
            player.walking_r = false;
            player.walking_l = false;
            player.runningR = false;
            player.runningL = false;
            player.movingRight = false;
            player.movingLeft = false;
            player.speed = 0;
            player.speed1 = 0;
            if (!variables.moving_market) {
                arrow.previous = "middle";
                direction = "middle";
                variables.moving_market = true;
            }
            if (arrow.previous.equals("middle")) {
                if (player.position.x < market.x + market.width / 2) {
                    arrow.previous = "right";
                    arrow.change = false;
                } else {
                    arrow.previous = "left";
                    arrow.change = false;
                }
            }
            if (player.reachedMarket(market.x, market.width)) {
                toppanel.time.timespeed = 0.3f;
                player.atmarket = true;
                arrow.previous = "middle";
                player.movingRight = false;
                player.movingLeft = false;
                market.varExists = false;
                cafe.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                fastFood.varExists = false;
                school.varExists = false;
                home.varExists = false;
                market.go.touched = false;
                market.go1.touched = false;
                variables.moving_market = false;
            }
        }
    }

    public void outMarket() {
        if (player.atmarket) {
            player.GoOut.ontouch(player);
        }
        if (player.GoOut.touched) {
            player.atmarket = false;
            market.varExists = false;
            player.GoOut.touched = false;

        }
    }

    public void outFF() {
        if (player.atFastFood) {
            player.GoOut2.ontouch(player);
        }
        if (player.GoOut2.touched) {
//            unzoom();
            player.atFastFood = false;
            fastFood.varExists = false;
            player.GoOut2.touched = false;

        }
    }

    public void goHome() {
        if (home.varExists) {
            home.go.ontouch(player);
        }
        if (home.go.touched) {
            home.varExists = false;
            player.walking_r = false;
            player.walking_l = false;
            player.runningR = false;
            player.runningL = false;
            player.movingRight = false;
            player.movingLeft = false;
            player.speed = 0;
            player.speed1 = 0;
            if (!variables.moving_home) {
                arrow.previous = "middle";
                variables.moving_home = true;
            }
//            player.walking_r=false;
//            player.walking_l=false;
            if (arrow.previous.equals("middle")) {
                if (player.position.x > home.position.x + home.width / 10) {
                    arrow.previous = "left";
                    arrow.change = false;
                } else {
                    arrow.previous = "right";
                    arrow.change = false;
                }
            }
//            player.movingLeft = true;
            if (player.reachedHome(home.position.x, home.width)) {
                player.athome = true;
                arrow.previous = "middle";
                home.varExists = false;
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).varExist = false;
                }
                market.varExists = false;
                cafe.varExists = false;
                fastFood.varExists = false;
                school.varExists = false;
                home.go.touched = false;
                home.go1.touched = false;
                player.issleeping = false;
                player.relaxing = false;
                player.movingLeft = false;
                player.movingRight = false;
                variables.moving_home = false;
                food.count += player.foodBought;
                if (food.count > 30) {
                    food.count = 30;
                }
                player.foodBought = 0;
                player.withFood = false;
            }
        }
    }

    public void unpause() {
        if (toppanel.pause) {
            toppanel.pause_menu.ontouch(player.position.x, player.width, player.position.y, arrow);
            if (toppanel.pause_menu.unpause) {
                toppanel.pause = false;
                for (int i = 0; i < peoples.size(); i++) {
                    peoples.get(i).speed = peoples.get(i).basic_speed;
                    peoples.get(i).current = People.val.stay;
                }
                for (int i = 0; i < cars.size(); i++) {
                    cars.get(i).speed = cars.get(i).basic_speed;
                }
                toppanel.time.resume();
                stealing.resume();
                stealing1.resume();
                stealing2.resume();
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        make_ontouch = true;
                    }
                }, 0.1f);
            }
        }
    }

    public void unpause_unlistened() {
        if (!toppanel.pause) {
            for (int i = 0; i < peoples.size(); i++) {
                peoples.get(i).speed = peoples.get(i).basic_speed;
                peoples.get(i).current = People.val.stay;
            }
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).speed = cars.get(i).basic_speed;
            }
            toppanel.time.resume();
            stealing.resume();
            stealing1.resume();
            stealing2.resume();
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    make_ontouch = true;
                }
            }, 0.1f);
        }
    }

    public void outHome() {
        if (player.athome) {
            player.goOut.ontouch(player);
        }
        if (player.goOut.touched) {
            player.athome = false;
            home.varExists = false;
            player.goOut.touched = false;
            player.issleeping = false;
            player.relaxing = false;

        }
    }

    public void inCar1() {
        if (player.varExist) {
            player.internet.ontouch(player);
            if (player.internet.touched) {
                player.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        } else if (market.varExists) {
            market.internet.ontouch(player);
            if (market.internet.touched) {
                market.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        } else if (cafe.varExists) {
            cafe.internet.ontouch(player);
            if (cafe.internet.touched) {
                cafe.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        } else if (school.varExists) {
            school.internet.ontouch(player);
            if (school.internet.touched) {
                school.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        } else if (hospital.varExists) {
            hospital.internet.ontouch(player);
            if (hospital.internet.touched) {
                hospital.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        } else if (fastFood.varExists) {
            fastFood.internet.ontouch(player);
            if (fastFood.internet.touched) {
                fastFood.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        } else if (home.varExists) {
            home.internet.ontouch(player);
            if (home.internet.touched) {
                home.internet.touched = false;
                inTaxi(findTaxiRight());
            }
        }
    }

    public void inCar2() {
        if (player.varExist) {
            player.call.ontouch(player);
            if (player.call.touched) {
                player.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        } else if (market.varExists) {
            market.call.ontouch(player);
            if (market.call.touched) {
                market.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        } else if (cafe.varExists) {
            cafe.call.ontouch(player);
            if (cafe.call.touched) {
                cafe.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        } else if (school.varExists) {
            school.call.ontouch(player);
            if (school.call.touched) {
                school.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        } else if (hospital.varExists) {
            hospital.call.ontouch(player);
            if (hospital.call.touched) {
                hospital.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        } else if (fastFood.varExists) {
            fastFood.call.ontouch(player);
            if (fastFood.call.touched) {
                fastFood.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        } else if (home.varExists) {
            home.call.ontouch(player);
            if (home.call.touched) {
                home.call.touched = false;
                inTaxi(findTaxiLeft());
            }
        }
    }

    public void listen() {
        if (player.athome || player.atmarket) {
            player.varExist = false;
            home.varExists = false;
            market.varExists = false;
        }
//        goBus();
//        outBus();
        unpause();
        inCar2();
        inCar1();
        outTaxi();
        goHome();
        heal1();
        heal2();
        heal3();
        if (!player.withFood) {
            smoke();
//            smokeHome();
            sit();
            smokeBench();


            if (home.onscreen) {
                outHome();
                sleep();
                relax();
                eat();
            }
            if (market.onscreen) {
                jobMarket();
                goMarket();
                outMarket();
                stealMarket();
                buyFood1();
                buyFood2();
                buyFood3();
            }
            if (cafe.onscreen) {
                jobCafe();
                goCafe();
                outCafe();
                buyCoffee();
                stealCafe();

            }
            if (school.onscreen) {
                jobUniver();
                goSchool();
//                smokeUni();
            }
            if (fastFood.onscreen) {
//                smokeFF();
                stealFF();
                goFastFood();
                outFF();
                eat1();
                eat2();
                eat3();
            }

        }
    }

    public void peopleCollision() {
        for (int i = 0; i < peoples.size() - 1; i++) {
            for (int j = i + 1; j < peoples.size(); j++) {
                if (peoples.get(i).x > peoples.get(j).x && peoples.get(i).x < peoples.get(j).x + peoples.get(j).width) {
                    if (!peoples.get(i).taskMade && peoples.get(i).speed < peoples.get(i).maxspeed && !peoples.get(i).issmoking && peoples.get(i).current != peoples.get(i).val.stay) {
                        peoples.get(i).speed *= 1.5;
                        peoples.get(i).backSpeed();
                    } else {
                        if (!peoples.get(j).taskMade && peoples.get(j).speed < peoples.get(j).maxspeed && !peoples.get(j).issmoking && peoples.get(j).current != peoples.get(j).val.stay) {
                            peoples.get(j).speed *= 1.5;
                            peoples.get(j).backSpeed();
                        }
                    }
                }
            }
        }
    }

    public void dispose() {
        batch.dispose();
        for (int i = 0; i < benches.size(); i++) benches.get(i).dispose();
        for (int i = 0; i < bushes.size(); i++) bushes.get(i).dispose();
        for (int i = 0; i < flowers.size(); i++) flowers.get(i).dispose();
        for (int i = 0; i < roads.size(); i++) roads.get(i).dispose();
        for (int i = 0; i < skies.size(); i++) skies.get(i).dispose();
        for (int i = 0; i < trees.size(); i++) trees.get(i).dispose();
        benches.clear();
        bushes.clear();
        flowers.clear();
        roads.clear();
        skies.clear();
        trees.clear();
    }

    public Car findTaxiRight() {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).type == 1) {
                if (cars.get(i).x > -Gdx.graphics.getWidth() * 3 + Gdx.graphics.getWidth() / 3 && cars.get(i).x + cars.get(i).width / 2 >= player.position.x + player.width / 2 - Gdx.graphics.getWidth() / 2 && cars.get(i).x + cars.get(i).width / 2 <= player.position.x + player.width / 2 + Gdx.graphics.getWidth() / 2) {
                    player.busNumber = i;
                    return cars.get(i);
                }
            }
        }
        error.begin = true;
        error1 = "Sorry but there are no cars available";
        return null;
    }

    public Car findTaxiLeft() {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).type == 2) {
                if (cars.get(i).x + cars.get(i).width / 2 >= player.position.x + player.width / 2 - Gdx.graphics.getWidth() / 2 && cars.get(i).x + cars.get(i).width / 2 <= player.position.x + player.width / 2 + Gdx.graphics.getWidth() / 2) {
                    player.busNumber = i;
                    return cars.get(i);
                }


            }
        }
        error.begin = true;
        error1 = "Sorry but there are no cars available";
        return null;
    }

    public void Var_False() {
        home.varExists = false;
        market.varExists = false;
        player.varExist = false;
        cafe.varExists = false;
        for (int i = 0; i < benches.size(); i++) {
            benches.get(i).varExists = false;
        }
        school.varExists = false;
        fastFood.varExists = false;
        player.varExist = false;
    }

    public void pause() {
        direction = "middle";
        arrow.previous = "middle";
        for (int i = 0; i < peoples.size(); i++) {
            peoples.get(i).speed = 0;
            peoples.get(i).current = People.val.stay;
        }
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).speed = 0;
        }
        toppanel.time.stop();
        stealing.stop();
        stealing1.stop();
        stealing2.stop();
        make_ontouch = false;
    }

    public void checkNotice() {
        if (!player.athome) {
            if (!variables.lost_money && timer1.isEmpty()) {
                timer1.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (random.nextInt(100) <= 5) {
                            situation = 10;
                            Notification.exists = true;
                            Notification.exists1 = true;
                            toppanel.money.money -= random.nextInt((int) (Math.abs(toppanel.money.money / 20))) + (int) (Math.abs(toppanel.money.money / 2));
                            toppanel.c_width -= toppanel.maxwidth / 6;
                            variables.lost_money = true;
                        }
                    }
                }, 15f);
                new Timer().scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        variables.lost_money = false;
                    }
                }, 30f);
            }
        }
        if (player.athome) {
            if (!variables.broke_fridge && timer1.isEmpty()) {
                timer1.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (random.nextInt(100) <= 5) {
                            situation = 9;
                            Notification.exists = true;
                            Notification.exists1 = true;
                            toppanel.money.money -= random.nextInt(95) + 5;
                            if (toppanel.money.money < 0)
                                toppanel.money.money = 0;
                            toppanel.c_width -= toppanel.maxwidth / 10;
                            variables.broke_fridge = true;
                            new Timer().scheduleTask(new Timer.Task() {
                                @Override
                                public void run() {
                                    variables.broke_fridge = false;
                                }
                            }, 300f);
                        }
                    }
                }, 3f);
            }
        }
        if (player.atmarket) {
            if (!variables.broke_shop && timer1.isEmpty()) {
                timer1.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (random.nextInt(100) <= 5) {
                            situation = 8;
                            Notification.exists = true;
                            Notification.exists1 = true;
                            toppanel.money.money -= random.nextInt(95) + 5;
                            if (toppanel.money.money < 0)
                                toppanel.money.money = 0;
                            toppanel.c_width -= toppanel.maxwidth / 10;
                            variables.broke_shop = true;
                        } else {
                            new Timer().scheduleTask(new Timer.Task() {
                                @Override
                                public void run() {
                                    variables.broke_shop = false;
                                }
                            }, 25f);
                        }
                    }
                }, 1);
            }
        }
        if (player.stealingFF || player.stealingMarket || player.stealingCafe) {
            if (!variables.safe_worked && timer1.isEmpty())
                timer1.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (random.nextInt(100) <= 10) {
                            variables.safe_worked = true;
                            situation = 6;
                            moneyStolen1 = random.nextInt(500) + 100;
                            moneyStolen += moneyStolen1;
                            Notification.exists = true;
                            Notification.exists1 = true;
                            pause();
                            toppanel.money.money += moneyStolen1;
                            toppanel.c_width += toppanel.maxwidth / 10;
                            moneyStolen1 = 0;
                            new Timer().scheduleTask(new Timer.Task() {
                                @Override
                                public void run() {
                                    variables.safe_worked = false;
                                }
                            }, 900);
                        } else {
                            variables.safe_worked = true;
                            new Timer().scheduleTask(new Timer.Task() {
                                @Override
                                public void run() {
                                    variables.safe_worked = false;
                                }
                            }, 60);
                        }
                    }
                }, 1f);
            if (!variables.shot_worked && timer2.isEmpty())
                timer2.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        if (random.nextInt(100) <= 20) {
                            variables.shot_worked = true;
                            situation = 7;
                            Notification.exists = true;
                            Notification.exists1 = true;
                            pause();
                            toppanel.c_width -= toppanel.maxwidth / 3;
                            toppanel.h_width -= toppanel.maxwidth / 2;
                            new Timer().scheduleTask(new Timer.Task() {
                                @Override
                                public void run() {
                                    variables.safe_worked = false;
                                }
                            }, 180);
                        } else {
                            variables.shot_worked = true;
                            new Timer().scheduleTask(new Timer.Task() {
                                @Override
                                public void run() {
                                    variables.safe_worked = false;
                                }
                            }, 60);
                        }
                    }
                }, 1.5f);
        }
        if (player.isSitting) {
            if (!variables.purse_worked && timer.isEmpty())
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        variables.purse_worked = true;
                        if (random.nextInt(100) <= 5) {
                            situation = 5;
                            moneyStolen = random.nextInt(150) + 5;
                            Notification.exists = true;
                            Notification.exists1 = true;
                            toppanel.money.money += moneyStolen;
                            toppanel.c_width += toppanel.maxwidth / 10;
                        }
                        new Timer().scheduleTask(new Timer.Task() {
                            @Override
                            public void run() {
                                variables.purse_worked = false;
                            }
                        }, 600);
                    }
                }, 2);
        }
        if (Notification.exists == false) {
            if (moneyStolen != 0 && !player.stealingFF && !player.stealingCafe && !player.stealingMarket) {
                situation = 4;
                Notification.exists = true;
                Notification.exists1 = true;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        moneyStolen = 0;
                    }
                }, 10);
            }
            if (!(toppanel.time.day.equals("Sun") || toppanel.time.day.equals("Sat"))) {
                if (toppanel.time.hour == 4 && toppanel.time.minute <= 20) {
                    situation = 3;
                    Notification.exists = true;
                    Notification.exists1 = true;
                } else if (toppanel.a_width <= toppanel.maxwidth / 2 && Notification.exists1 == false) {
                    situation = 0;
                    Notification.exists = true;
                    Notification.exists1 = true;
                } else if (toppanel.h_width <= toppanel.maxwidth / 2 && Notification.exists1 == false) {
                    situation = 1;
                    Notification.exists = true;
                    Notification.exists1 = true;
                } else if (toppanel.s_width <= toppanel.maxwidth / 3 && Notification.exists1 == false) {
                    situation = 2;
                    Notification.exists = true;
                    Notification.exists1 = true;
                }
            } else if (toppanel.a_width <= toppanel.maxwidth / 2 && Notification.exists1 == false) {
                situation = 0;
                Notification.exists = true;
                Notification.exists1 = true;
            } else if (toppanel.h_width <= toppanel.maxwidth / 2 && Notification.exists1 == false) {
                situation = 1;
                Notification.exists = true;
                Notification.exists1 = true;
            } else if (toppanel.s_width <= toppanel.maxwidth / 3 && Notification.exists1 == false) {
                situation = 2;
                Notification.exists = true;
                Notification.exists1 = true;
            }
        }
    }
}