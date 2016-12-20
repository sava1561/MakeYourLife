package Notification;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

import Background.Arrows;
import Background.Background;
import Player.Player;

/**
 * Created by Roman on 18.08.2016.
 */
public class Notification {
    public Texture texture;
    public float x,y,width,height;
    public static boolean exists,exists1;
    public ArrayList<Texture> notices;
    public Vector2 touchpos;
    public Timer tm;
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public BitmapFont font;
    public int situation;
    public Notification(){
        situation=0;
        tm=new Timer();
        exists=exists1=false;
        width=6*Gdx.graphics.getWidth()/10; //1-1/2
        x=Gdx.graphics.getWidth()/2-width/2;
        exists=false;
        notices=new ArrayList<Texture>();
        notices.add(new Texture(Gdx.files.internal("notice/eat1.png")));//0
        height=notices.get(0).getHeight() * (width / notices.get(0).getWidth());
        y=Gdx.graphics.getHeight()/2-height/2+height/8;
        notices.add(new Texture(Gdx.files.internal("notice/health.png")));
        notices.add(new Texture(Gdx.files.internal("notice/sleep.png")));
        notices.add(new Texture(Gdx.files.internal("notice/uni1.png")));
        notices.add(new Texture(Gdx.files.internal("notice/stole.png")));//4
        notices.add(new Texture(Gdx.files.internal("notice/purse.png")));//5
        notices.add(new Texture(Gdx.files.internal("notice/safe.png")));//6
        notices.add(new Texture(Gdx.files.internal("notice/shot.png")));//7
        notices.add(new Texture(Gdx.files.internal("notice/broke.png")));//8
        notices.add(new Texture(Gdx.files.internal("notice/fridge.png")));//9
        notices.add(new Texture(Gdx.files.internal("notice/lost_money.png")));//10
        notices.add(new Texture(Gdx.files.internal("notice/no_jobs.png")));
        notices.add(new Texture(Gdx.files.internal("notice/got_job.png")));//12
        touchpos=new Vector2();
        generator=new FreeTypeFontGenerator(Gdx.files.internal("font/Roboto-Light.ttf"));
        parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color= Color.WHITE;
        parameter.size=Gdx.graphics.getWidth()/23;
        parameter.borderWidth=parameter.size/20;
        parameter.borderColor=Color.WHITE;
        font=generator.generateFont(parameter);
    }
    public void draw(SpriteBatch batch,int situation){
        if(exists==true && situation!=-1 && exists1==true) {
            if(this.situation!=situation){
                this.situation=situation;
            }
            batch.draw(notices.get(situation), x, y, width, height);
        }
    }
    public void draw(SpriteBatch batch,int situation,int money){
        if(exists==true && situation!=-1 && exists1==true) {
            batch.draw(notices.get(situation), x, y, width, height);
            font.draw(batch,"+"+money+"$",x+width/2-width/14,y+height/2);
            if(this.situation!=situation){
                this.situation=situation;
            }
        }

    }
    public void update(float x){
        this.x=x-width/2;
    }
    public void ontouch(float x, float width, float y, Arrows arrows,Background background) {
        if(exists)
            if (Gdx.input.justTouched()) {
                touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
                touchpos.y = Gdx.input.getY();
                if (touchpos.x >= this.x && touchpos.x <= this.x + this.width && touchpos.y >= Gdx.graphics.getHeight() - this.height - this.y && touchpos.y <= Gdx.graphics.getHeight() - this.y) {
                    if(situation==6 || situation==7 || situation == 11 || situation == 12){
                        background.unpause_unlistened();
                    }else
                    background.moneyStolen=0;
                    exists=false;
                    if(tm.isEmpty())
                    tm.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            exists1=false;
                        }
                    },20);
                }
            }
    }

}
