package museo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class museo {
    private boolean aux = false;
    private int max = 20;
    private int cant = 0;
    private boolean puertas_llenas = false;
    private int gente_este = 0;
    private int gente_oeste = 0;
    private boolean turno = true;          //true -> este, false -> oeste
    Lock cerrojo = new ReentrantLock();
    Lock cerrojo_este = new ReentrantLock();
    Lock cerrojo_oeste = new ReentrantLock();
    Lock cerrojo_salir = new ReentrantLock();
    final Condition lleno_este = cerrojo_este.newCondition();
    final Condition lleno_oeste = cerrojo_oeste.newCondition();
    final Condition esperar_salir = cerrojo_salir.newCondition();
    
    public void entrar_museo_este() throws InterruptedException{
        cerrojo_este.lock();
        try {
            if(cant == max){
                gente_este++;
                lleno_este.await();
                gente_este--;
            }
            
            cerrojo.lock();
            try{
                cant++;
            } finally {
                cerrojo.unlock();
            }
                    
        } finally {
            cerrojo_este.unlock();
        }
        if(aux){
            esperar_salir.signal();
        }
    }
    
    public void entrar_museo_oeste() throws InterruptedException{
        cerrojo_oeste.lock();
        try {
            if(cant == max){
                gente_oeste++;
                lleno_oeste.await();
                gente_oeste--;
            }
            cerrojo.lock();
            try{
                cant++;
            } finally {
                cerrojo.unlock();
            }
                    
        } finally {
            cerrojo_oeste.unlock();
        }
        if(aux){
            esperar_salir.signal();
        }
    }
    
    public void salir_museo() throws InterruptedException{
        cerrojo_salir.lock();
        try {
            cerrojo.lock();
            try{
                cant--;
            } finally {
                cerrojo.unlock();
            }
            
            if(gente_este > 0 && gente_oeste > 0){
                if(turno){
                    lleno_este.signal();
                    turno = !turno;
                } else{
                    lleno_oeste.signal();
                    turno = !turno;
                }
            } else {
                
            }
            
            aux = true;
            esperar_salir.await();
            aux = false;
            
        } finally {
            cerrojo_salir.unlock();
        }
    }
}
