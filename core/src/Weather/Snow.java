package Weather;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;

import java.util.Random;

/**
 * Created by Roman on 14.07.2016.
 */
public class Snow {
    public static Texture snowflake;
    public float x;
    public float y;
    public float width;
    public float height;
    public Random random;
    public float ground;
    public Snow(final Main main){
        snowflake=main.manager.get("background/snowflake.png",Texture.class);
        random=new Random();
        x=random.nextInt(2* Gdx.graphics.getWidth());
//        x=0;
//        y=Gdx.graphics.getHeight();
        width=random.nextInt(Gdx.graphics.getWidth()/130)+Gdx.graphics.getWidth()/130;
        height = snowflake.getHeight() * (width /snowflake.getWidth());

        ground=random.nextInt(Gdx.graphics.getHeight()/3);
        y=random.nextInt(Gdx.graphics.getHeight())+ground;
    }
    public void draw(SpriteBatch batch){
        batch.draw(snowflake,x,y,width,height);
        y-=4;
        if(y<=ground){
            y=Gdx.graphics.getHeight();
        }
    }
    public void draw(SpriteBatch batch,boolean pause){
        batch.draw(snowflake,x,y,width,height);
        if(!pause)
        y-=4;
        if(y<=ground){
            y=Gdx.graphics.getHeight();
        }
    }
}
