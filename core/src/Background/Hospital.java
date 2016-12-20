package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;

import Player.Player;
import Player.Variants;

/**
 * Created by Sava on 24.03.2016.
 */
public class Hospital {
    public Texture texture,texture_snow;
    public Vector2 position;
    public float width;
    public float height;
    public boolean onscreen;
    public boolean varExists;
    public Variants doctor,full,part;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Vector2 touchpos;
    public Hospital(float x,Player player,final Main main){
        position=new Vector2();
        touchpos=new Vector2();
        onscreen=true;
        texture=main.manager.get("background/hospital.png",Texture.class);
        texture_snow=main.manager.get("background/hospital_snow.png",Texture.class);
        width=7* Gdx.graphics.getWidth()/10;
        height= texture.getHeight()*(width/texture.getWidth());
        position.x=x;
        position.y=Gdx.graphics.getHeight()/4;
        full = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "circles/full.png");
        internet = new Variants(player.position.x - 9 * player.height / 4,  player.position.y + 2 * player.width / 3, 8 * player.height / 4, "circles/internet.png");
        smoke = new Variants(player.position.x - 9 * player.height / 4, internet.y + internet.height + internet.height / 2, 8 * player.height / 4, "circles/smoke.png");
        doctor = new Variants(full.x,smoke.y + smoke.height + smoke.height / 2, 8 * player.height / 4, "circles/doctor.png");
        part=new Variants(player.position.x + player.width + player.height / 4, smoke.y, 8 * player.height / 4, "circles/part.png");
        call = new Variants(internet.x, doctor.y, 8 * player.height / 4, "circles/call.png");
    }
    public void update(Player player) {
        full.x = player.position.x + player.width + player.height / 4;
        smoke.x = player.position.x - 9 * player.height / 4;
        internet.x = player.position.x - 9 * player.height / 4;
        call.x = internet.x;
        doctor.x =full.x ;
        part.x=player.position.x + player.width + player.height / 4;
    }
    public void ontouch(float x, float width, float y, Arrows arrows) {
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= this.position.x && touchpos.x <= this.position.x + this.width && touchpos.y >= Gdx.graphics.getHeight() - this.height - this.position.y && touchpos.y <= Gdx.graphics.getHeight() - this.position.y) {
                if (varExists == true) {
                    varExists = false;
                    touchpos.set(0, 0);
                } else {
                    varExists = true;
                    touchpos.set(0, 0);
                    arrows.back = arrows.previous;
                    arrows.previous = "middle";
                }
            }
        }
    }
    public void update(float pos){
        if(position.x>pos+Gdx.graphics.getWidth()/2 && position.x+width<pos-Gdx.graphics.getWidth()/2){
            onscreen=false;
        }else {
            onscreen=true;
        }
    }
    public void draw(SpriteBatch batch,boolean winter){
        if(winter){
            batch.draw(texture_snow,position.x,position.y,width,height);
        }else
        batch.draw(texture,position.x,position.y,width,height);
    }
    public void drawVariants(SpriteBatch batch, Player player) {
        if (varExists) {
            if (player.varExist)
                player.varExist = false;
            doctor.draw(batch);
            full.draw(batch);
            smoke.draw(batch);
            call.draw(batch);
            internet.draw(batch);
            part.draw(batch);
        }
    }
}
