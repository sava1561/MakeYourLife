package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Sava on 09.03.2016.
 */
public class Money {
    public Texture texture;
    public float x,x1;
    public float y,y1,y2;
    public float width;
    public float height;
    public long money;
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public BitmapFont font;
    public BitmapFont minus;
    public float time,time1;
    public Timer tm;
    public String minusFUUCK;
//    public int count=0;
    public Money(float x,float y){

        tm=new Timer();
        time=0.002f;
        time1=0.002f;
//        texture=new Texture(Gdx.files.internal("background/money.png"));
        this.x=x;
        this.y=y;
        x1=x;
        y2=y1=y-Gdx.graphics.getHeight()/16;
//        this.width=width;
//        height=texture.getHeight() * (width / (texture.getWidth()));
        money=100;
        generator=new FreeTypeFontGenerator(Gdx.files.internal("font/Roboto-Light.ttf"));
        parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color= Color.WHITE;
        parameter.size=Gdx.graphics.getWidth()/62;
        parameter.borderWidth=parameter.size/20;
        parameter.borderColor=Color.WHITE;
        font=generator.generateFont(parameter);
        parameter.color= Color.GOLD;
        parameter.borderColor=Color.GOLD;
        parameter.size=Gdx.graphics.getWidth()/10;
        parameter.borderWidth=parameter.size/15;
        minus=generator.generateFont(parameter);
    }
    public void draw(SpriteBatch batch,int minus1,int plus1){
//        batch.draw(texture,x,y,width,height);
        font.draw(batch, "$" + Long.toString(money), x-font.getSpaceWidth()*Long.toString(money).length()/2, y);
        if(plus1!=0){
            minus.draw(batch, "+"+plus1 + " $", x1, y2);
            time1+=0.02f;
            drawPlusAnimation();
        }else{
            time1=0.005f;
            y2=y-Gdx.graphics.getHeight()/16;
        }
        if(minus1!=0) {
            minusFUUCK=Integer.toString(minus1);
//            System.out.println(minusFUUCK);
            minus.draw(batch," – "+minusFUUCK+" $",x1,y1);
            time+=0.02f;
            drawMinusAnimation();
        }else{
            time=0.02f;
            y1=y-Gdx.graphics.getHeight()/16;
        }
    }
    public void drawMinusAnimation(){
        tm.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                y1 += Gdx.graphics.getHeight() / 150;
            }
        }, time);
    }
    public void drawPlusAnimation(){
//        if(tm.isEmpty())
        tm.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                y2+=Gdx.graphics.getHeight()/150;
            }
        },time1);
    }
}
