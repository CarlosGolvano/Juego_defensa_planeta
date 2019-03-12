package carrera;

public class cocheSeguridad extends Thread {
    private boolean corriendo; //true -> están corriendo, false -> no están corriendo
    private int id;
    private carrera race;
    private boolean listo;
    
    public cocheSeguridad(int id, carrera carrera){
        this.id = id;
        this.corriendo = true;
        this.race = carrera;
        this.listo = false;
    }
    
    public void reconocer(){
        System.out.println("Seg " + id + " comienza reconocimiento");
        
        try{
            sleep((long) (5000 + (int)5000 * Math.random()));
        } catch(InterruptedException e){}
        
        
        System.out.println("Seg " + id + "termina reconocimiento");
        this.corriendo = false;
    }

    public boolean isCorriendo() {
        return corriendo;
    }
    
    public boolean isListo(){
        return listo;
    }
 
    @Override
    public void run(){
        try{
            sleep((long) (4000 + (int)12000 * Math.random()));
        } catch(InterruptedException e){}
        
        System.out.println("Coche seguridad " + id + " listo");
        this.listo = true;
        
        boolean aux = true;
        boolean aux2;
        
        while(aux){
            aux2 = true;
            for(int i = 0;i < race.tamCoches();i++){
                aux2 = aux2 && race.getCoche(i).isListo();
            }
            for(int i = 0;i < race.tamSeg();i++){
                aux2 = aux2 && race.getSeg(i).isListo();
            }
            
            aux = aux && !aux2;
        }
        
        reconocer();
        
        try{
            sleep(5000);
        } catch(InterruptedException e){System.out.println("ERROR");}
        
        aux = true;
        
        while(aux){
            aux2 = false;
            for(int i = 0;i < race.tamCoches();i++){
                aux2 = aux2 || race.getCoche(i).isCorriendo();
            }
            
            aux = aux && aux2;
        }
        
        System.out.println("Carrera finalizada");
    }
}
