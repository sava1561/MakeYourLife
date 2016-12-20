package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Main;

import java.util.ArrayList;
import java.util.Random;

import Background.Bench;
import Background.Cafe;
import Background.FastFood;
import Background.Market;
import Background.School;
import Background.TopPanel;

/**
 * Created by Sava on 24.03.2016.
 */
public class People {
    public float maxspeed;
    public float basic_speed;
    public boolean taskMade;
    public static PeopleVal val;
    public String previous;
    float sm_time;
    int sm_index;
    public int count;
    public boolean dropping;
    public int age;
    public float x, y, width, height, basic_y;
    public boolean smoker;
    public boolean issmoking, movingCafe, movingMarket, movingBench, sitting, atcafe, atmarket, movingFF, atFF, talking, withFood, free, isSitting,atschool,movingSchool;
    public String name;
    public String gender;
    public float speed;
    public Texture current;
    public boolean movingLeft, movingRight;
    public Timer timer, timer2, timer3;
    int index, index2;
    public Texture texture;
    public static ArrayList<Bench> benches;
    public int rand1;
    public int benchNum;
    public int index_sit;
    public Timer.Task t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17,t18;
    public static Main main;
    public boolean onscreen;
    public String smoke, market, cafe, bench, ff,school;
    public BitmapFont name_1;
    public boolean ismoving;
    public TopPanel panel;
    public People(ArrayList<Bench> benches, final Main main, PeopleVal val,TopPanel panel) {
        this.panel=panel;
        movingSchool=false;
        ismoving = false;
        taskMade = false;
        this.val = val;
        onscreen = false;
        this.main = main;
        count = 0;
        sm_index = 0;
        sm_time = 0.05f;
        timer3 = new Timer();
        isSitting = false;
        index_sit = 0;
        this.benches = benches;
        timer2 = new Timer();
        free = true;
        issmoking = false;
        movingCafe = false;
        movingMarket = false;
        movingBench = false;
        sitting = false;
        atcafe = false;
        atmarket = false;
        movingFF = false;
        atFF = false;
        talking = false;
        movingLeft = movingRight = false;
        withFood = false;
        timer = new Timer();
        if (val.rand.nextInt(1) == 0) {
            current = val.stay;
            gender = "male";
        }
        if(val.rand.nextInt(2)==0){
            smoker=true;
        }else{
            smoker=false;
        }
        age = val.rand.nextInt(15) + 15;
        name = val.nameGenerator.generateManName();
        speed = Gdx.graphics.getWidth() / 340 + val.rand.nextInt(Gdx.graphics.getWidth() / 350) - Gdx.graphics.getWidth() / 700;
        maxspeed = Gdx.graphics.getWidth() / 320;
        basic_speed = speed;
        x = val.rand.nextInt(3 * Gdx.graphics.getWidth()) + Gdx.graphics.getWidth();
        y = Gdx.graphics.getHeight() / 4 - Gdx.graphics.getHeight() / 30 + val.rand.nextInt(Gdx.graphics.getHeight() / 35);
        basic_y = y;
        width = Gdx.graphics.getWidth() / 23 + val.rand.nextInt(Gdx.graphics.getWidth() / 250) - Gdx.graphics.getWidth() / 500;
        texture = new Texture(Gdx.files.internal("background/player.png"));
        height = 8 * (texture.getHeight() * (width / texture.getWidth())) / 11;//3/11
        createTasks();
        walkLeft();
        walkRight();
        benchNum = -1;
        smoke = "smoke";
        ff = "fastfood";
        market = "market";
        cafe = "cafe";
        bench = "bench";
        school="school";
        name_1 = val.generator.generateFont(val.parameter);
//        if (rand.nextBoolean()) {
//            home_x = -200;
//        } else {
//            home_x = 6000;
//        }
    }

