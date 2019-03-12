package carrera;

import java.util.ArrayList;



public class carrera {
    private ArrayList<cocheCarreras> coches = new ArrayList<cocheCarreras>();
    private ArrayList<cocheSeguridad> seguridad = new ArrayList<cocheSeguridad>();
    
    public void addCoche(cocheCarreras coche){
        coches.add(coche);
    }
    
    public void addSeguridad(cocheSeguridad cocheSeg){
        seguridad.add(cocheSeg);
    }
    
    public cocheCarreras getCoche(int i){
        return coches.get(i);
    }
    
    public cocheSeguridad getSeg(int i){
        return seguridad.get(i);
    }
    
    public int tamCoches(){
        return coches.size();
    }
    
    public int tamSeg(){
        return seguridad.size();
    }
}
