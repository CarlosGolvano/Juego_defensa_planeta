package museo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class visitante extends Thread{
    private museo museo;
    private int cont;
    
    public visitante(museo museo, int cont){
        this.museo = museo;
        this.cont = cont;
    }
    
    @Override
    public void run() {
        
        if(Math.random() >= 0.5){
            try {
                museo.entrar_museo_este();
                System.out.println("Visitante " + cont + " este");
            } catch (InterruptedException ex) {
                Logger.getLogger(visitante.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            try {
                museo.entrar_museo_oeste();
                System.out.println("Visitante " + cont + " oeste");
            } catch (InterruptedException ex) {
                Logger.getLogger(visitante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try{
            sleep((int)(1000 + 5000 * Math.random()));
        } catch(InterruptedException e){}
        
        try {
            museo.salir_museo();
        } catch (InterruptedException ex) {
            Logger.getLogger(visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Visitante " + cont + "ha salido");
        
    }
}
