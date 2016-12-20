package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Tree {
    public Texture texture,texture_snow;
    public float x;
    public float y;
    public float width;
    public float height;
    public boolean onscreen;
    public Tree(float x,float y,String path,String path_snow){
        onscreen=true;
        this.x=x;
        this.y=y;
        texture=new Texture(Gdx.files.internal(path));
        texture_snow=new Texture(Gdx.files.internal(path_snow));
        width=Gdx.graphics.getWidth()/8;
        height=texture.getHeight()*(width/texture.getWidth());
    }
    public void draw(SpriteBatch batch,boolean winter){
//        batch.begin();
        if(winter){
            batch.draw(texture_snow,x,y,width,height);
        }else
        batch.draw(texture,x,y,width,height);
//        batch.end();
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
