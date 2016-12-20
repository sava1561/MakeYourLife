package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;

/**
 * Created by Sava on 29.02.2016.
 */
public class Bush {
    public boolean onscreen;
    public Texture texture,texture_snow;
    public float x;
    public float y;
    public static float width;
    public static float height;
    public Bush(float x,Main main){
        onscreen=true;
        texture=main.manager.get("background/bush1.png",Texture.class);
        texture_snow=main.manager.get("background/bush1_snow.png",Texture.class);
        this.x=x;
        y= Gdx.graphics.getHeight()/4;
        width=Gdx.graphics.getWidth()/12;
        height= texture.getHeight()*(width/texture.getWidth());

    }
    public void draw(SpriteBatch batch,boolean winter)
    {
        if(winter){
            batch.draw(texture_snow,x,y,width,height);
        }else
        batch.draw(texture,x,y,width,height);
    }
    public void update(float pos){
        if(x>pos+Gdx.graphics.getWidth()/2 ||x+width<pos-Gdx.graphics.getWidth()/2){
            onscreen=false;
        }else {
            onscreen=true;
        }
    }
    public void dispose(){
        texture.dispose();
    }
}
