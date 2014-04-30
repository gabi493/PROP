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
public class distancia {
    
//  Atributos 
    private int matriz[][];
    private int numeroFilas;
    private int numeroColumnas;
    
//  Metodos    

    /** Creadora por defecto de distancia
     *
     */
        public distancia() {
        int matriz[][] = new int[0][0];
        numeroFilas = 0;
        numeroColumnas = 0;
    }
    
    /**
     * distancia.   Creadora de la matriz de distancias con nF filas y nC columnas
     * @param nF:   numero de filas de la matriz
     * @param nC:   numero de columnas de la matriz
     */
    public distancia(int nF, int nC){
        setNumeroFilas(nF);
        setNumeroColumnas(nC);
        setMatriz(nF, nC);
    }
    
    /**
     * setNumeroFilas.  Asigna el numero de filas de la matriz
     * @param nF        numero de filas de la matriz
     */
    public void setNumeroFilas(int nF) {
	if (nF < 0) {
            throw new IllegalArgumentException("Error al asignar la distancia: numeroFilas < 0");
        }
        numeroFilas = nF;
    }
    
    /**
     * getNumeroFilas.	Obtiene el numero de filas de la matriz
     * @return:		Devuelve el numero de filas de la matriz
     */
    public int getNumeroFilas() {
        return numeroFilas;
    }
    
        /**
     * setNumeroColumnas.   Asigna el numero de columnas de la matriz
     * @param nC            numero de columnas de la matriz
     */
    public void setNumeroColumnas(int nC) {
	if (nC < 0) {
            throw new IllegalArgumentException("Error al asignar la distancia: numeroColumnas < 0");
        }
        numeroColumnas = nC;
    }
    
    /**
     * getNumeroColumnas.   Obtiene el numero de columnas de la matriz
     * @return:             Devuelve el numero de columnas de la matriz
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }
    
    /**
     * setMatriz.   Declara una matriz de tamano [nF][nC]
     * @param nF:   numero de filas de la matriz
     * @param nC:   numero de columnas de la matriz
     */
    public void setMatriz(int nF, int nC) {
	if (nF < 0) {
            throw new IllegalArgumentException("Error al asignar el numero de filas: numeroFilas < 0");
        }
        if (nC < 0) {
            throw new IllegalArgumentException("Error al asignar el numero de columnas: numeroColumnas < 0");
        }
        setNumeroFilas(nF);
        setNumeroColumnas(nC);
        int matriz[][] = new int[nF][nC];
    }
    
    /**
     * setRellenarMatriz.   Asigna un valor a la posicion [fila][columna] de la matriz
     * @param fila:         numero de filas de la matriz
     * @param columna:      numero de columnas de la matriz
     * @param valor:        valor a asignar
     */
    public void setRellenarMatriz(int fila, int columna, int valor) {
        if (fila < 0 || fila > getNumeroFilas()) {
            throw new IllegalArgumentException("Error en el numero de filas al asgnarle un valor: fila < 0 || fila > NumeroFilas");
        }
        if (columna < 0 || columna > getNumeroColumnas()) {
            throw new IllegalArgumentException("Error en el numero de columnas al asgnarle un valor: columna < 0 || columna > NumeroColumnas");
        }
        matriz[fila][columna] = valor;
    }
    
    public int getPosicionMatriz(int pos) {
        String forma = teclado.getForma();
        
        if (teclado)
        int numF = getNumeroFilas();
        int numC = getNumeroColumnas();
        int f = pos%numC;
        int c = pos/numC;
        return matriz[f][c];
    }
    
}



/*  ****************************DriverDistancia********************************
    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public void setRellenarMatriz(int nF, int nC) {
        String linea;
        int palabras[];
                
        for (int i = 0; i < nF; ++i) {
            linea = buffer.readLine();
            for (int j = 0; j < nC; ++j) {
                matriz[i][j] = Integer.parseInt(palabras[j]);
            }
        }
    }
*/