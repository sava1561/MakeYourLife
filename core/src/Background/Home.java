package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;

import Player.Player;
import Player.Variants;


public class Home {
    public int food, maxfood;
    public boolean gohome;
    public boolean onscreen;
    public Texture texture;
    public Vector2 position;
    public float width;
    public float height;
    public boolean varExists;
    public Variants go, go1;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Vector2 touchpos;

    public Home(Player player,final Main main) {
        food = 20;
        maxfood = 30;
        gohome = false;
        onscreen = true;
        texture=main.manager.get("background/home.png",Texture.class);
        width = 5 * Gdx.graphics.getWidth() / 15;
        height = texture.getHeight() * (width / texture.getWidth());
        position = new Vector2();
        position.x = Gdx.graphics.getWidth() / 2 - width / 2;
        position.y = Gdx.graphics.getHeight() / 4;
        touchpos = new Vector2();
        go = new Variants(player.position.x - 9 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/goMarket.png");
        go1 = new Variants(go.x + go.width / 2 + player.height / 4 + player.width / 2, go.y + player.height, 8 * player.height / 4, "background/goMarket.png");
        smoke = new Variants(player.position.x - 9 * player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/smoke.png");
        call = new Variants(player.position.x + player.width + player.height / 4, go.y, 8 * player.height / 4, "circles/call.png");
        internet = new Variants(call.x, smoke.y, 8 * player.height / 4, "circles/internet.png");
    }

    public void draw(SpriteBatch batch) {
//        batch.begin();
        batch.draw(texture, position.x, position.y, width, height);
//        batch.end();

    }

    public void update(float pos) {
        onscreen = !(position.x > pos + Gdx.graphics.getWidth() / 2 || position.x + width < pos - Gdx.graphics.getWidth() / 2);
    }

    public void update(Player player) {
        go.x = player.position.x - 8 * player.height / 4;
        smoke.x = player.position.x - 8 * player.height / 4;
        call.x = player.position.x + player.width + player.height / 4;
        internet.x = call.x;
        go1.x = go.x + go.width / 2 + player.height / 4 + player.width / 2;
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
            batch.draw(go.circle, go.x, go.y, go.width, go.height);
            smoke.draw(batch);
            call.draw(batch);
            internet.draw(batch);

//            player.movingRight = false;
//            player.movingLeft = false;
//            if (!player.withFood)
//                player.texture = player.stay;
//            else {
//                player.texture = player.stayWithFood;
//            }
//            player.speed = 0;
//            player.speed1 = 0;
        }
    }

    public void dispose() {
        texture.dispose();
    }
}
