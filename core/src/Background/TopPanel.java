package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

import Pause.Pause;
import Player.Player;

/**
 * Created by Sava on 09.03.2016.
 */
public class TopPanel {
    public Time time;
    public Money money;
    public Texture rect,rect1;
    public ShapeRenderer shape_renderer;
    public Texture panel;
    public HashMap<String, Rectangle> stat;
    public float h_x, h_y, h_width, h_height;
    public float a_x, a_y, a_width, a_height;
    public float s_x, s_y, s_width, s_height;
    public float c_x,c_y,c_width,c_height;
    public float w_x,w_y,w_width,w_height;
    public float st_x,st_y,st_width,st_height;
    public Texture menu;
    public float x, menu_x;
    public float y, menu_y;
    public float width, menu_width;
    public float height, menu_height;
    public float maxwidth;
    public int minusMoney,plusMoney;
    public Vector2 touchpos;
    public boolean pause;
    public Pause pause_menu;
    public TopPanel(OrthographicCamera camera,Player player) {
        pause=false;
        touchpos=new Vector2();
        minusMoney=0;
        plusMoney=0;
        maxwidth=Gdx.graphics.getWidth()/20;
        rect=new Texture(Gdx.files.internal("background/rectangle.png"));
        rect1=new Texture(Gdx.files.internal("background/rectangle1.png"));
        shape_renderer = new ShapeRenderer();
        shape_renderer.setProjectionMatrix(camera.combined);
        height = Gdx.graphics.getHeight() / 8;
        width = Gdx.graphics.getWidth();
        x = 0;
        y = Gdx.graphics.getHeight() - height;
        panel = new Texture(Gdx.files.internal("background/panel1.png"));
        menu = new Texture(Gdx.files.internal("background/1.png"));
        menu_height = menu_width = Gdx.graphics.getHeight() / 10;
        menu_x = x + width / 50;
        menu_y = Gdx.graphics.getHeight() - height / 2 - menu_height / 2;
        money=new Money(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/12+Gdx.graphics.getWidth()/100,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10+Gdx.graphics.getHeight()/210);
        time=new Time(Gdx.graphics.getWidth()/3-Gdx.graphics.getWidth()/100,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/36,this,player);
        time.start();
        st_y=Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/8+Gdx.graphics.getHeight()/90;
        st_width=Gdx.graphics.getWidth()/20;
        st_x=Gdx.graphics.getWidth()/2+st_width/15;
        st_height=Gdx.graphics.getHeight()/145;
        w_x=st_x+st_width+st_width/3-st_width/28 + st_width/15;
        w_y=st_y;
        w_width=st_width;
        w_height=st_height;
        c_x=w_x+st_width+st_width/3-st_width/20 + st_width/15;
        c_height=w_height;
        c_width=w_width;
        c_y=w_y;
        a_x=c_x+st_width+st_width/3-st_width/22 + st_width/15;
        a_y=c_y;
        a_height=c_height;
        a_width=c_width;
        s_x=a_x+st_width+st_width/3-st_width/28 + st_width/10;
        s_y=a_y;
        s_width=a_width;
        s_height=a_height;
        h_x=s_x+st_width+st_width/3-st_width/22 + st_width/9;
        h_y=s_y;
        h_width=s_width;
        h_height=s_height;
        pause_menu=new Pause();
    }
    public void toMax(){
        c_width=maxwidth;
        h_width=maxwidth;
        s_width=maxwidth;
        a_width=maxwidth;
        w_width=maxwidth;
        st_width=maxwidth;;
    }
    public void draw(SpriteBatch batch) {
        if(c_width>maxwidth)
            c_width=maxwidth;
        if(a_width>maxwidth)
            a_width=maxwidth;
        time.update();
        batch.draw(panel, x, y, width, height);
//        batch.draw(menu, menu_x, menu_y, menu_width, menu_height);
//        batch.draw(heart, h_x, h_y, h_width, h_height);
//        batch.draw(apple, a_x, a_y, a_width, a_height);
//        batch.draw(sleep,s_x,s_y,s_width,s_height);
//        batch.draw(cloud,c_x,c_y,c_width,c_height);
//        batch.draw(work,w_x,w_y,w_width,w_height);
//        batch.draw(study,st_x,st_y,st_width,st_height);
        money.draw(batch,minusMoney,plusMoney);
        time.draw(batch);
        batch.draw(rect1,h_x,h_y,h_width,h_height);
        batch.draw(rect1,a_x,a_y,a_width,a_height);
        batch.draw(rect,s_x,s_y,s_width,s_height);
        batch.draw(rect,c_x,c_y,c_width,c_height);
        batch.draw(rect1,w_x,w_y,w_width,w_height);
        batch.draw(rect,st_x,st_y,st_width,st_height);

    }
    public void ontouch_pause(float x, float width, float y, Arrows arrows){
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= this.x && touchpos.x <= this.x + this.width/15 && touchpos.y >= Gdx.graphics.getHeight() - this.height - this.y && touchpos.y <= Gdx.graphics.getHeight() - this.y) {
                pause=true;
                pause_menu.unpause=false;
            }
        }
    }
    public void update(float x) {
        pause_menu.x+=x;
        this.x += x;
        h_x+=x;
        s_x+=x;
        a_x+=x;
        c_x+=x;
        w_x+=x;
        st_x+=x;
        money.x+=x;
        money.x1+=x;
        time.x+=x;
        time.x1+=x;
    }

}
