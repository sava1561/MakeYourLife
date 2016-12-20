package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sava on 18.04.2016.
 */
public class Stamina {
    public float width,width1;
    public float height;
    public float x,y;
    public Player player;
    public Texture shape;
    public Texture filler;
    public Texture back_filler;
    public Stamina(Player player){
        this.player=player;
        width=(float)(player.width*1.5);
        width1=width;
        height=player.height/20;
        x=player.position.x+player.width/2-width/2;
        y=player.position.y+height+player.height;
        shape=new Texture(Gdx.files.internal("background/shape.png"));
        filler=new Texture(Gdx.files.internal("background/rectangle1.png"));
        back_filler=new Texture(Gdx.files.internal("background/back_filler.png"));

    }
    public void draw(SpriteBatch batch){
        if(width1<width){
            if(!player.sitting1)
            width1+=width/270;
            else{
                width1+=width/220;
            }
        }
        if(player.runningR || player.runningL){
            if(width1>0) {
                width1 -= width / 150;
            }
        }
        batch.draw(back_filler,x,y,width,height);
        batch.draw(filler,x,y,width1,height);
        batch.draw(shape,x,y,width,height);
        update();
    }
    public void update(){
        if(player.movingRight) {
            x = player.position.x + player.width / 2 - width / 2 + player.width / 7;
        }else if(player.movingLeft){
            x = player.position.x + player.width / 2 - width / 2 - player.width / 7;
        }else if(player.runningL){
            x = player.position.x + player.width / 2 - width / 2-player.width/7;
        }else{
            x = player.position.x + player.width / 2 - width / 2+player.width/7;
        }
        y=player.position.y+height+player.height;
    }
}
