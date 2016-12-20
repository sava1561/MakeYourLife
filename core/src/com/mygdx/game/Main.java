package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.ArrayList;

public class Main extends Game {
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public GameScreen gs;
	public AssetManager manager;
	public FreeTypeFontGenerator generator;
	public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	public BitmapFont font;
	public ArrayList<Texture> loading_textures;
	public float x,y;
    public Texture t;
    public boolean gs_created=false;
    public static int add=0;
	public Texture logo;
	public float l_x,l_y,l_width,l_height;
	public float load_x,load_y,load_width,load_height;
	public Main(){
	}
	
	@Override
	public void create () {
		loading_textures=new ArrayList<Texture>();
		loading_textures.add(new Texture("loadin/textures.png"));
		loading_textures.add(new Texture("loadin/classes.png"));
		loading_textures.add(new Texture("loadin/weather.png"));
		loading_textures.add(new Texture("loadin/resources.png"));
		load_width=Gdx.graphics.getWidth()/4;
		load_height=loading_textures.get(0).getHeight() * (load_width / loading_textures.get(0).getWidth());
		load_x=Gdx.graphics.getWidth()/2-load_width/2;
		logo=new Texture(Gdx.files.internal("menu/logo1.png"));
		l_width=Gdx.graphics.getWidth()/3;
		l_height=l_width;
		l_x=Gdx.graphics.getWidth()/2-l_width/2;
		l_y=Gdx.graphics.getHeight()/2-l_height/2;
		load_y=l_y-Gdx.graphics.getHeight()/20-load_height*2;
        t=new Texture(Gdx.files.internal("sky/13.png"));
		generator=new FreeTypeFontGenerator(Gdx.files.internal("font/impact.ttf"));
		parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.color= Color.WHITE;
		parameter.size=Gdx.graphics.getWidth()/25;
		parameter.borderWidth=parameter.size/100;
		parameter.borderColor=Color.WHITE;
		font=generator.generateFont(parameter);
		batch=new SpriteBatch();
		camera=new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.setProjectionMatrix(camera.combined);
		manager=new AssetManager();
		manager.load("IIanim1/frame-0010002.png",Texture.class);
		manager.load("IIanim1/frame-0010003.png",Texture.class);
		manager.load("IIanim1/frame-0010004.png",Texture.class);
		manager.load("IIanim1/frame-0010005.png",Texture.class);
		manager.load("IIanim1/frame-0010006.png",Texture.class);
		manager.load("IIanim1/frame-0010007.png",Texture.class);
		manager.load("IIanim1/frame-0010008.png",Texture.class);
		manager.load("IIanim1/frame-0010009.png",Texture.class);
		manager.load("IIanim1/frame-0010010.png",Texture.class);
		manager.load("IIanim1/frame-0010011.png",Texture.class);
		manager.load("IIanim1/frame-0010012.png",Texture.class);
		manager.load("IIanim1/frame-0010013.png",Texture.class);
		manager.load("IIanim1/frame-0010014.png",Texture.class);
		manager.load("IIanim1/frame-0010015.png",Texture.class);
		manager.load("IIanim1/frame-0010016.png",Texture.class);
		manager.load("IIanim1/frame-0010017.png",Texture.class);
		manager.load("IIanim1/frame-0010018.png",Texture.class);
		manager.load("IIanim1/frame-0010019.png",Texture.class);
		manager.load("IIanim1/frame-0010020.png",Texture.class);
		manager.load("IIanim1/frame-0010021.png",Texture.class);
		manager.load("IIanim1/frame-0010022.png",Texture.class);
		manager.load("IIanim1/frame-0010023.png",Texture.class);
		manager.load("IIanim1/frame-0010024.png",Texture.class);
		manager.load("IIanim1/frame-0010025.png",Texture.class);
		manager.load("IIanim1/frame-0010026.png",Texture.class);

		manager.load("IIanim2/frame-0010002.png",Texture.class);
		manager.load("IIanim2/frame-0010003.png",Texture.class);
		manager.load("IIanim2/frame-0010004.png",Texture.class);
		manager.load("IIanim2/frame-0010005.png",Texture.class);
		manager.load("IIanim2/frame-0010006.png",Texture.class);
		manager.load("IIanim2/frame-0010007.png",Texture.class);
		manager.load("IIanim2/frame-0010008.png",Texture.class);
		manager.load("IIanim2/frame-0010009.png",Texture.class);
		manager.load("IIanim2/frame-0010010.png",Texture.class);
		manager.load("IIanim2/frame-0010011.png",Texture.class);
		manager.load("IIanim2/frame-0010012.png",Texture.class);
		manager.load("IIanim2/frame-0010013.png",Texture.class);
		manager.load("IIanim2/frame-0010014.png",Texture.class);
		manager.load("IIanim2/frame-0010015.png",Texture.class);
		manager.load("IIanim2/frame-0010016.png",Texture.class);
		manager.load("IIanim2/frame-0010017.png",Texture.class);
		manager.load("IIanim2/frame-0010018.png",Texture.class);
		manager.load("IIanim2/frame-0010019.png",Texture.class);
		manager.load("IIanim2/frame-0010020.png",Texture.class);
		manager.load("IIanim2/frame-0010021.png",Texture.class);
		manager.load("IIanim2/frame-0010022.png",Texture.class);
		manager.load("IIanim2/frame-0010023.png",Texture.class);
		manager.load("IIanim2/frame-0010024.png",Texture.class);
		manager.load("IIanim2/frame-0010025.png",Texture.class);
		manager.load("IIanim2/frame-0010026.png",Texture.class);

		manager.load("IIanim3/00001.png",Texture.class);
		manager.load("IIanim3/00002.png",Texture.class);
		manager.load("IIanim3/00003.png",Texture.class);
		manager.load("IIanim3/00004.png",Texture.class);
		manager.load("IIanim3/00005.png",Texture.class);
		manager.load("IIanim3/00006.png",Texture.class);
		manager.load("IIanim3/00007.png",Texture.class);
		manager.load("IIanim3/00008.png",Texture.class);
		manager.load("IIanim3/00009.png",Texture.class);
		manager.load("IIanim3/00010.png",Texture.class);
		manager.load("IIanim3/00011.png",Texture.class);
		manager.load("IIanim3/00012.png",Texture.class);
		manager.load("IIanim3/00013.png",Texture.class);
		manager.load("IIanim3/00014.png",Texture.class);
		manager.load("IIanim3/00015.png",Texture.class);
		manager.load("IIanim3/00016.png",Texture.class);
		manager.load("smoking1/frame-0010028.png",Texture.class);
		manager.load("smoking1/frame-0010029.png",Texture.class);
		manager.load("smoking1/frame-0010030.png",Texture.class);
		manager.load("smoking1/frame-0010031.png",Texture.class);
		manager.load("smoking1/frame-0010032.png",Texture.class);
		manager.load("smoking1/frame-0010033.png",Texture.class);
		manager.load("smoking1/frame-0010034.png",Texture.class);
		manager.load("smoking1/frame-0010035.png",Texture.class);
		manager.load("smoking1/frame-0010036.png",Texture.class);
		manager.load("smoking1/frame-0010037.png",Texture.class);
		manager.load("smoking1/frame-0010038.png",Texture.class);
		manager.load("smoking1/frame-0010039.png",Texture.class);
		manager.load("smoking1/frame-0010040.png",Texture.class);
		manager.load("smoking1/frame-0010041.png",Texture.class);
		manager.load("smoking1/frame-0010042.png",Texture.class);
		manager.load("smoking1/frame-0010043.png",Texture.class);
		manager.load("smoking1/frame-0010044.png",Texture.class);
		manager.load("smoking1/frame-0010045.png",Texture.class);
		manager.load("smoking1/frame-0010046.png",Texture.class);
		manager.load("smoking1/frame-0010047.png",Texture.class);
		manager.load("smoking1/frame-0010048.png",Texture.class);
		manager.load("smoking1/frame-0010049.png",Texture.class);
		manager.load("smoking1/frame-0010050.png",Texture.class);
		manager.load("smoking1/frame-0010051.png",Texture.class);
		manager.load("smoking1/frame-0010052.png",Texture.class);
		manager.load("smoking1/frame-0010053.png",Texture.class);
		manager.load("smoking1/frame-0010054.png",Texture.class);
		manager.load("smoking1/frame-0010055.png",Texture.class);
		manager.load("smoking1/frame-0010056.png",Texture.class);
		manager.load("smoking1/frame-0010057.png",Texture.class);
		manager.load("smoking1/frame-0010058.png",Texture.class);
		manager.load("smoking1/frame-0010059.png",Texture.class);
		manager.load("smoking1/frame-0010060.png",Texture.class);
		manager.load("smoking1/frame-0010061.png",Texture.class);
		manager.load("smoking1/frame-0010062.png",Texture.class);
		manager.load("smoking1/frame-0010063.png",Texture.class);
		manager.load("smoking1/frame-0010064.png",Texture.class);
		manager.load("smoking1/frame-0010065.png",Texture.class);
		manager.load("smoking1/frame-0010066.png",Texture.class);
		manager.load("smoking1/frame-0010067.png",Texture.class);
		manager.load("smoking1/frame-0010068.png",Texture.class);
		manager.load("smoking1/frame-0010069.png",Texture.class);
		manager.load("smoking1/frame-0010070.png",Texture.class);
		manager.load("smoking1/frame-0010071.png",Texture.class);
		manager.load("smoking1/frame-0010072.png",Texture.class);
		manager.load("smoking1/frame-0010073.png",Texture.class);
		manager.load("smoking1/frame-0010074.png",Texture.class);
		manager.load("smoking1/frame-0010075.png",Texture.class);
		manager.load("smoking1/frame-0010076.png",Texture.class);
		manager.load("smoking1/frame-0010077.png",Texture.class);
		manager.load("smoking1/frame-0010078.png",Texture.class);
		manager.load("smoking1/frame-0010079.png",Texture.class);
		manager.load("smoking1/frame-0010080.png",Texture.class);
		manager.load("smoking1/frame-0010081.png",Texture.class);
		manager.load("smoking1/frame-0010082.png",Texture.class);
		manager.load("smoking1/frame-0010083.png",Texture.class);
		manager.load("smoking1/frame-0010084.png",Texture.class);
		manager.load("smoking1/frame-0010085.png",Texture.class);
		manager.load("smoking1/frame-0010086.png",Texture.class);
		manager.load("smoking1/frame-0010087.png",Texture.class);
		manager.load("smoking1/frame-0010088.png",Texture.class);
		manager.load("smoking1/frame-0010089.png",Texture.class);
		manager.load("smoking1/frame-0010090.png",Texture.class);
		manager.load("smoking1/frame-0010091.png",Texture.class);
		manager.load("smoking1/frame-0010092.png",Texture.class);
		for(int i=2;i<10;i++){
			manager.load("animation"+"/frame-001000"+i+".png",Texture.class);
			manager.load("animation2"+"/frame-001000"+i+".png",Texture.class);
		}
		for(int i=10;i<25;i++){
			manager.load("animation"+"/frame-00100"+i+".png",Texture.class);
			manager.load("animation2"+"/frame-00100"+i+".png",Texture.class);
		}
		for (int i = 1; i < 10; i++) {
			manager.load("stayUp" + "/0000" + i + ".png", Texture.class);
		}
		for(int i=10;i<37;i++){
			manager.load("stayUp" + "/000" + i + ".png", Texture.class);
		}
		for(int i=1;i<14;i++){
			manager.load("skies/" + i + ".png",Texture.class);
		}
		for(int i=1;i<15;i++)
			manager.load("sky/" + i + ".png", Texture.class);
		manager.load("background/run_left.png",Texture.class);
		manager.load("background/run_right.png",Texture.class);
		manager.load("background/left.png",Texture.class);
		manager.load("background/right.png",Texture.class);
		manager.load("background/stop.png",Texture.class);
		manager.load("background/bench.png",Texture.class);
		manager.load("background/bench_snow.png",Texture.class);
		manager.load("background/bush1.png",Texture.class);
		manager.load("background/bush1_snow.png",Texture.class);
        manager.load("taxi/taxi_right.png",Texture.class);
        manager.load("taxi/taxi_right_transparent.png",Texture.class);
        manager.load("taxi/taxi_left.png",Texture.class);
        manager.load("taxi/taxi_left_transparent.png",Texture.class);
        manager.load("background/puddle.png",Texture.class);
        manager.load("background/drop.png",Texture.class);
        manager.load("background/cafe.png",Texture.class);
		manager.load("background/cafe_snow.png",Texture.class);
        manager.load("background/fastfood.png",Texture.class);
		manager.load("background/fastfood_snow.png",Texture.class);
        manager.load("background/flower1.png",Texture.class);
        manager.load("background/flower2.png",Texture.class);
		manager.load("background/flower1_snow.png",Texture.class);
		manager.load("background/flower2_snow.png",Texture.class);
        manager.load("background/food_icon.png",Texture.class);
        manager.load("background/home.png",Texture.class);
        manager.load("background/hospital.png",Texture.class);
		manager.load("background/hospital_snow.png",Texture.class);
		manager.load("background/snowflake.png",Texture.class);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

//		while(!manager.isLoaded("IIanim1/frame-0010026.png",Texture.class)){
//			System.out.println("loading...");
//		}


	}

