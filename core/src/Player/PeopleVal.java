package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Main;

import java.util.ArrayList;
import java.util.Random;

import Background.Cafe;
import Background.FastFood;
import Background.Market;
import Background.School;

/**
 * Created by Sava on 24.03.2016.
 */
public class PeopleVal {
    public NameGenerator nameGenerator;
    public Cafe cafe;
    public Market market;
    public FastFood ff;
    public School school;
    public ArrayList<Texture> anim, anim1, sitting2, smoking;
    public Random rand;
    public Main main;
    public Texture stay;
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public BitmapFont date, time;

    public PeopleVal(Cafe cafe, Market market, FastFood ff, final Main main, School school) {
        nameGenerator = new NameGenerator();
        anim = new ArrayList<Texture>();
        anim1 = new ArrayList<Texture>();
        sitting2 = new ArrayList<Texture>();
        smoking = new ArrayList<Texture>();
        rand = new Random();
        this.cafe = cafe;
        this.market = market;
        this.ff = ff;
        this.main = main;
        this.school=school;
        stay = new Texture(Gdx.files.internal("IIanim1/stay.png"));
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Roboto-Light.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.GREEN;
        parameter.size = Gdx.graphics.getWidth() / 63;
        parameter.borderColor = Color.GREEN;
        parameter.borderWidth = parameter.size / 20;

    }

    public void create1() {
        smoking = new ArrayList<Texture>();
        for (int i = 28; i < 93; i++) {
            smoking.add(main.manager.get("smoking1/frame-00100" + i + ".png", Texture.class));
        }
    }

    public void create2() {
        anim.add(main.manager.get("IIanim1/frame-0010002.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010003.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010004.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010005.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010006.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010007.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010008.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010009.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010010.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010011.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010012.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010013.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010014.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010015.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010016.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010017.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010018.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010019.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010020.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010021.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010022.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010023.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010024.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010025.png", Texture.class));
        anim.add(main.manager.get("IIanim1/frame-0010026.png", Texture.class));
    }

    public void create3() {
        anim1.add(main.manager.get("IIanim2/frame-0010002.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010003.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010004.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010005.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010006.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010007.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010008.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010009.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010010.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010011.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010012.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010013.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010014.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010015.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010016.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010017.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010018.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010019.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010020.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010021.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010022.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010023.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010024.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010025.png", Texture.class));
        anim1.add(main.manager.get("IIanim2/frame-0010026.png", Texture.class));

        sitting2.add(main.manager.get("IIanim3/00001.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00002.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00003.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00004.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00005.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00006.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00007.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00008.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00009.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00010.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00011.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00012.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00013.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00014.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00015.png", Texture.class));
        sitting2.add(main.manager.get("IIanim3/00016.png", Texture.class));
    }


}
