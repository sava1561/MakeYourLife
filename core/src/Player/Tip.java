package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Background.Background;

/**
 * Created by Roman on 23.07.2016.
 */
public class Tip {
    public Texture pause_tip,arrow;
    public float p_x,p_y,p_w,p_h,x,y,width,height;
    public int num=0;
    public Tip(){
        pause_tip=new Texture("tips/tip.png");
        p_w= Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/20;
        p_x=Gdx.graphics.getWidth()/2-p_w/2;
        p_h=pause_tip.getHeight() * (p_w / pause_tip.getWidth());
        p_y=Gdx.graphics.getHeight()/3-p_h/10;
//        arrow=new Texture(Gdx.files.internal("tips/arrow.png"));
//        width=p_w/3;
//        height=arrow.getHeight() * (width / arrow.getWidth());
//        x=p_x+p_w/2-Gdx.graphics.getWidth()/2;
//        y=Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/8-height;
    }
    public void draw(SpriteBatch batch,Background background){
        if(num!=7) {
            if(background.make_ontouch==true)
                background.make_ontouch=false;
            batch.draw(pause_tip, p_x, p_y, p_w, p_h);
            ontouch(background);

        }
//        batch.draw(arrow,x,y,width,height);
    }
    public void ontouch(Background background){
        if(Gdx.input.justTouched()){
            if(num==0){
                pause_tip=new Texture("tips/tip1.png");
                num++;
            }else if(num==1){
                pause_tip=new Texture("tips/tip2.png");
                num++;
            }else if(num==2){
                pause_tip=new Texture("tips/tip3.png");
                num++;
            }else if(num==3){
                pause_tip=new Texture("tips/tip4.png");
                num++;
            }else if(num==4){
                pause_tip=new Texture("tips/tip5.png");
                num++;
            }else if(num==5){
                pause_tip=new Texture("tips/tip6.png");
                num++;
            }else{
                background.make_ontouch=true;
                num++;
            }
        }
    }
}
