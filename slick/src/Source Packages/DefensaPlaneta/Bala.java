package DefensaPlaneta;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Carlos
 */
public class Bala implements IColisionable{

    private final ImagenMovil bala;
    private final Rectangle hitBox;
    private static final String RUTA = "Imagenes/Disparos/bala.png";
    private static final Punto VELOCIDAD = new Punto(300, 0);
    
    public Bala(Punto posicion) throws SlickException{
        this.bala = new ImagenMovil(RUTA, posicion, VELOCIDAD);
        this.hitBox = new Rectangle(bala.getPosicion().getX(), 
                bala.getPosicion().getY(), bala.getWidth(), bala.getHeight());
    }
    
    public void draw(){
        bala.draw();
    }
    
    public void update(int delta){
        bala.update(delta);
        sincronizarHitBox();
    }
    
    @Override
    public Shape getHitBox() {
        return hitBox;
    }

    @Override
    public void alColisionar(IColisionable colision) {
        this.bala.setPosicion(new Punto(1000, 0));
    }

    @Override
    public void sincronizarHitBox() {
        this.hitBox.setX(bala.getPosicion().getX());
        this.hitBox.setY(bala.getPosicion().getY());
    }

    public ImagenMovil getBala() {
        return bala;
    }

}
