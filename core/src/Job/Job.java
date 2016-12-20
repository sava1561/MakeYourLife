package Job;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import Support.Texture;

/**
 * Created by Roman on 20.12.2016.
 */
public class Job {
    public Texture texture;
    public int type = -1; //0-кассир1 1-кассир2 2-кассир3 3-кассир4
    public int choosed = -1;//-1-defaul 0-yes 1-no
    public Job(int type, float x) {
        this.type = type;
        texture = new Texture("job/" + type + ".png", x - 15 * Gdx.graphics.getWidth() / 60, 12 * Gdx.graphics.getHeight() / 30, 15 * Gdx.graphics.getWidth() / 30, Gdx.graphics.getHeight() / 3);
    }

    public void draw(SpriteBatch batch) {
        texture.draw(batch);
    }

    public void ontouch(float x, float width, float y) {
        if (Gdx.input.justTouched()) {
            Vector2 touchpos = new Vector2();
            touchpos.x = Gdx.input.getX() + x - Gdx.graphics.getWidth() / 2 + width / 2;
            touchpos.y = Gdx.graphics.getHeight()-Gdx.input.getY();
            if(touchpos.x >= texture.getX()+texture.getWidth()/3 && touchpos.x <= texture.getWidth()/3+texture.getX()+texture.getWidth()/5){
                if (touchpos.y >= texture.getY() && touchpos.y <= texture.getY()+texture.getHeight()/4) {
                    System.out.println("Yes");
                    choosed = 0;
                }
            }else if(touchpos.x <= texture.getWidth()+texture.getX()-texture.getWidth()/3 && touchpos.x >= texture.getWidth()-texture.getWidth()/3+texture.getX()-texture.getWidth()/5){
                Gdx.app.log(""+touchpos.x,""+texture.getY());
                if (touchpos.y >= texture.getY() && touchpos.y <= texture.getY()+texture.getHeight()/4) {
                    choosed = 1;
                    System.out.println("No");
                }
            }
        }
    }

}
