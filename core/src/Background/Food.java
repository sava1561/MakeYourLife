package Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Main;

import Player.Player;

/**
 * Created by Sava on 24.03.2016.
 */
public class Food {
    public Texture texture;
    public float x,y,width,height;
    public int count;
    public BitmapFont font;
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public Food(Home home,final Main main){
        count=20;
        texture=main.manager.get("background/food_icon.png",Texture.class);
        width=home.width/15;
        height=texture.getHeight() * (width / texture.getWidth());
        x=home.position.x+home.width/2-2*width;
        y=home.position.y+home.height+home.height/6;
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Comfortaa-Regular.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.WHITE;
        parameter.size = Gdx.graphics.getWidth() / 45;
        parameter.borderColor=Color.WHITE;
        parameter.borderWidth=parameter.size/17;
        font = generator.generateFont(parameter);
    }
    public void draw(SpriteBatch batch,Player player){
        if(player.athome) {
            batch.draw(texture, x, y, width, height);
            font.draw(batch, Integer.toString(count) + "/30", x + 3 * width / 2, y+height-height/4);
        }
    }

}
