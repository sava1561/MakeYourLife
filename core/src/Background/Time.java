package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Timer;

import Player.Player;


/**
 * Created by Sava on 10.03.2016.
 */
public class Time {
    public float x, y, width, height, x1, y1;
    public Timer tm;
    public String month;
    public String day;
    public int hour;
    public int minute;
    public int months;
    public int days;
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public BitmapFont date, time;
    public float timespeed;
    public TopPanel panel;
    public Player player;
    public Timer.Task t1, t2, t3;
    public boolean stop = false;

    public Time(float x, float y, TopPanel panel, Player player) {
//        months=12;
        days = 1;
        hour = 12;
        tm = new Timer();
        month = "May";
        day = "Sat";
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Comfortaa-Regular.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.WHITE;
        parameter.size = Gdx.graphics.getWidth() / 42;
        parameter.borderColor = Color.WHITE;
        parameter.borderWidth = parameter.size / 17;
        date = generator.generateFont(parameter);
        parameter.size = Gdx.graphics.getWidth() / 48;
        time = generator.generateFont(parameter);
        this.x = x;
        this.y = y;
        this.x1 = x + Gdx.graphics.getWidth() / 25;
        this.y1 = Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 13;
        timespeed = 0.3f;
        this.panel = panel;
        this.player = player;
        createTasks();
    }

    public void stop() {
        stop = true;
    }

    public void resume() {
        stop = false;
    }

    public void createTasks() {
        t1 = new Timer.Task() {
            @Override
            public void run() {
                if (panel.st_width < panel.maxwidth / 1080) {
                    panel.st_width = panel.maxwidth / 1080;
                }
                if (panel.h_width < panel.maxwidth / 1080) {
                    panel.h_width = panel.maxwidth / 1080;
                }
                if (panel.h_width >= panel.maxwidth) {
                    panel.h_width = panel.maxwidth;
                }
                if (player.heal1)
                    panel.h_width += panel.maxwidth / 60;
                if (player.heal2)
                    panel.h_width += panel.maxwidth / 35;
                if (player.heal3)
                    panel.h_width += panel.maxwidth / 10;
                if (player.atschool) {
                    panel.st_width += panel.maxwidth / 1800;
                }
                if (!player.atschool && hour >= 8 && hour <= 13 && !(day.equals("Sun") || day.equals("Sat"))) {
                    panel.st_width -= panel.maxwidth / 1800;
                }
                if (panel.st_width > panel.maxwidth) {
                    panel.st_width = panel.maxwidth;
                }
                if (panel.a_width < panel.maxwidth / 1080) {
                    panel.a_width = panel.maxwidth / 1080;
                }
                minute++;
                if (panel.c_width > 0 && !player.issleeping && !player.issmoking && !player.sitting1 && !player.relaxing) {
                    panel.c_width -= panel.maxwidth / 1000;
                }
                if (panel.a_width > panel.maxwidth / 1080 && !player.issleeping && !player.relaxing) {
                    panel.a_width -= panel.maxwidth / 360;
                }
                if (player.issleeping && panel.a_width > panel.maxwidth / 1080) {
                    panel.a_width -= panel.maxwidth / 500;
                }
                if (player.relaxing && panel.a_width > panel.maxwidth / 1080) {
                    panel.a_width -= panel.maxwidth / 500;
                }
                if (player.relaxing && panel.c_width > panel.maxwidth / 1080) {
                    panel.a_width -= panel.maxwidth / 500;
                }
                if (player.relaxing && panel.c_width <= panel.maxwidth) {
                    panel.c_width += panel.maxwidth / 470;
                }
                if (panel.s_width > panel.maxwidth / 1080 && !player.issleeping)
                    panel.s_width -= panel.maxwidth / 1080;
                if (player.issleeping && panel.s_width <= panel.maxwidth) {
                    panel.s_width += panel.maxwidth / 520;
                }
                start();
            }
        };
    }

    //    public
    public void start() {
        if (!panel.pause && !stop)
            tm.scheduleTask(t1, timespeed);
        else
            tm.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    start();
                }
            }, 0.1f);
    }

    public void update() {
        if (!stop) {
            if (minute == 60) {
                minute = 0;
                hour++;
            }
            if (hour == 24) {
                hour = 0;
                days++;
                if (day.equals("Sat")) {
                    day = "Sun";
                } else if (day.equals("Sun")) {
                    day = "Mon";
                } else if (day.equals("Mon")) {
                    day = "Tue";
                } else if (day.equals("Tue")) {
                    day = "Wed";
                } else if (day.equals("Wed")) {
                    day = "Thu";
                } else if (day.equals("Thu")) {
                    day = "Fri";
                } else {
                    day = "Sat";
                }
            }
            if (days == 16) {
                panel.money.money += 50;
                panel.plusMoney = 50;
                panel.money.y2 = panel.money.y - Gdx.graphics.getHeight() / 16;
                for (int i = 0; i < 10; i++) {
                    panel.money.drawPlusAnimation();
                }
                months++;
                days = 1;
            }
            if (months == 13) {
                months = 1;
                player.age++;
            }
        }
    }

    public void draw(SpriteBatch batch) {
        date.draw(batch, dateToString(), x, y);
        time.draw(batch, dateToString1(), x1, y1);
    }

    public String dateToString() {
        String a, b;
        if (minute / 10 < 1) {
            a = "0" + minute;
        } else {
            a = "" + minute;
        }
        if (hour / 10 < 1) {
            b = " 0" + hour;
        } else
            b = " " + hour;
        return b + " : " + a;//c + " , " + day + "  " +
    }

    public String dateToString1() {
        String c;
        c = "";
        switch (months) {
            case 0:
                c = "Jan";
            case 1:
                c = "Feb";
            case 2:
                c = "Mar";
            case 3:
                c = "Apr";
            case 4:
                c = "May";
            case 5:
                c = "Jun";
            case 6:
                c = "Jul";
            case 7:
                c = "Aug";
            case 8:
                c = "Sep";
            case 9:
                c = "Oct";
            case 10:
                c = "Nov";
            case 11:
                c = "Dec";
        }
        return days + " ," + c + " , " + day;
    }
}
