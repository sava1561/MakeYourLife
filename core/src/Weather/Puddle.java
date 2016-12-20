package Weather;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;

import java.util.Random;

/**
 * Created by Sava on 18.04.2016.
 */
public class Puddle {
    public static boolean begin=false;
    public static Texture texture;
    public float x;
    public float y;
    public float width;
    public float height;
    public Random random;
    public Puddle(final Main main,int mult){
        texture=main.manager.get("background/puddle.png",Texture.class);
        random=new Random();
        width=random.nextInt(Gdx.graphics.getWidth()/10-Gdx.graphics.getWidth()/20)+Gdx.graphics.getWidth()/20;
        height = texture.getHeight() * (width / texture.getWidth());
        x=random.nextInt(mult* Gdx.graphics.getWidth());
        y=random.nextInt(Gdx.graphics.getHeight()/4)-height;
    }
    public Puddle(final Main main){
        texture=main.manager.get("background/puddle.png",Texture.class);
        random=new Random();
        width=random.nextInt(Gdx.graphics.getWidth()/10-Gdx.graphics.getWidth()/20)+Gdx.graphics.getWidth()/20;
        height = texture.getHeight() * (width / texture.getWidth());
        x=random.nextInt(7* Gdx.graphics.getWidth());
        y=random.nextInt(Gdx.graphics.getHeight()/4)-height;
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
    }
}
