package Support;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Roman on 04.12.2016.
 */
public class Texture {
    private com.badlogic.gdx.graphics.Texture texture;
    private float x,y,width,height;

    public Texture(String path,float x,float y,float width,float height){
        texture = new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(path));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
    }

    public float getX(){
        return x;
    }

    public  float getY(){
        return y;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public void setWidth(float width){
        this.width = width;
    }

}