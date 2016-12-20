package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Road {
    public Texture texture,texture_snow;
    public float width;
    public float height;
    public float x;
    public boolean onscreen;
    public Road(float x){
        onscreen=true;
        texture=new Texture(Gdx.files.internal("background/road.png"));
        texture_snow=new Texture(Gdx.files.internal("background/road_snow.png"));
        height=Gdx.graphics.getHeight()/4;
        width=texture.getWidth()*(height/texture.getHeight());
        this.x=x;
    }
    public void draw(SpriteBatch batch,boolean winter){
        if(winter){
            batch.draw(texture_snow,x,0,width,height);
        }else {
            batch.draw(texture, x, 0, width, height);
        }
    }
    public void update(float pos){
        onscreen = !(x > pos + Gdx.graphics.getWidth() / 2 || x + width < pos - Gdx.graphics.getWidth() / 2);
    }
    public void dispose(){
        texture.dispose();
    }
}