	@Override
	public void render () {
        if(!manager.update()){
            batch.begin();
            batch.draw(t,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            font.draw(batch,((int)(manager.getProgress()*100-manager.getProgress()*8)+add+"%"),Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/37,l_y-Gdx.graphics.getHeight()/35);
			batch.draw(logo,l_x,l_y,l_width,l_height);
			if((int)(manager.getProgress()*100-manager.getProgress()*8)+add<=30){
				batch.draw(loading_textures.get(0),load_x,load_y,load_width,load_height);
			}else if((int)(manager.getProgress()*100-manager.getProgress()*8)+add>30 && (int)(manager.getProgress()*100-manager.getProgress()*8)+add<=60){
				load_width=loading_textures.get(1).getWidth()*(load_height/loading_textures.get(1).getHeight());
				load_x=Gdx.graphics.getWidth()/2-load_width/2;
				batch.draw(loading_textures.get(1),load_x,load_y,load_width,load_height);
			}else if((int)(manager.getProgress()*100-manager.getProgress()*8)+add>60 && (int)(manager.getProgress()*100-manager.getProgress()*8)+add<=90){
				load_width=loading_textures.get(2).getWidth()*(load_height/loading_textures.get(2).getHeight());
				load_x=Gdx.graphics.getWidth()/2-load_width/2;
				batch.draw(loading_textures.get(2),load_x,load_y,load_width,load_height);
			}else if((int)(manager.getProgress()*100-manager.getProgress()*8)+add>=91){
				load_width=loading_textures.get(2).getWidth()*(load_height/loading_textures.get(2).getHeight());
				load_x=Gdx.graphics.getWidth()/2-load_width/2;
				batch.draw(loading_textures.get(3),load_x,load_y,load_width,load_height);
			}
            batch.end();
        }else {
            if(gs_created==false) {
                gs_created=true;
                gs = new GameScreen(this);

            }
            super.render();
            this.setScreen(gs);
        }
	}
}
