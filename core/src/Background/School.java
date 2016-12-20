package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import Player.Player;
import Player.Variants;

/**
 * Created by Sava on 29.02.2016.
 */
public class School {
    public Texture texture,texture_snow;
    public Vector2 position;
    public float width;
    public float height;
    public boolean onscreen;
    public boolean varExists;
    public Variants go, go1;
    public Variants job, job1;
    public Variants Robb, Robb1;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Vector2 touchpos;

    public School(float x, Player player) {
        onscreen = true;
        texture = new Texture(Gdx.files.internal("background/school.png"));
        texture_snow = new Texture(Gdx.files.internal("background/school_snow.png"));
        position = new Vector2();
        position.x = x;
        position.y = Gdx.graphics.getHeight() / 4;
        width = 7 * Gdx.graphics.getWidth() / 10;
        height = texture.getHeight() * (width / texture.getWidth());
        touchpos = new Vector2();
        go = new Variants(player.position.x - 8 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "circles/study.png");
        job = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/jobMarket.png");
        Robb = new Variants(player.position.x + player.width / 2 - 7 * player.height / 8, 5 * player.position.y / 4 + player.height, 8 * player.height / 4, "circles/lesson.png");
        go1 = new Variants(player.position.x - 8 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "circles/study.png");
        job1 = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/jobMarket.png");
        smoke = new Variants(player.position.x - 8 * player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/smoke.png");
        Robb1 = new Variants(smoke.x, smoke.y + smoke.height + smoke.height / 2, 8 * player.height / 4, "circles/lesson.png");
        call = new Variants(player.position.x + player.width + player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/call.png");
        internet = new Variants(call.x, Robb1.y, 8 * player.height / 4, "circles/internet.png");
    }

    public void update(float pos) {
        onscreen = !(position.x > pos + Gdx.graphics.getWidth() / 2 && position.x + width < pos - Gdx.graphics.getWidth() / 2);
    }

    public void draw(SpriteBatch batch, boolean winter) {
        if(winter){
            batch.draw(texture_snow, position.x, position.y, width, height);
        }else
        batch.draw(texture, position.x, position.y, width, height);

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

    public void ontouch(float x, float width, float y, Arrows arrows) {
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= this.position.x && touchpos.x <= this.position.x + this.width && touchpos.y >= Gdx.graphics.getHeight() - this.height - this.position.y && touchpos.y <= Gdx.graphics.getHeight() - y) {
                if (varExists) {
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

    public void drawVariants(SpriteBatch batch, Player player) {
        if (varExists) {
            if (player.varExist)
                player.varExist = false;
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
