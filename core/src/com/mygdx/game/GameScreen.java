package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

import Actions.ButtonListener;
import Background.Background;
import Menu.Menu;

/**
 * Created by Sava on 29.02.2016.
 */
public class GameScreen implements Screen {
    public ButtonListener listener;
    public Background bck;
    public Main main;
    public Menu menu;
    public boolean background=false;
    Random random;
    public GameScreen(final Main game) {
        random=new Random(System.currentTimeMillis());
        this.main = game;
        menu = new Menu(this,random.nextInt(3));
        bck = new Background(game);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        menu.draw();
        if(background)
        bck.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bck.dispose();
    }
}
