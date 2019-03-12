package DefensaPlaneta;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Principal extends StateBasedGame{

    private final AppGameContainer contenedor;
    
    public static void main(String[] args) throws SlickException{
        Principal p = new Principal("Defensa de 'El Planeta'");
    }

    public Principal(String name) throws SlickException {
        super(name);
        contenedor = new AppGameContainer(this);
        contenedor.setDisplayMode(840, 480, false);
        contenedor.setShowFPS(false);
        contenedor.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new Juego());
    }
    
}
