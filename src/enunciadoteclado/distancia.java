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
    public distancia() {
        distancia = -1;
        tam = -1;
    }
    
    public distancia(int d, int t){
        setDistancia(d);
        setTamano(t);
    }
    
    public void setDistancia(int d) {
        distancia = d;
    }
    
    public int getDistancia() {
        return distancia;
    }
    
    public void setTamano(int t) {
        tam = t;
    }
    
    public int getTamano() {
        return tam;
    }
//    public int calcularDistancia(int x, int y, int X, int Y) {
//        
//    }
}
