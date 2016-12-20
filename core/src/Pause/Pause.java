package Pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import Background.Arrows;

/**
 * Created by Roman on 14.07.2016.
 */
public class Pause {
    public Texture texture,resume,sound;
    public Vector2 touchpos;
    public float x,y,width,height,r_width,r_height,s_width,s_height;
    public float r_x,r_y,s_x,s_y;
    public boolean unpause=false;
    public Pause(){
        width= 6*Gdx.graphics.getWidth()/16;
        texture=new Texture(Gdx.files.internal("background/pause.png"));
        resume=new Texture(Gdx.files.internal("menu/4.png"));
        sound=new Texture(Gdx.files.internal("menu/5.png"));
        r_width=width/2;
        r_height=(resume.getHeight()*(r_width/resume.getWidth()));
        height=(texture.getHeight()*(width/texture.getWidth()));
        x=Gdx.graphics.getWidth()/2-width/2;
        y=Gdx.graphics.getHeight()/2-height/2;
        touchpos=new Vector2();
        r_x=x+width/2-r_width/2;
        r_y=y+height/2-r_height/2;
        s_width=r_width/3;
        s_height=sound.getHeight()*(s_width/sound.getWidth());
        s_x=x+s_width/2;
        s_y=y+s_height/2;
    }
    public void draw(SpriteBatch batch){
        r_x=x+width/2-r_width/2;
        r_y=y+height/2-r_height/2;
        s_x=x+s_width/2;
        s_y=y+s_height/2;
        batch.draw(texture,x,y,width,height);
        batch.draw(resume,x+width/2-r_width/2,y+height/2-r_height/2,r_width,r_height);
        batch.draw(sound,s_x,s_y,s_width,s_height);
    }
    public void ontouch(float x, float width, float y, Arrows arrows) {
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= this.r_x && touchpos.x <= this.r_x + this.r_width && touchpos.y >= Gdx.graphics.getHeight() - this.r_height - this.r_y && touchpos.y <= Gdx.graphics.getHeight() - this.r_y) {
                unpause=true;
            }
        }
    }

}
