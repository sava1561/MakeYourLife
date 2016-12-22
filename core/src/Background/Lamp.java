package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Support.Texture;

/**
 * Created by Roman on 21.12.2016.
 */
public class Lamp {
    private Texture textureOn;
    private Texture textureOff;
    public static boolean on = false;
    public Lamp(float x) {
        textureOn = new Texture("background/lamp.png", x, Gdx.graphics.getHeight() / 8, 14 * Gdx.graphics.getWidth() / 30, 0);
        textureOff = new Texture("background/lampOff.png", x, Gdx.graphics.getHeight() / 8, 13 * Gdx.graphics.getWidth() / 30, 0);
    }

    public void draw(SpriteBatch batch) {
        if(on) {
            textureOn.draw(batch);
        }else {
            textureOff.draw(batch);
        }

    }

}
