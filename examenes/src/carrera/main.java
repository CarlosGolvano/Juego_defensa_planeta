package carrera;

public class main {

    public static void main(String[] args) {
        carrera cr = new carrera();       
        
        for(int i = 0;i < 20;i++){
            cocheCarreras c = new cocheCarreras(i, cr);
            cr.addCoche(c);
        }
        
        for(int i = 0;i < 2;i++){
            cocheSeguridad s = new cocheSeguridad(i, cr);
            cr.addSeguridad(s);
        }
        
        System.out.println("Comienza la carrera to guapa");
        
        for(int i = 0;i < 20;i++){
            if(i < 2){
                cr.getSeg(i).start();
            }
            cr.getCoche(i).start();
        }
    }
    
}
