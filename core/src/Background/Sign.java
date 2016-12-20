package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Roman on 14.08.2016.
 */
public class Sign {
    public Texture texture;
    public float x,y,width,height;
    public Sign(float x){
        y=Gdx.graphics.getWidth()/10;
        this.x=x;
        width=Gdx.graphics.getWidth()/13;
        texture=new Texture(Gdx.files.internal("background/sign.png"));
        height=texture.getHeight() * (width / texture.getWidth());
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
    }
}
