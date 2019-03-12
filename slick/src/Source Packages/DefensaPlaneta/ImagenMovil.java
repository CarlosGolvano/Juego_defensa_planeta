package DefensaPlaneta;

import org.newdawn.slick.*;

public class ImagenMovil extends Imagen{
    
    private Vector velocidad;
    
    public ImagenMovil(String ruta, Punto posicion, Vector velocidad) throws SlickException {
        super(ruta, posicion);
        this.velocidad = velocidad;
    }
    
    public ImagenMovil(String ruta, Punto posicion, Punto velocidad) throws SlickException {
        this(ruta, posicion, new Vector(velocidad));
    }

    public void update(int delta){
        float x = posicion.getX() + velocidad.getX() * ((float) delta / 1000);
        float y = posicion.getY() + velocidad.getY() * ((float) delta / 1000);
        this.setPosicion(x, y);
    }
    
    public Vector getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Vector velocidad) {
        this.velocidad = velocidad;
    }
    
    public void setVelocidad(Punto velocidad){
        this.velocidad = new Vector(velocidad);
    }
}
