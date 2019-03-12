package DefensaPlaneta;

import org.newdawn.slick.geom.Shape;

/*
*   Interfaz que va a impletertar todo objeto que pueda colosionar
*  @param
*/


public interface IColisionable {
    
    /**
     * Devuelve el área de colisión del objeto
     * @return 
     */
    public Shape getHitBox();
    
    /**
     * Al llamar este método cada cuerpo ejecutra su acción correspondiente
     * @param colision instancia al otro cuerpo que ha chocado con este
     */
    public void alColisionar(IColisionable colision);
    
    public void sincronizarHitBox();
    
}
