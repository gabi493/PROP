package enunciadoteclado;


import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class estadisticas extends afinidad {

    /**
     *
     * @param mida
     */
    public estadisticas(int mida) {
        super(mida);
    }
  
    /**
     *
     * @param letra1
     * @param letra2
     * @param similitud
     */
    public void insertarEstadistica (simbolo letra1,simbolo letra2,double similitud,alfabeto a) {
      int i = a.getPosicion(letra1);
      int j = a.getPosicion(letra2);
      insertarAfinidad(i,j,1);
    }

    /**
     *
     * @param letra1
     * @param letra2
     * @return
     */
    public double consultarEstadistica (simbolo letra1,simbolo letra2,alfabeto a) throws IOException{
      int i = a.getPosicion(letra1);
      int j = a.getPosicion(letra2);
      return consultarAfinidad(i,j);
    
    }
    
}
