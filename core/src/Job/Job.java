package Job;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Support.Texture;

/**
 * Created by Roman on 20.12.2016.
 */
public class Job {
    public Texture texture;
    public int type = -1; //0-кассир1 1-кассир2 2-кассир3 3-кассир4

    public Job(int type,float x) {
        this.type = type;
        texture = new Texture("job/"+type+".png",x-Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/3,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/3);
    }

    public void draw(SpriteBatch batch){
        texture.draw(batch);
    }

}
