package DefensaPlaneta;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Carlos
 */
public class ControladorExplosiones {
    
    private final ArrayList<Explosion> expls;
    
    public ControladorExplosiones(){
        expls = new ArrayList<>();
    }

    public void addE(Punto posicion) throws SlickException {
        Explosion expl = new Explosion(posicion);
        expls.add(expl);
    }

    public void draw() {
        for(int i = 0;i < expls.size();i++){
            expls.get(i).draw();
        }        
    }

    public void delete() {
        for(int j = 0;j < expls.size();j++){
            if(expls.get(j).isStopped()){
                expls.remove(j);
            }
        }
    }
    
}
