package DefensaPlaneta;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Carlos
 */
public class Defensor implements IColisionable{

    private ImagenMovil nave;
    private Rectangle hitBox;
    private int vidas;
    private String msg;
    
    public ImagenMovil g(){
        return nave;
    }
    
    public Defensor(String ruta, Punto posicion, Vector velocidad) throws SlickException{
        this.nave = new ImagenMovil(ruta, posicion, velocidad);
        this.hitBox = new Rectangle(nave.getPosicion().getX(), 
                nave.getPosicion().getY(), nave.getWidth(), nave.getHeight());
        this.vidas = 3;
        this.msg = "Vidas defensor: " + vidas;
    }
    
    public Defensor(String ruta, Punto posicion, Punto velocidad) throws SlickException{
        this(ruta, posicion, new Vector(velocidad));
    }
    
    public void draw(){
        this.nave.draw();
    }
    
    public void update(int delta, Input entrada) throws SlickException{
        nave.update(delta);
        comprobarPosicion();
        actualizar(entrada);
        sincronizarHitBox();
    }
    
    private void comprobarPosicion(){
        if(nave.getPosicion().getY() < 0){
            nave.setPosicion(new Punto(nave.getPosicion().getX(), 0));
        } else if(nave.getPosicion().getY() > 480 - nave.getHeight()){
            nave.setPosicion(new Punto(nave.getPosicion().getX(),
                    480 - nave.getHeight()));
        }
    }
    
    private void actualizar(Input entrada) throws SlickException{
        if(entrada.isKeyDown(Input.KEY_UP)){
            nave.setVelocidad(new Punto(0, -300));
        } else if(entrada.isKeyDown(Input.KEY_DOWN)){
            nave.setVelocidad(new Punto(0, 300));
        } else {
            nave.setVelocidad(new Punto(0, 0));
        }
    }
    
    public void updateVidas(){
        this.msg = "Vidas defensor: " + vidas;
    }
    
    public int getVidas(){
        return vidas;
    }

    public String getMsg() {
        return msg;
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
    public void sincronizarHitBox(){
        hitBox.setX(nave.getPosicion().getX());
        hitBox.setY(nave.getPosicion().getY());
    }
}
