
package DefensaPlaneta;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class ControladorAtacante implements IControlador {
    
    private final ArrayList<Atacante> atacantes;
    
    public ControladorAtacante(){
        atacantes = new ArrayList<>();
    }

    @Override
    public void addE(Punto posicion, GestorColisiones gestor) throws SlickException {
        Atacante atacante = new Atacante(posicion);
        atacantes.add(atacante);
        gestor.addCuerpo(atacante);
    }

    @Override
    public void draw() {
        for(Atacante atacante : atacantes){
            atacante.draw();
        }
    }

    @Override
    public void update(int delta, GestorColisiones gestor) {
        for(Atacante atacante : atacantes){
            atacante.update(delta);
        }
        
        delete(gestor);
    }

    @Override
    public void delete(GestorColisiones gestor) {
        for(int i = 0;i < atacantes.size();i++){
            if(atacantes.get(i).getHitBox().getX() < 0){
                Atacante atacante = atacantes.get(i);
                atacantes.remove(atacante);
                gestor.eliminarCuerpo(atacante);
            }
        }
    }

    public ArrayList<Atacante> getAtacantes() {
        return atacantes;
    }
   
    
}
