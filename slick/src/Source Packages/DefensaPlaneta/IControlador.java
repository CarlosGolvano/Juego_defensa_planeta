package DefensaPlaneta;

import org.newdawn.slick.SlickException;

public interface IControlador {
    
    public void addE(Punto posicion, GestorColisiones gestor) throws SlickException;
    
    public void draw();
    
    public void update(int delta, GestorColisiones gestor);
    
    public void delete(GestorColisiones gestor);
}
