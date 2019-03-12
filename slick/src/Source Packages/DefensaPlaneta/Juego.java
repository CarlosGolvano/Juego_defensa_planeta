package DefensaPlaneta;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Juego extends BasicGameState{
    
    private Input entrada;
    private Defensor nave;
    private ControladorBala balas;
    private ControladorAtacante atacantes;
    private Planeta planeta;
    public static ControladorExplosiones explosiones;
    private int relojAtacante;
    private GestorColisiones gestor;
    private final String gameOver = "GAME OVER";
    
    /**
     * Inicia el videojuego
     * @param gc
     * @param sbg
     * @throws SlickException 
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.entrada = gc.getInput();
        
        this.nave = new Defensor("Imagenes/Naves/nave1.png", 
                new Punto(40, 220), new Punto(0, 0));
        
        this.planeta = new Planeta();
        
        balas = new ControladorBala();
        atacantes = new ControladorAtacante();
        explosiones = new ControladorExplosiones();
        gestor = new GestorColisiones();
        
        relojAtacante = 0;

        gestor.addCuerpo(nave);
        gestor.addCuerpo(planeta);
    }

    /**
     * Dibuja todos los objetos
     * @param gc
     * @param sbg
     * @param g
     * @throws SlickException 
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        nave.draw();
        balas.draw();
        atacantes.draw();       
        explosiones.draw();
        g.drawString(planeta.getMsg(), 30, 5);
        g.drawString(nave.getMsg(), 30, 20);
        g.draw(planeta.getHitBox());
        
        if(planeta.getVidas() <= 0 || nave.getVidas() <= 0){
            g.drawString(gameOver, 400, 220);
        }
        
        
        //dibujarHitBox(g);
    }

    /**
     * Actualiza todos los objetos
     * @param gc
     * @param sbg
     * @param delta
     * @throws SlickException 
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if(planeta.getVidas() > 0 && nave.getVidas() > 0){
            nave.update(delta, entrada);

            balas.update(delta, gestor);
            atacantes.update(delta, gestor);

            relojAtacante += delta;
            if(relojAtacante > (1000 + 1000 * Math.random())){
                crearAtacante();
                relojAtacante = 0;
            }

            //Si pulsamos espacio, dispara
            if(entrada.isKeyPressed(Input.KEY_SPACE)){
                balas.addE(new Punto(nave.getHitBox().getX() + nave.getHitBox().getWidth() + 1, 
                        nave.getHitBox().getY() + nave.getHitBox().getHeight() / 2), gestor);
            }

            gestor.comprobarColision();
            planeta.update();
            nave.updateVidas();
            explosiones.delete();
        }
    }
    
    
    
    public void crearAtacante() throws SlickException{
        atacantes.addE(new Punto(840, (float) (430 * Math.random())), gestor);
    }
    
    /**
     * Dibuja las hitbox de todos los elementos. Este método es usado para
     * comprobar el funcionamiento correcto de los elementos
     * @param g elemento para poder dibujar 
     */
    public void dibujarHitBox(Graphics g){
        g.draw(nave.getHitBox());
        
        for(int i = 0;i < balas.getBalas().size();i++){
            g.draw(balas.getBalas().get(i).getHitBox());
        }
        
        for(int j = 0;j < atacantes.getAtacantes().size();j++){
            g.draw(atacantes.getAtacantes().get(j).getHitBox());
        }
    }
    
    @Override
    public int getID() {
        return 0;
    }
    
}

