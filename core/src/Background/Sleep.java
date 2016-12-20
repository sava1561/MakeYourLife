package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Sava on 24.03.2016.
 */
public class Sleep {
    public Texture texture;
    public float x;
    public float y;
    public float width;
    public float height;
    public float toAdd;
    public Timer tm;
    public Sleep(Home home){
        tm=new Timer();
        texture=new Texture(Gdx.files.internal("background/sleep.png"));
        x=home.position.x+home.width-home.width/20;
        y=home.position.y+home.height-home.height/4-home.height/6;
        width=home.width/3;
        toAdd=width/4;
        height=texture.getHeight() * (width / texture.getWidth());
        change();
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y, width,height);
    }
    public void change(){
        tm.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                width+=toAdd;
                height=texture.getHeight() * (width / texture.getWidth());
                toAdd*=-1;
                change();
            }
        },0.3f);
    }
}
