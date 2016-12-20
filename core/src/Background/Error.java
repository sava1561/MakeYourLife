package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Timer;

import Player.Player;

/**
 * Created by Sava on 24.03.2016.
 */
public class Error {
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public BitmapFont error;
    public float x, y, bas_y;
    public boolean draw;
    public int count;
    public String c;
    public boolean begin;
    public Timer tm;

    public Error(Player player) {
        tm=new Timer();
        draw = false;
        begin = false;
        x = player.position.x - 6 * player.width;
        y = player.position.y + 5 * player.height / 2;
        bas_y = y;
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Roboto-Light.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.RED;
        parameter.size = Gdx.graphics.getWidth() / 30;
        parameter.borderColor = Color.RED;
        parameter.borderWidth = parameter.size /40;
        error = generator.generateFont(parameter);
        up();
    }

    public void draw(SpriteBatch batch, String a) {
        c = a;
//        if(c!=null)
//        System.out.println(x);
        if (begin && c != null) {
            error.draw(batch, c, x, y);
            begin = true;
        }
    }

    public void up() {
        if (begin) {
            tm.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    y += Gdx.graphics.getHeight() / 300;
                    count++;
                    if (count > 70) {
                        count = 0;
                        c = null;
                        begin = false;
                        y = bas_y;
                        up();
                    } else
                        up();
                }
            }, 0.03f);
        } else {
            tm.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    up();
                }
            }, 0.5f);
        }
    }
}
