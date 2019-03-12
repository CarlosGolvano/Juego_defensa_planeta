package carrera;

public class cocheCarreras extends Thread {
    private boolean corriendo; //true -> están corriendo, false -> no están corriendo
    private int id;
    private boolean listo;
    private carrera race;
    
    public cocheCarreras(int id, carrera race){
        this.id = id;
        this.corriendo = false;
        this.listo = false;
        this.race = race;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public boolean isListo() {
        return listo;
    }
    
    public void correr(){
        this.corriendo = true;
        System.out.println("Coche " + id + " comienza a correr");
        
        try{
            sleep(12000);
        } catch(InterruptedException e){}
    }
    
    @Override
    public void run(){
        try{
            sleep((long) (4000 + (int)12000 * Math.random()));
        } catch(InterruptedException e){}
        
        System.out.println("Coche " + id + " listo");
        listo = true;
        
        boolean aux = true;
        boolean aux2;
        
        while(aux){
            aux2 = false;
            for(int i = 0;i < race.tamSeg();i++){
                aux2 = aux2 || race.getSeg(i).isCorriendo();
            }
            
            aux = aux && aux2;
        }
        
        correr();
        
        System.out.println("Coche " + id + "finaliza");
        this.corriendo = false;
    }
}
