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
    public void insertarEstadistica (int i,int j,double similitud) {
      insertarAfinidad(i,j,1);
    }

    /**
     *
     * @param letra1
     * @param letra2
     * @return
     */
    public double consultarEstadistica (int i,int j) throws IOException{
      return consultarAfinidad(i,j);
    
    }
    
}
