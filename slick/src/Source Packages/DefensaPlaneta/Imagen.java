package DefensaPlaneta;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Imagen extends Image{
    
    protected Punto posicion;
    
    public Imagen(String ruta, Punto posicion) throws SlickException{
        super(ruta);
        this.posicion = posicion;
    }
    
    public Imagen(String ruta) throws SlickException{
        this(ruta, new Punto(0, 0));
    }
    
    public Imagen(String ruta, float x, float y) throws SlickException{
        this(ruta, new Punto(x, y));
    }

    public Punto getPosicion() {
        return posicion;
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
    
    public void setPosicion(float x, float y){
        setPosicion(new Punto(x, y));
    }

    public void setRuta(String name) {
        this.name = name;
    }
    
    @Override
    public void draw() {
        super.draw(posicion.getX(), posicion.getY()); 
    }
    
}