    public void createTasks() {
        t1 = new Timer.Task() {
            @Override
            public void run() {
                current = val.sitting2.get(index_sit);
                width = current.getWidth() * (height / current.getHeight());
                index_sit++;
                if (index_sit != val.sitting2.size() - 1) {
                    sit();
                } else {
                    index_sit = 0;
                    sitting = true;
                    isSitting = true;
                }
            }
        };
        t2 = new Timer.Task() {
            @Override
            public void run() {
                if (!withFood) {
                    width = Gdx.graphics.getWidth() / 23;
                    current = val.anim.get(index);
                    if (index < val.anim.size() - 1) {
                        index++;
                    } else index = 0;
                    walkRight();
                } else {
                    current = val.anim.get(index);
                    width = current.getWidth() * (height / current.getHeight());
                    if (index < val.anim.size() - 1) {
                        index++;
                    } else index = 0;
                    walkRight();
                }
            }
        };
        t3 = new Timer.Task() {
            @Override
            public void run() {
                walkRight();
            }
        };
        t4 = new Timer.Task() {
            @Override
            public void run() {
                if (!withFood) {
                    width = current.getWidth() * (height / current.getHeight());
                    current = val.anim1.get(index2);
                    if (index2 < val.anim1.size() - 1) {
                        index2++;
                    } else index2 = 0;
                    walkLeft();
                } else {
                    current = val.anim1.get(index2);
                    width = current.getWidth() * (height / current.getHeight());
                    if (index2 < val.anim1.size() - 1) {
                        index2++;
                    } else index2 = 0;
                    walkLeft();
                }
            }
        };
        t5 = new Timer.Task() {
            @Override
            public void run() {
                walkLeft();
            }
        };
        t6 = new Timer.Task() {
            @Override
            public void run() {
                free = true;
            }
        };
        t7 = new Timer.Task() {
            @Override
            public void run() {
                atcafe = false;
                current = val.stay;
                timer3.scheduleTask(t6, 1f);
            }
        };
        t8 = new Timer.Task() {
            @Override
            public void run() {
                sitting = false;
                y = basic_y;
                current = val.stay;
                timer3.scheduleTask(t6, 1f);
                benchNum = -1;
            }
        };
        t9 = new Timer.Task() {
            @Override
            public void run() {
                atmarket = false;
                atFF = false;
                current = val.stay;
                timer3.scheduleTask(t6, 1f);
            }
        };
        t10 = new Timer.Task() {
            @Override
            public void run() {
                if (sm_index < 39) {
                    current = val.smoking.get(sm_index);
                    sm_index++;
                    smoke1();
                } else if (sm_index >= 39) {

                    sm_time = 0.1f;
                    current = val.smoking.get(sm_index);
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
        t11 = new Timer.Task() {
            @Override
            public void run() {
                smoke1();
            }
        };
        t12 = new Timer.Task() {
            @Override
            public void run() {
                free = true;
                issmoking = false;
                dropping = false;
                sm_index = 0;
                width = Gdx.graphics.getWidth() / 23;
            }
        };
        t13 = new Timer.Task() {
            @Override
            public void run() {
                current = val.smoking.get(sm_index);
                sm_index++;
                if (sm_index != val.smoking.size() - 1 && onscreen) {
                    dropCigarette();
                } else {
                    timer3.scheduleTask(t12, 1f);
                }
            }
        };
        t14 = new Timer.Task() {
            @Override
            public void run() {
                atFF = false;
                current = val.stay;
                timer3.scheduleTask(t6, 1f);
            }
        };
        t15 = new Timer.Task() {
            @Override
            public void run() {
                if (rand1 == 0) {
                    if (previous != cafe)
                        goCafe(val.cafe.x, val.cafe.width);
                } else if (rand1 == 1) {
                    if (previous != market)
                        goMarket(val.market.x, val.market.y);
                } else if (rand1 == 2) {
                    if (previous != bench)
                        goBench();
                } else if (rand1 == 3) {
                    if (smoker)
                        if (previous !=  smoke)
                            smoke();
                } else if (rand1 == 4) {
                    if (previous != ff) {
                        goFastFood(val.ff.x, val.ff.width);
                    }
                }else if(rand1==5){
                    if(age<=17)
                    goSchool(val.school.position.x,val.school.width);
                }
            }
        };
        t16 = new Timer.Task() {
            @Override
            public void run() {
                onscreen = true;
            }
        };
        t17 = new Timer.Task() {
            @Override
            public void run() {
                width = current.getWidth() * (height / current.getHeight());
                move(val.cafe, val.market);
                if (free && !movingCafe && !movingMarket && !issmoking && !movingFF) {
                    rand1 = val.rand.nextInt(5);
                    try {
                        timer2.scheduleTask(t15, 1f);
                    } catch (IllegalArgumentException ex) {
                    }
                }
            }
        };
        t18 = new Timer.Task() {
            @Override
            public void run() {
                atschool = false;
                atschool = false;
                current = val.stay;
            }
        };
    }

//    public void setCM(Cafe cafe1, Market market1, FastFood ff1) {
//        val.cafe = cafe1;
//        val.market = market1;
//        val.ff = ff1;
//    }

    public void moveLeft() {
        movingLeft = true;
        movingRight = false;
        x -= speed;
    }

    public void moveRight() {
        movingLeft = false;
        movingRight = true;
        x += speed;

    }

    public void draw(SpriteBatch batch) {
        if(atschool){
            if(panel.time.hour>13){
                x=val.rand.nextInt((int) (x + width * 4)) + x - width * 3;
                atschool = false;
                current = val.stay;
                free=true;
            }
        }
        width = current.getWidth() * (height / current.getHeight());
        move(val.cafe, val.market);
        if (free && !movingCafe && !movingMarket && !issmoking && !movingFF&& !movingSchool) {
            rand1 = val.rand.nextInt(6);
            try {
                timer2.scheduleTask(t15, val.rand.nextInt(2) + 0.3f);
            } catch (IllegalArgumentException ex) {
            }
        }
        if (!atmarket && !atcafe && !atFF && !atschool) {
            batch.draw(current, x, y, width, height);
            if (name.length() % 2 == 0)
                name_1.draw(batch, name, x + width / 2 - name_1.getSpaceWidth() * name.length(), y + height + height / 3);
            else {
                name_1.draw(batch, name, x + width / 2 - name_1.getSpaceWidth() * (name.length() + 1), y + height + height / 3);
            }
        }

//            move(val.cafe, val.market);
//            try {
//                timer2.scheduleTask(t16, 2f);
//            }catch (IllegalArgumentException ex){}

    }

    public void move(Cafe cafe, Market market) {
        if (movingRight)
            moveRight();
        else if (movingLeft)
            moveLeft();
        if (movingMarket) {
            goMarket(market.x, market.width);
        }
        if (movingCafe)
            goCafe(cafe.x, cafe.width);
        if (movingBench) {
            goBench();
        }
        if (movingFF) {
            goFastFood(val.ff.x, val.ff.width);
        }
        if(movingSchool){
            goSchool(val.school.position.x, val.school.width);
        }
    }

    public void sit() {
        if (sitting) {
            timer.scheduleTask(t1, 0.05f);
        }
    }

    public void walkRight() {
        if (onscreen) {
            if (movingRight) {
                timer.scheduleTask(t2, 0.01f);
            } else {
                timer.scheduleTask(t3, 0.2f);
            }
        } else {
            timer.scheduleTask(t3, 0.1f);
        }
    }

    public void walkLeft() {
        if (onscreen) {
            if (movingLeft) {
                timer.scheduleTask(t4, 0.01f);
            } else {
                timer.scheduleTask(t5, 0.2f);
            }
        } else {
            timer.scheduleTask(t5, 0.1f);
        }
    }

    public void goFastFood(float x, float width) {
        if (free) {
            if (this.x + this.width / 2 > x + width - width / 4 && this.x + this.width / 2 < x + width - width / 8) {
                previous = ff;
                movingFF = false;
                movingRight = false;
                movingLeft = false;
                atFF = true;
                free = false;
                timer2.scheduleTask(t9, 2f);
            } else if (this.x + this.width / 2 < x + width - width / 4) {
                movingFF = true;
//                moveRight();
                movingLeft = false;
                movingRight = true;
                rand1 = -1;
//                free = false;
            } else if (this.x + this.width / 2 > x + width) {
                movingFF = true;
//                moveLeft();
                movingLeft = true;
                movingRight = false;
                rand1 = -1;
//                free = false;
            }
        }
    }

    public void goCafe(float x, float width) {
//        System.out.println("1");
        if (free) {
//            System.out.println("2");
            if (this.x - this.width / 2 > x && this.x + this.width / 2 < x + width / 4) {
//                System.out.println("at cafe");
                previous = cafe;
                movingCafe = false;
                movingLeft = false;
                movingRight = false;
                atcafe = true;
                free = false;
                timer2.scheduleTask(t7, 2f);
            } else if (this.x - this.width / 2 < x) {
                movingCafe = true;
//                moveRight();
                movingLeft = false;
                movingRight = true;
                rand1 = -1;
//                free = false;
            } else if (this.x + this.width / 2 > x + width / 4) {
                movingCafe = true;
//                moveLeft();
                movingLeft = true;
                movingRight = false;
                rand1 = -1;
//                free = false;
            }
//            System.out.println("3");
        }
    }

    public void goBench() {
        if (free) {
            if (benchNum == -1) {
                benchNum = val.rand.nextInt(benches.size());
                if (benches.get(benchNum).free == false) {
                    benchNum = -1;
                }
            }
            if (benchNum != -1) {
                if (x - width / 4 > benches.get(benchNum).x && x + width + width / 4 < benches.get(benchNum).x + benches.get(benchNum).width) {
                    benches.get(benchNum).free = false;
                    previous = bench;
                    y = benches.get(benchNum).y - benches.get(benchNum).height / 6;
                    sitting = true;
                    movingBench = false;
                    movingRight = false;
                    movingLeft = false;
                    free = false;
                    sit();
                    timer2.scheduleTask(t8, val.rand.nextInt(6) + 4);
                }
                if (x - width / 4 < benches.get(benchNum).x) {
                    movingBench = true;
                    movingRight = true;
                    movingLeft = false;
                }
                if (x + width + width / 4 > benches.get(benchNum).x + benches.get(benchNum).width) {
                    movingBench = true;
                    movingLeft = true;
                    movingRight = false;
                }
            }
        }
    }
    public void goSchool(float x,float width){
        if(!(panel.time.day.equals("Sun") || panel.time.day.equals("Sat"))&& panel.time.hour>=7 && panel.time.hour<=13) {
            if (free) {
                if (this.x + this.width / 2 > x + width / 2 - width / 10 && this.x + this.width / 2 < x + width / 2 + width / 10) {
                    atschool = true;
                    previous = school;
                    movingSchool = false;
                    movingRight = false;
                    movingLeft = false;
                    free = false;
//                    timer2.scheduleTask(t9, 2f);
                } else if (this.x + this.width / 2 < x + width / 2 - width / 10) {
                    movingSchool = true;
//                moveRight();
                    movingLeft = false;
                    movingRight = true;
//                    rand1 = -1;
//                free = false;
                } else if (this.x + this.width / 2 > x + width / 2 + width / 10) {
                    movingSchool = true;
//                moveLeft();
                    movingLeft = true;
                    movingRight = false;
//                    rand1 = -1;
//                free = false;
                }
            }
        }
    }
    public void goMarket(float x, float width) {
        if (free) {
            if (this.x + this.width / 2 > x + width - width / 4 && this.x + this.width / 2 < x + width - width / 8) {
                atmarket = true;
                previous = market;
                movingMarket = false;
                movingRight = false;
                movingLeft = false;
                free = false;
                timer2.scheduleTask(t9, 2f);
            } else if (this.x + this.width / 2 < x + width - width / 4) {
                movingMarket = true;
//                moveRight();
                movingLeft = false;
                movingRight = true;
                rand1 = -1;
//                free = false;
            } else if (this.x + this.width / 2 > x + width) {
                movingMarket = true;
//                moveLeft();
                movingLeft = true;
                movingRight = false;
                rand1 = -1;
//                free = false;
            }
        }
    }

    public float x1 = 0;
    public boolean timerSetted2 = false;

    public boolean moveToCoord() {
        ismoving = true;
        if (this.x > x1 - width && this.x < x1 + width) {
            movingLeft = false;
            movingRight = false;
            return true;
        } else if (this.x < x1 - width / 2) {
            movingRight = true;
            if (!timerSetted2) {
                timerSetted2 = true;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        timerSetted2 = false;
                        moveToCoord();

                    }
                }, 0.3f);
            }
        } else if (this.x > x1 + width / 2) {
            movingLeft = true;
            if (!timerSetted2) {
                timerSetted2 = true;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        timerSetted2 = false;
                        moveToCoord();

                    }
                }, 0.3f);
            }
        }
        return false;
    }

