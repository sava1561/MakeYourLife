package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import Player.Player;
import Player.Variants;

/**
 * Created by Sava on 18.04.2016.
 */
public class PoliceDep {
    public boolean varExists;
    public Variants go, go1;
    public Variants job, job1;
    public Variants Robb, Robb1;
    public Variants smoke;
    public Variants call;
    public Variants internet;
    public Vector2 touchpos;
    public boolean onscreen;
    public Texture texture;
    public float x;
    public float y;
    public float width;
    public float height;

    public PoliceDep(Player player,float x) {
        onscreen = true;
        texture = new Texture(Gdx.files.internal("background/police_department.png"));
        width = 6*Gdx.graphics.getWidth() /8;
        height = texture.getHeight() * (width / texture.getWidth());
        this.x = x;
        y = Gdx.graphics.getHeight() / 4;
        touchpos = new Vector2();
        go = new Variants(player.position.x - 9 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/goMarket.png");
        job = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/jobMarket.png");
        Robb = new Variants(player.position.x + player.width / 2 - 7 * player.height / 8, 5 * player.position.y / 4 + player.height, 8 * player.height / 4, "background/robbMarket.png");
        go1 = new Variants(player.position.x - 9 * player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/goMarket.png");
        job1 = new Variants(player.position.x + player.width + player.height / 4, player.position.y + 2 * player.width / 3, 8 * player.height / 4, "background/jobMarket.png");
        smoke = new Variants(player.position.x - 9 * player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/smoke.png");
        Robb1 = new Variants(smoke.x, smoke.y + smoke.height + smoke.height / 2, 7 * player.height / 4, "background/robbMarket.png");
        call = new Variants(player.position.x + player.width + player.height / 4, go.y + go.height + go.height / 2, 8 * player.height / 4, "circles/call.png");
        internet = new Variants(call.x, Robb1.y, 8 * player.height / 4, "circles/internet.png");
    }

    public void draw(SpriteBatch batch,Player player) {
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
}
