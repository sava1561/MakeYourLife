package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;

/**
 * Created by Sava on 29.02.2016.
 */
public class Flower {
    public boolean onscreen;
    public Texture texture,texture_snow;
    public float x;
    public float y;
    public float width;
    public float height;
    public Flower(float x,float y,int i,final Main main){
        onscreen=true;
        this.x=x;
        this.y=y;
        if(i==0){
            texture=main.manager.get("background/flower1.png",Texture.class);
            texture_snow=main.manager.get("background/flower1_snow.png",Texture.class);
        }else{
            texture=main.manager.get("background/flower2.png",Texture.class);
            texture_snow=main.manager.get("background/flower2_snow.png",Texture.class);
        }
        width=Gdx.graphics.getWidth()/13;
        height=texture.getHeight()*(width/texture.getWidth());
    }
    public void draw(SpriteBatch batch,boolean winter)
    {
        if(winter){
            batch.draw(texture_snow,x,y,width,height);
        }else
        {
            batch.draw(texture, x, y, width, height);
        }
    }
    public void update(float pos){
        if(x>pos+Gdx.graphics.getWidth()/2 || x+width<pos-Gdx.graphics.getWidth()/2){
            onscreen=false;
        }else {
            onscreen=true;
        }
    }
    public void dispose(){
        texture.dispose();
    }
}
