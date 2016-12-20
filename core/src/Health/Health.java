package Health;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

import Background.Hospital;
import Background.TopPanel;

/**
 * Created by Roman on 11.07.2016.
 */
public class Health {
    public static Texture texture;
    public float x;
    public float y;
    public float width;
    public float height;
    public float basic_y;
    public Timer timer;
    public boolean drawable;
    public Health(Hospital hospital,float x){
        drawable=false;
        this.x=x;
        this.y=hospital.position.y+hospital.height+hospital.height/20;
        basic_y=y;
        width=hospital.height/10;
        texture=new Texture(Gdx.files.internal("health/health.png"));
        height= texture.getHeight()*(width/texture.getWidth());
        timer=new Timer();
    }
    public void draw(SpriteBatch spritebatch){
        if(drawable)
        spritebatch.draw(texture,x,y,width,height);
    }
    public void boom(final float width){
        drawable=true;
        this.width=width;
        height= texture.getHeight()*(width/texture.getWidth());
        if(timer.isEmpty()){
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    if(y<=Gdx.graphics.getHeight()) {
                        y += Gdx.graphics.getHeight() / 300;
                        boom(width);
                    }else{
                        y=basic_y;
                        drawable=false;
                    }
                }
            },0.005f);
        }
    }
}
