package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;

import Player.Player;
import Player.Variants;

/**
 * Created by Sava on 29.02.2016.
 */
public class Bench {
    public boolean free;
    public boolean onscreen;
    public static Texture texture,texture_snow;
    public float x;
    public float y;
    public static float width;
    public static float height;
    public boolean varExists;
    public Variants sit, sit1;
    public Variants lie, lie1;
    public Variants look, look1;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Vector2 touchpos;
    public Bench(float x,Player player,Main main){
        free=true;
        onscreen=true;
        texture=main.manager.get("background/bench.png",Texture.class);
        texture_snow=main.manager.get("background/bench_snow.png",Texture.class);
        this.x=x;
        width=Gdx.graphics.getWidth()/11;
        height=3*(texture.getHeight()*(width/texture.getWidth()))/4;
        width=Gdx.graphics.getWidth()/6;
        y=Gdx.graphics.getHeight()/4-height/8;
        touchpos = new Vector2();
        sit = new Variants(player.position.x - 8 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "circles/sit.png");
        lie = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3,8 * player.height / 4, "circles/lie.png");
        look = new Variants(player.position.x + player.width / 2 - 7 * player.height / 8, 5 * player.position.y / 4 + player.height, 8 * player.height / 4, "circles/inspect.png");
        sit1 = new Variants(player.position.x - 8 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "circles/sit.png");
        lie1 = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3,8 * player.height / 4, "circles/lie.png");
        smoke = new Variants(player.position.x - 8 * player.height / 4, sit.y + sit.height + sit.height / 2, 8 * player.height / 4, "circles/smoke.png");
        look1 = new Variants(smoke.x, smoke.y + smoke.height + smoke.height / 2, 7 * player.height / 4, "circles/inspect.png");
        call = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3,8 * player.height / 4, "circles/call.png");
        internet = new Variants(player.position.x + player.width + player.height / 4, sit.y + sit.height + sit.height / 2, 8 * player.height / 4, "circles/internet.png");
    }
    public void draw(SpriteBatch batch,boolean winter)
    {
        if(winter){
            batch.draw(texture_snow,x,y,width,height);
        }
        batch.draw(texture,x,y,width,height);
    }
    public void update(float pos){
        if(x>pos+Gdx.graphics.getWidth()/2 || x+width<pos-Gdx.graphics.getWidth()/2){
            onscreen=false;
        }else {
            onscreen=true;
        }
    }
    public void update(Player player) {
        sit.x = player.position.x - 8 * player.height / 4;
        lie.x = player.position.x + player.width + player.height / 4;
        look.x = player.position.x + player.width / 2 - 7 * player.height / 8;
        sit1.x = player.position.x - 8 * player.height / 4;
        lie1.x = player.position.x + player.width + player.height / 4;
        look1.x = smoke.x;
        smoke.x = player.position.x - 8 * player.height / 4;
        call.x = player.position.x + player.width + player.height / 4;
        internet.x = call.x;
    }
    public void ontouch(float x, float width,float y) {
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= this.x && touchpos.x <= this.x + this.width && touchpos.y >= Gdx.graphics.getHeight() - this.height - this.y && touchpos.y <= Gdx.graphics.getHeight() - y-height/6) {
                if (varExists == true) {
                    varExists = false;touchpos.set(0,0);
                } else {
                    varExists = true;touchpos.set(0,0);
                }
            }
        }
    }
    public void drawVariants(SpriteBatch batch,Player player){
        if (varExists) {
            if(player.varExist)
                player.varExist=false;
                batch.draw(sit1.circle, sit1.x, sit1.y, sit1.width, sit1.height);
//                batch.draw(lie1.circle, lie1.x, lie1.y, lie1.width, lie1.height);
//                batch.draw(look1.circle, look1.x, look1.y, look1.width, look1.height);
                smoke.draw(batch);
                call.draw(batch);
                internet.draw(batch);
            }
    }
    public void dispose(){
        texture.dispose();
    }
}
