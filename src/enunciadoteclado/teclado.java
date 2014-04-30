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

/*enum TipoTeclado {
    rectangular,
    hexagonal,
    dosHexagonos,
}*/

public class teclado {
    
//  Atributos
    private String formaTeclado;
    private int numFilas;
    private int numCols;
    private boolean teclasDe4Lados;
    
//  Metodos
    public teclado() {}				     //constructor por defecto
    
    public teclado(String fT, int nF, int nC, boolean t4) {    //construct
	setForma(fT);
	setNumFilas(nF);
	setNumCols(nC);
	setTeclasDe4Lados(t4);
    }
    
    public void setForma(String tt) {
        if (tt != "rectangular" || tt != "hexagonal" || tt != "dosHexagonos") {
            throw new IllegalArgumentException("Error en el nombre del teclado:" + 
                    " rectangular || hexagonal || dosHexagonos");
        }
	formaTeclado = tt;
    }
    
    public String getForma() {
	return formaTeclado;
    }
    
    public void setNumFilas(int nf) {
	numFilas = nf;
    }
    
    public int getNumFilas() {
	return numFilas;
    }
    
    public void setNumCols(int nc) {
	numCols = nc;
    }
    
    public int getNumCols() {
	return numCols;
    }
    
    public void setTeclasDe4Lados(boolean b) {
	teclasDe4Lados = b;
    }
    
    public boolean getTeclasDe4Lados() {
	return teclasDe4Lados;
    }
    
}