public boolean timersetted1 = false;

    public void smoke() {
        if ((free && smoker) || ismoving) {
            previous = smoke;
            free = false;
//            System.out.println("1");
            if (x1 == 0)
                x1 = val.rand.nextInt((int) (x + width * 6)) + x - width * 5;
            if (moveToCoord()) {
                current=val.stay;
                System.out.println(x1);
//                x1 = 0;
                System.out.println("2");
                ismoving = false;
                issmoking = true;
                movingLeft = false;
                movingRight = false;
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        smoke1();
                    }
                },val.rand.nextInt(2)+0.2f);
            } else {
//                System.out.println("3");
                if (!timersetted1) {
                    timersetted1 = true;
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            timersetted1 = false;
                            smoke();
                        }
                    }, 0.1f);
                }
            }
        }
    }

    public void smoke1() {
        if (issmoking && !dropping && onscreen) {
            width = texture.getWidth() * (height / texture.getHeight());

            timer.scheduleTask(t10, sm_time);
        } else {
//            if(timer.isEmpty())
            timer.scheduleTask(t11, 1f);
        }
    }

    public void backSpeed() {
        if (!taskMade) {
            taskMade = true;
//            if(timer.isEmpty())
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    speed = basic_speed;
    taskMade = false;
}
}, 1f);
        }
        }

    public void dropCigarette() {
        x1=0;
//        if(timer.isEmpty())
        timer.scheduleTask(t13, 0.05f);
    }


}
