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

enum TipoTeclado {
    rectangular,
    hexagonal,
    dosHexagonos,
}

public class teclado {
    
//  Atributos
    private TipoTeclado formaTeclado;
    private int numFilas;
    private int numCols;
    private boolean teclasDe4Lados;
    
//  Metodos
    public teclado() {}				     //constructor por defecto
    
    public teclado(TipoTeclado fT, int nF, int nC, boolean t4) {    //construct
	setForma(fT);
	setNumFilas(nF);
	setNumCols(nC);
	setTeclasDe4Lados(t4);
    }
    
    public void setForma(TipoTeclado tt) {
	formaTeclado = tt;
    }
    
    public TipoTeclado getForma() {
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
