package DefensaPlaneta;

import java.util.ArrayList;

public class GestorColisiones {
    
    private final ArrayList<IColisionable> lista;
    
    public GestorColisiones(){
        lista = new ArrayList<>();
    }
    
    public void addCuerpo(IColisionable cuerpo){
        if(!lista.contains(cuerpo)){
            lista.add(cuerpo);
        }
    }
    
    public void eliminarCuerpo(IColisionable cuerpo){
        if(lista.contains(cuerpo)){
            lista.remove(cuerpo);  
        }
    }
    
    public void comprobarColision(){
        for(int i = 0;i < lista.size();i++){
            for(int j = 0;j < lista.size();j++){
                if(i < j){
                    buscarColision(i, j);
                }
            }
        }
    }
    
    public void buscarColision(int i, int j){
        if(lista.get(i).getHitBox().intersects(lista.get(j).getHitBox())){
            lista.get(i).alColisionar(lista.get(j));
            lista.get(j).alColisionar(lista.get(i));
        }
    }
}
