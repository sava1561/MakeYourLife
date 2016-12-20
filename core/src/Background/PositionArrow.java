package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Sava on 09.05.2016.
 */
public class PositionArrow {
    public float x;
    public float y;
    public Texture texture;
    public float width;
    public float height;
    int index;
    public Timer timer;
    public boolean goUp,goDown;
    public boolean draw=false;
    public float add;
    public float basY;
    public int previous;
    public PositionArrow(){
        previous=0;
        goUp=false;
        goDown=false;
        timer=new Timer();
        texture=new Texture(Gdx.files.internal("background/positionArrow.png"));
        width=Gdx.graphics.getWidth()/15;
        height = texture.getHeight() * (width / texture.getWidth());
        index=0;
        add=height/30;
    }
    public void draw(SpriteBatch batch){
        if(draw) {
            batch.draw(texture, x, y, width, height);
            if (index == 0) {
                goUp = true;
                goDown = false;
                index++;
                up();
            }
            if (index == 20) {
                goUp = false;
                goDown = true;
                index--;
                down();
            }
        }else{
            y=basY;
        }
    }
    public void up(){
        if(goUp){
//            System.out.println("upping1  "+y);
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    y+=add;
                    index++;
                    if(index!=20)
                    up();
                }
            },0.06f);
        }
    }
    public void down(){
        if(goDown){
//            System.out.println("upping");
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    y-=add;
                    index--;
                    if(index!=0)
                        down();
                }
            },0.06f);
        }
    }

}
