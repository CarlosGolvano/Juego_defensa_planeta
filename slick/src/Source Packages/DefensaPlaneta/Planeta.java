package DefensaPlaneta;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Planeta implements IColisionable{

    private final Rectangle hitBox;
    private int vidas;
    private String msg;
    
    public Planeta(){
        this.hitBox = new Rectangle(0, 0, 20, 480);
        this.vidas = 5;
        this.msg = "Vidas del planeta: " + vidas;
    }
    
    public void update(){
        this.msg = "Vidas del planeta: " + vidas;
    }
    
    @Override
    public Shape getHitBox() {
        return hitBox;
    }

    @Override
    public void alColisionar(IColisionable colision) {
        vidas--;
    }

    @Override
    public void sincronizarHitBox() {
    }
    
    public String getMsg(){
        return msg;
    }
    
    public int getVidas(){
        return vidas;
    } 
}
