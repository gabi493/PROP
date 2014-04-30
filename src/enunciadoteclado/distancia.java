/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enunciadoteclado;

/**
 *
 * @author gabriel
 */
public final class distancia {
    
//  Atributos 
    private int distancia;
    private int tam;
    
//  Metodos    

    /** Creadora por defecto de distancia
     *
     */
        public distancia() {
        distancia = -1;
        tam = -1;
    }
    
    /**
     * Creadora distancia
     * @param d:    distancia entre dos teclas
     * @param t:    tamano de la matriz
     */
    public distancia(int d, int t){
        setDistancia(d);
        setTamano(t);
    }
    
    /**
     * setDistancia.	Asigna la distancia
     * @param d:	distancia a la que estan
     */
    public void setDistancia(int d) {
	if (d < 0) {
            throw new IllegalArgumentException("Error al asignar la distancia: n < 0");
        }
        distancia = d;
    }
    
    /**
     * getDistancia.	Obtiene la distancia entre las teclas
     * @return:		Devuelve la distancia entre las teclas
     */
    public int getDistancia() {
        return distancia;
    }
    
    /**
     * setTamano.   Asigna el tamano
     * @param t:    tamano de la matriz
     */
    public void setTamano(int t) {
	if (t < 1) {
            throw new IllegalArgumentException("Error al asignar el tamano: n < 0");
        }
        tam = t;
    }
    
    /**
     * getTamano.   Obtiene el tamano de la matriz
     * @return:	    Devuelve el tamano de la matriz
     */
    public int getTamano() {
        return tam;
    }
//    public int calcularDistancia(int x, int y, int X, int Y) {
//        
//    }
}
