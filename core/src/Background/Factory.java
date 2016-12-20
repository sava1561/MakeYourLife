package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Roman on 15.08.2016.
 */
public class Factory {
    public Texture texture,texture_snow;
    public float x;
    public float y;
    public float width;
    public float height;
    public Factory(float x){
        texture=new Texture(Gdx.files.internal("background/factory.png"));
        this.x=x;
        y=Gdx.graphics.getHeight()/4;
        width= 7* Gdx.graphics.getWidth()/10;
        height = 8*(texture.getHeight() * (width / texture.getWidth()))/10;
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
    }
}
