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
public class Cafe {
    public boolean varExists;
    public Variants go, go1;
    public Variants job, job1;
    public Variants Robb, Robb1;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Vector2 touchpos;
    public boolean onscreen;
    public Texture texture,texture_snow;
    public float x;
    public float y;
    public float width;
    public float height;
    public boolean stealed=false;
    public Cafe(Player player,final Main main) {
        onscreen = true;
        texture = main.manager.get("background/cafe.png",Texture.class);
        texture_snow=main.manager.get("background/cafe_snow.png",Texture.class);
        width = 8 * Gdx.graphics.getWidth() / 35;
        height = texture.getHeight() * (width / texture.getWidth());
        x = Gdx.graphics.getWidth() + width + Gdx.graphics.getWidth() / 12 + 3 * Gdx.graphics.getWidth() / 8;
        y = Gdx.graphics.getHeight() / 4;
        touchpos = new Vector2();
        go = new Variants(player.position.x - 9 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/goMarket.png");
        job = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/jobMarket.png");
        Robb = new Variants(player.position.x + player.width / 2 - 7 * player.height / 8, 5 * player.position.y / 4 + player.height, 8 * player.height / 4, "background/robbMarket.png");
        go1 = new Variants(player.position.x - 9 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/goMarket.png");
        job1 = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/jobMarket.png");
        smoke = new Variants(player.position.x - 9 * player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/smoke.png");
        Robb1 = new Variants(smoke.x, smoke.y + smoke.height + smoke.height / 2, 8 * player.height / 4, "background/robbMarket.png");
        call = new Variants(player.position.x + player.width + player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/call.png");
        internet = new Variants(call.x, Robb1.y, 8 * player.height / 4, "circles/internet.png");
    }

    public void draw(SpriteBatch batch,boolean winter) {
        if(winter){
            batch.draw(texture_snow, x, y, width, height);
        }else
        batch.draw(texture, x, y, width, height);
    }

    public void update(float pos) {
        if (x > pos + Gdx.graphics.getWidth() / 2 || x + width < pos - Gdx.graphics.getWidth() / 2) {
            onscreen = false;
        } else {
            onscreen = true;
        }
    }
    public void update(Player player) {
        go.x = player.position.x - 8 * player.height / 4;
        job.x = player.position.x + player.width + player.height / 4;
        Robb.x = player.position.x + player.width / 2 - 7 * player.height / 8;
        go1.x = player.position.x - 8 * player.height / 4;
        job1.x = player.position.x + player.width + player.height / 4;
        Robb1.x = smoke.x;
        smoke.x = player.position.x - 8 * player.height / 4;
        call.x = player.position.x + player.width + player.height / 4;
        internet.x = call.x;
    }
    public void ontouch(float x, float width,float y,Arrows arrows) {
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= this.x && touchpos.x <= this.x + this.width && touchpos.y >= Gdx.graphics.getHeight() - this.height - this.y && touchpos.y <= Gdx.graphics.getHeight() - y) {
                if (varExists == true) {
                    varExists = false;touchpos.set(0,0);
                } else {
                    varExists = true;touchpos.set(0,0);
                    arrows.back=arrows.previous;
                    arrows.previous="middle";
                }
            }
        }
    }
    public void drawVariants(SpriteBatch batch,Player player){
        if (varExists) {
            if(player.varExist)
                player.varExist=false;

                batch.draw(go1.circle, go1.x, go1.y, go1.width, go1.height);
                batch.draw(job1.circle, job1.x, job1.y, job1.width, job1.height);
                batch.draw(Robb1.circle, Robb1.x, Robb1.y, Robb1.width, Robb1.height);
                smoke.draw(batch);
                call.draw(batch);
                internet.draw(batch);
//            player.movingRight = false;
//            player.movingLeft = false;
//            player.texture = player.stay;
//            player.speed = 0;
//            player.speed1 = 0;
        }
    }

    public void dispose() {
        texture.dispose();
    }
}
