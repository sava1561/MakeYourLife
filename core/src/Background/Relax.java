package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Roman on 07.07.2016.
 */
public class Relax {
    public Texture texture;
    public float x;
    public float y;
    public float width;
    public float height;
    public float toAdd;
    public Timer tm;
    public Relax(Home home){
        tm=new Timer();
        texture=new Texture(Gdx.files.internal("background/tv.png"));
        x=home.position.x+home.width+home.width/10;
        y=home.position.y+home.height-home.height/6;
        width=home.width/4;
        toAdd=width/4;
        height=texture.getHeight() * (width / texture.getWidth());
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y, width,height);
    }
}
