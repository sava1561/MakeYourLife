package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;

public class Arrows {
    public String back;
    private Vector2 touch;
    public String previous;
    public Texture right;
    public Texture left;
    public Texture middle;
    public float rrunx, rruny, rrrunx, lrunx, lruny, llrunx;
    public float llx, rrx, mmx, mmx1;
    public float lx, mx, mx1;
    public float rx;
    public float y;
    public float width, middlewidth;
    public float height, middleheight;
    boolean draw = true;
    public Texture rrun, lrun;
    public boolean change=false;
    public Arrows(float rx, float lx, float mx, float mx1,Main main) {
        touch = new Vector2();
        lrun = main.manager.get("background/run_left.png", Texture.class);
        rrun = main.manager.get("background/run_right.png", Texture.class);
        left = main.manager.get("background/left.png", Texture.class);
        right = main.manager.get("background/right.png", Texture.class);
        middle = main.manager.get("background/stop.png", Texture.class);
        width = Gdx.graphics.getWidth() / 24;
        middlewidth = Gdx.graphics.getWidth() / 14;
        middleheight = middle.getHeight() * (middlewidth / middle.getWidth());
        height = right.getHeight() * (width / right.getWidth());
        this.mx = mx;
        this.rx = rx;
        this.lx = lx;
        this.mx1 = mx1;
        this.rrunx = rrrunx = rx + (float) (width * 3);
        this.rruny = y;
        lrunx = lx - 3 * width;
        llrunx = lrunx;
//        rx = Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 7 - width;
//        lx = Gdx.graphics.getWidth() / 2 - (rx - Gdx.graphics.getWidth() / 2) - width;
        y = Gdx.graphics.getHeight() / 5 - 7 * height / 10;
        llx = lx;
        rrx = rx;
        mmx = mx;
        mmx1 = mx1;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(right, rx, y, width, height);
        batch.draw(left, lx, y, width, height);
        batch.draw(rrun, rrunx, y, width, height);
        batch.draw(lrun, lrunx, y, width, height);
        batch.draw(middle, mx, y + middleheight / 4, middlewidth, middleheight);
        batch.draw(middle, mx1, y + middleheight / 4, middlewidth, middleheight);
    }

    public String touch() {
        if (Gdx.input.justTouched()) {
            touch.x = Gdx.input.getX();
            touch.y = Gdx.input.getY();
            if (touch.x >= rrx - width && touch.x <= rrx + 2 * width && touch.y <= Gdx.graphics.getHeight() - y && touch.y >= Gdx.graphics.getHeight() - y - height) {
                draw = false;
                touch.y=Gdx.graphics.getHeight();
                if(previous!="right"){
                    change=true;
                }else{
                    change=false;
                }
                previous = "right";
                return "right";
            } else if (touch.x >= llx - width && touch.x <= llx + 2 * width && touch.y <= Gdx.graphics.getHeight() - y && touch.y >= Gdx.graphics.getHeight() - y - height) {
                touch.y=Gdx.graphics.getHeight();
                if(previous!="left"){
                    change=true;
                }else{
                    change=false;
                }
                previous = "left";
                return "left";
            } else if (touch.x >= mmx - middlewidth / 2 && touch.x <= mmx + 3 * middlewidth / 2 && touch.y <= Gdx.graphics.getHeight() - (y + middleheight / 4) && touch.y >= Gdx.graphics.getHeight() - (y + middleheight / 4) - height ||
                    touch.x >= mmx1 - middlewidth / 2 && touch.x <= mmx1 + 3 * middlewidth / 2 && touch.y <= Gdx.graphics.getHeight() - (y + middleheight / 4) && touch.y >= Gdx.graphics.getHeight() - (y + middleheight / 4) - height) {
                touch.y=Gdx.graphics.getHeight();
                if(previous!="middle"){
                    change=true;
                }else{
                    change=false;
                }
                previous = "middle";
                return "middle";
            } else if (touch.x >= rrrunx - width && touch.x <= rrrunx + 2 * width && touch.y <= Gdx.graphics.getHeight() - y && touch.y >= Gdx.graphics.getHeight() - y - height) {
                touch.y=Gdx.graphics.getHeight();
                if(previous!="rrun"){
                    change=true;
                }else{
                    change=false;
                }
                previous = "rrun";
                return "rrun";
            } else if (touch.x >= llrunx - width && touch.x <= llrunx + 2 * width && touch.y <= Gdx.graphics.getHeight() - y && touch.y >= Gdx.graphics.getHeight() - y - height) {
                touch.y=Gdx.graphics.getHeight();
                if(previous!="lrun"){
                    change=true;
                }else{
                    change=false;
                }
                previous = "lrun";
                return "lrun";
            }
        }
        return previous;
    }

    public void update(float speed) {
        this.mx += speed;
        this.rx += speed;
        this.lx += speed;
        this.mx1 += speed;
        this.rrunx += speed;
        this.lrunx+=speed;
    }

    public void dispose() {
        right.dispose();
        left.dispose();
        middle.dispose();
    }
}
