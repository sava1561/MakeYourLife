package roadActions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
//import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Main;

import java.util.Random;

import Background.Arrows;
import Player.*;

/**
 * Created by Roman on 07.07.2016.
 */
public class Car {
    public Timer tm;
    public Texture texture, texture_transparent;
    public float x;
    public float y;
    public float width;
    public float height;
    public static float speed;
    public int type;// 1-taxi_right 2-taxi_left 3-car ...
    public Random random;
    public boolean upping;
    public float basic_speed;
    public Variants get_in, go_out;
    public static Vector2 touchPos;
    public boolean varExist;
    public int car_index;
    public boolean onscreen = true;
    public static BitmapFont payment;
    public static FreeTypeFontGenerator generator;
    public static FreeTypeFontGenerator.FreeTypeFontParameter parameter;
//    public float font_x,font_y;
    public Car(int type, Player player,final Main main) {
        varExist = false;
        upping = false;
        width = 6 * Gdx.graphics.getWidth() / 20;
        random = new Random();
        this.type = type;
        if (type == 1) {
            texture=main.manager.get("taxi/taxi_right.png",Texture.class);
            texture_transparent=main.manager.get("taxi/taxi_right_transparent.png",Texture.class);
            height = texture.getHeight() * (width / texture.getWidth());
            y = Gdx.graphics.getHeight() / 40;
            x = -Gdx.graphics.getWidth()*3;
        } else if (type == 2) {
            texture=main.manager.get("taxi/taxi_left.png",Texture.class);
            texture_transparent=main.manager.get("taxi/taxi_left_transparent.png",Texture.class);
            height = texture.getHeight() * (width / texture.getWidth());
            y = Gdx.graphics.getHeight() / 10;
            x = Gdx.graphics.getWidth() * 7;
        }
        get_in = new Variants(x + width / 2 - player.height, y + height + height / 4, 8 * player.height / 4, "taxi/in.png");
        go_out = new Variants(x + width / 2 - player.height, y + height + height / 4 + player.height, 8 * player.height / 4, "taxi/out.png");
        tm = new Timer();
        speed = Gdx.graphics.getWidth() / 180;
        basic_speed = speed;
        touchPos = new Vector2();
        car_index = random.nextInt(2000);
        generator=new FreeTypeFontGenerator(Gdx.files.internal("font/impact.ttf"));
        parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color= Color.WHITE;
        parameter.size=Gdx.graphics.getWidth()/40;
        parameter.borderWidth=parameter.size/30;
        parameter.borderColor=Color.WHITE;
        payment=generator.generateFont(parameter);
    }

    public void update(float pos) {
        if (x > pos + Gdx.graphics.getWidth() / 2 || x + width < pos - Gdx.graphics.getWidth() / 2) {
            onscreen = false;
        } else {
            onscreen = true;
        }
    }

    public void draw(SpriteBatch batch, Player player) {
        if(player.inBus){
            go_out.y=y + height + height / 4;
            get_in.y=y;
        }else{
            get_in.y=y + height + height / 4;
            go_out.y=y;
        }
        if (onscreen) {
            if (player.position.x > x + width || player.position.x + player.width < x)
                batch.draw(texture, x, y, width, height);
            else {
                if (!player.inBus)
                    batch.draw(texture_transparent, x, y, width, height);
                else
                    batch.draw(texture, x, y, width, height);
            }
        }
        if (type == 1) {
            x += speed;
        } else if (type == 2) {
            x -= speed;
        }
        drawVariants(batch, player);
        check();
    }

    public void ontouch(float x, float width, float y,Arrows arrows) {
        if (Gdx.input.justTouched()) {
            touchPos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchPos.y = Gdx.input.getY();
//            System.out.println("Car x = "+this.x+" "+(this.x+this.width)+" y = "+this.y);
//            System.out.println(touchPos.x+" "+touchPos.y);
//            System.out.println(Gdx.graphics.getHeight() - this.y - height+" "+(Gdx.graphics.getHeight()-this.y));
            if (touchPos.x > this.x && touchPos.x < this.x + this.width && touchPos.y > Gdx.graphics.getHeight() - this.y - this.height && touchPos.y < Gdx.graphics.getHeight() - this.y) {
                touchPos.x = 0;
                touchPos.y = 0;
                if (varExist == true) {
//                    System.out.println("Her1");
                    arrows.previous = "middle";
                    varExist = false;
                } else {
//                    System.out.println("Her2");
                    arrows.previous = "middle";
                    varExist = true;
                }
            }
        }
    }

    public void drawVariants(SpriteBatch batch, Player player) {
        if (player.inBus && player.bus_index == car_index) {
            go_out.draw(batch);
            payment.draw(batch,player.payment+"$",go_out.x+go_out.width/2,go_out.y+go_out.height/2+go_out.height/6);
        }
        if (varExist) {
            if (player.varExist)
                player.varExist = false;
            if (!player.inBus) {
                get_in.draw(batch);
//                System.out.println(get_in.x+" "+get_in.y);
            }
        }
    }

    public void check() {
        get_in.x = go_out.x = x + width / 2 - get_in.width / 2;
        if (type == 1) {
            if (x >= Gdx.graphics.getWidth() * 7) {
                if (tm.isEmpty())
                    x = -Gdx.graphics.getWidth()*3-width;
            }
        } else if (type == 2) {
            if (x + width <= -Gdx.graphics.getWidth()*3) {
                if (tm.isEmpty())
                    x = Gdx.graphics.getWidth() * 7;

            }
        }
    }

}
