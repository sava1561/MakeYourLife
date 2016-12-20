package roadActions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Roman on 08.07.2016.
 */
public class Sign {
    public Texture texture;
    public float x,y,width,height;
    public Sign(float x){
        texture=new Texture(Gdx.files.internal("background/sign.png"));
        this.x=x;
        y=Gdx.graphics.getHeight()/100;
        width=Gdx.graphics.getWidth()/20;
        height=texture.getHeight() * (width / texture.getWidth());
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
    }
}
