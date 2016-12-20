package Weather;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;

import java.util.Random;

/**
 * Created by Sava on 18.04.2016.
 */
public class Rain {
    public static Texture drop;
    public float x;
    public float y;
    public float width;
    public float height;
    public Random random;
    public float ground;
    public static Texture rainy;
    public Rain(final Main main){
        drop=main.manager.get("background/drop.png",Texture.class);
        random=new Random();
        x=random.nextInt(2*Gdx.graphics.getWidth());
        y=random.nextInt(Gdx.graphics.getHeight());
//        x=0;
//        y=Gdx.graphics.getHeight();
        width=Gdx.graphics.getWidth()/260;
        height = drop.getHeight() * (width /drop.getWidth());

        ground=random.nextInt(Gdx.graphics.getHeight()/3);
        rainy=new Texture(Gdx.files.internal("background/rainy.png"));
    }
    public void draw(SpriteBatch batch,boolean pause){
        batch.draw(drop,x,y,width,height);
        if(!pause)
        y-=8;
        if(y<=ground){
            y=Gdx.graphics.getHeight();
        }
    }
    public void draw(SpriteBatch batch){
        batch.draw(drop,x,y,width,height);
            y-=8;
        if(y<=ground){
            y=Gdx.graphics.getHeight();
        }
    }
}
