




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
    
    int mida;
    
    /**
     *
     */
    public estadisticas() {
<<<<<<< HEAD
        super(0);
        this.mida = 0;
=======
        super();
>>>>>>> a5d9f8b555bb90998b18c06ce2f57df321c9266d
    }
    
    
    /**
     *
     * @param mida
     */
    public estadisticas(int mida) {
        super(mida);
        this.mida = mida;
    }
  
    /**
     *
     * @param letra1
     * @param letra2
     * @param similitud
     */
    public void insertarEstadistica (int i,int j,double similitud) {
<<<<<<< HEAD
      System.out.println("Se a insertado en la posicion "+ similitud );
      insertarAfinidad(i,j,similitud);
      
=======
      insertarAfinidad(i,j,similitud);
>>>>>>> a5d9f8b555bb90998b18c06ce2f57df321c9266d
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

    /**
     *
     * @throws IOException
     */
    public void leerMatriz() throws IOException {
        for(int i=0; i < mida; ++i) {
            for (int j=0; j < mida; ++j) {
                System.out.print (consultarEstadistica(i,j) + "  ");
            }
<<<<<<< HEAD
            System.out.println("");
=======
	    System.out.println();
>>>>>>> a5d9f8b555bb90998b18c06ce2f57df321c9266d
        }
    }
    
}
