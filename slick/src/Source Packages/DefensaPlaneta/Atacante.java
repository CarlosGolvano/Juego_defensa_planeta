package DefensaPlaneta;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Carlos
 */
public class Atacante implements IColisionable{
    
    private final ImagenMovil enemigo;
    private final Rectangle hitBox;
    private static final Punto VELOCIDAD = new Punto(-150, 0);
    private static final String RUTA = "Imagenes/Naves/atacante.png";
    
    public Atacante(Punto posicion) throws SlickException{
        this.enemigo = new ImagenMovil(RUTA, posicion, VELOCIDAD);
        this.hitBox = new Rectangle(enemigo.getPosicion().getX(), 
                enemigo.getPosicion().getY(), enemigo.getWidth(), enemigo.getHeight());
    }
    
    public void draw(){
        enemigo.draw();
    }
    
    public void update(int delta){
        enemigo.update(delta);
        sincronizarHitBox();
    }

    @Override
    public void alColisionar(IColisionable colision) {
        try {
            Juego.explosiones.addE(new Punto(this.enemigo.getPosicion().getX(), this.enemigo.getPosicion().getY()));
        } catch (SlickException ex) {}
        
        this.enemigo.setPosicion(new Punto(-1000, 0));
    }

    @Override
    public void sincronizarHitBox() {
        this.hitBox.setX(enemigo.getPosicion().getX());
        this.hitBox.setY(enemigo.getPosicion().getY());
    }

    @Override
    public Shape getHitBox() {
        return hitBox;
    }
    
}
