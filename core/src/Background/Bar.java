package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Roman on 15.08.2016.
 */
public class Bar {
    public Texture texture, texture_snow;
    public float x;
    public float y;
    public float width;
    public float height;

    public Bar(float x) {
        texture = new Texture(Gdx.files.internal("background/bar.png"));
        texture_snow = new Texture(Gdx.files.internal("background/bar_snow.png"));
        this.x = x;
        y = Gdx.graphics.getHeight() / 4;
        width = 8 * Gdx.graphics.getWidth() / 35;
        height = texture.getHeight() * (width / texture.getWidth());
    }

    public void draw(SpriteBatch batch, boolean winter) {
        if (winter) {
            batch.draw(texture_snow, x, y, width, height);
        } else
            batch.draw(texture, x, y, width, height);
    }
}
