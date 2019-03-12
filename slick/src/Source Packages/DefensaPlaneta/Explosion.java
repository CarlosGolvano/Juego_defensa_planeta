package DefensaPlaneta;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Carlos
 */
public class Explosion extends Animation {
    
    private final Animation anim;
    private final SpriteSheet sprite;
    private final Punto posicion;
    
    public Explosion(Punto posicion) throws SlickException{
        this.posicion = posicion;
        sprite = new SpriteSheet("Imagenes/Explosion/round_explosion/spritesheet/spritesheet.png", 100,100);
        anim = new Animation(sprite, 15);
        anim.setLooping(false);
    }

    public Punto getPosicion() {
        return posicion;
    }

    public SpriteSheet getSprite() {
        return sprite;
    }
    
    @Override
    public void draw(){
        this.anim.draw(posicion.getX() - 30, posicion.getY() - 29);
    }  
}
