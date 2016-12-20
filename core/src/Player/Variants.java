package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sava on 13.03.2016.
 */
public class Variants {
    public Vector2 touchpos;
    public Texture circle;
    public float x, y;
    public float width, height;
    public boolean touched;
    public Variants(float x, float y, float width, String a) {
        this.x = x;
        this.y = y;
        this.width = width;
        circle = new Texture(Gdx.files.internal(a));
        height = circle.getHeight() * (width / circle.getWidth());
        touchpos = new Vector2();
        touched=false;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(circle, x, y, width, height);
    }

    public void ontouch(Player player) {
        if (Gdx.input.justTouched()) {
            touchpos.x = Gdx.input.getX() + player.position.x - Gdx.graphics.getWidth() / 2 + player.width / 2;
            touchpos.y = Gdx.input.getY();
            if (touchpos.x >= x && touchpos.x <= x + width && touchpos.y >= Gdx.graphics.getHeight() - y - height && touchpos.y <= Gdx.graphics.getHeight() - y) {
                touched=true;
            }
        }
    }

}
