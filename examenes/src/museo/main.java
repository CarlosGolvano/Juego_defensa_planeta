package museo;

public class main {

    public static void main(String[] args) {
        museo m = new museo();
        for(int i = 0;i < 30;i++){
            visitante v = new visitante(m, i);
            v.start();
        }
    }
    
}
