package DefensaPlaneta;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class ControladorBala implements IControlador{
    
    private final ArrayList<Bala> balas;
    
    public ControladorBala(){
        balas = new ArrayList<>();
    }
    
    @Override
    public void addE(Punto posicion, GestorColisiones gestor) throws SlickException {
        Bala bala = new Bala(posicion);
        bala.getBala().getPosicion().setY(posicion.getY() - bala.getBala().getHeight() / 2);
        balas.add(bala);
        gestor.addCuerpo(bala);
    }
    
    @Override
    public void draw(){
        for(Bala bala : balas){
            bala.draw();
        }
    }
    
    @Override
    public void update(int delta, GestorColisiones gestor){
        for(Bala bala : balas){
            bala.update(delta);
        }
        delete(gestor);
    }
    
    @Override
    public void delete(GestorColisiones gestor){
        for(int i = 0;i < balas.size();i++){
            if(balas.get(i).getHitBox().getX() > 840){
                Bala bala = balas.get(i);
                balas.remove(bala); 
                gestor.eliminarCuerpo(bala);
            }
        }
    }

    public ArrayList<Bala> getBalas() {
        return balas;
    }

}
