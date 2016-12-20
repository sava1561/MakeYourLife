package Actions;
import com.mygdx.game.Main;

import Background.*;
/**
 * Created by Sava on 13.03.2016.
 */
public class ButtonListener {
    public Background background;
    public ButtonListener(final Main game){
        background=new Background(game);
    }
    public void goHome(){
        if(background.home.varExists){
            background.home.go.ontouch(background.player);
        }
        if(background.home.go.touched){
            background.player.movingLeft=true;
            background.player.moveLeft();
            background.player.movingRight=false;
            if(background.player.reachedHome(background.home.position.x,background.home.width)){
                background.player.athome=true;
                background.home.varExists=false;
                background.home.go.touched=false;
            }
        }
    }
    public void listen(){
        background.draw();
        goHome();
    }
}
