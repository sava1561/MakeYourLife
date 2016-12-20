package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Main;

import java.util.ArrayList;

import Weather.Weather;


public class Sky {
    public ArrayList<Texture> fone;
    public Texture currentFone;
    public ArrayList<Texture>skies;
    public ShapeRenderer sr;
    public Texture texture;
    public Texture town,town_snow;
    public float t_x,t_y;
    public float t_width;
    public float t_height;
    public float width;
    public float height;
    public float y;
    public float x;
    public boolean onscreen;
    public Sky(float x,float t_x,Main main) {
        onscreen=true;
        texture = new Texture(Gdx.files.internal("background/sky.png"));
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        y = Gdx.graphics.getHeight() / 4;
        this.x = x;
        town=new Texture(Gdx.files.internal("background/town.png"));
        town_snow=new Texture(Gdx.files.internal("background/town_snow.png"));
        this.t_x=t_x;
        t_y=Gdx.graphics.getHeight()/4;
        t_width=Gdx.graphics.getWidth();
        t_height=6*town.getHeight()*(t_width/town.getWidth())/7;
        sr=new ShapeRenderer();
        skies=new ArrayList<Texture>();
        for(int i=1;i<15;i++)
            skies.add(main.manager.get("sky/"+i+".png",Texture.class));
//        t_height*=6/7;
        fone=new ArrayList<Texture>();
        for(int i=1;i<14;i++){
            fone.add(main.manager.get("skies/"+i+".png",Texture.class));
        }

    }

    public void draw(SpriteBatch batch,boolean winter) {
        batch.draw(texture, x, y, width, height);
        if(winter){
            batch.draw(town_snow, t_x, t_y, t_width, t_height);
        }else {
            batch.draw(town, t_x, t_y, t_width, t_height);
        }
    }
    public void drawFone(SpriteBatch batch){
        if(currentFone!=null)
            batch.draw(currentFone, x, 0, width , Gdx.graphics.getHeight());

    }
//    public void drawSky(int hour){
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        if(hour>=12 && hour <= 14) {
//            sr.setColor(18f, 204f, 244f, 1);
//        }
//        if(hour>14 && hour<=16){
//            sr.setColor(32f, 184f, 216f, 1);
//        }
//        if(hour>16 && hour<=18){
//            sr.setColor(30f, 144f, 168f, 1);
//        }
//        if(hour>=18 && hour<22){
//            sr.setColor(27f, 110f, 128f, 1);
//        }
//        if(hour>=22 && hour<=3){
//            sr.setColor(17f, 73f, 85f, 1);
//        }
//        if(hour>=4 && hour<6){
//            sr.setColor(19f, 99f, 116f, 1);
//        }
//        if(hour>=6 && hour<=11){
//            sr.setColor(32f, 170f, 200f, 1);
//        }
//        sr.rect(x, y, width,height);
//        sr.end();
//    }
    public void update(float pos){
        if(x>pos+Gdx.graphics.getWidth()/2 || x+width<pos-Gdx.graphics.getWidth()/2){
            onscreen=false;
        }else {
            onscreen=true;
        }
    }
    public void changeSky(Time time){
        if(time.hour>=10 && time.hour<=11){
            texture=skies.get(0);
            currentFone=null;
        }else if(time.hour>11&&time.hour<=12){
            texture=skies.get(1);
            currentFone=null;
//            currentFone=fone.get(12);
        }else if(time.hour>12&& time.hour<=13){
            texture=skies.get(2);
            currentFone=null;
//            currentFone=fone.get(11);
        }else if(time.hour>13&&time.hour<=14||(time.hour>9 && time.hour<=10)){
            texture=skies.get(3);
            currentFone=fone.get(12);
        }else if(time.hour>14&&time.hour<=15||(time.hour>8 && time.hour<=9)){
            texture=skies.get(4);
            currentFone=fone.get(11);
        }else if(time.hour>15&&time.hour<=16||(time.hour>7 && time.hour<=8)){
            texture=skies.get(5);
            currentFone=fone.get(10);
        }else if(time.hour>16&&time.hour<=17||(time.hour>6 && time.hour<=7)){
            texture=skies.get(6);
            currentFone=fone.get(9);
        }else if(time.hour>17&&time.hour<=18||(time.hour>5 && time.hour<=6)){
            texture=skies.get(7);
            currentFone=fone.get(8);
        }else if(time.hour>18&&time.hour<=19||(time.hour>4 && time.hour<=5)){
            texture=skies.get(8);
            currentFone=fone.get(7);
        }else if(time.hour>19&&time.hour<=20||(time.hour>3 && time.hour<=4)){
            texture=skies.get(9);
            currentFone=fone.get(6);
        }else if(time.hour>20&&time.hour<=21||(time.hour>2 && time.hour<=3)){
            texture=skies.get(10);
            currentFone=fone.get(5);
        }else if(time.hour>21&&time.hour<=22||(time.hour>1 && time.hour<=2)){
            texture=skies.get(11);
            currentFone=fone.get(4);
        }else if(time.hour>22&&time.hour<=23 ||(time.hour>0 && time.hour<=1)){
            texture=skies.get(12);
            currentFone=fone.get(3);
        }else if(time.hour>23&&time.hour<=24){
            texture=skies.get(13);
            currentFone=fone.get(2);
        }
    }
    public void dispose(){
        texture.dispose();
    }
}
