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
    private int numeroPosiciones;
    private String formaTeclado;
    private int primerasPosicionesForma[];
//  Metodos    

    /** Creadora por defecto de distancia
     *
     */
        public distancia() {
        int matriz[][] = new int[0][0];
        numeroFilas = 0;
        numeroColumnas = 0;
        numeroPosiciones = 0;
        formaTeclado = "";
	int primerasPosicionesForma[] = new int primerasPosicionesForma[0]
    }
    
    /**
     * distancia.   Creadora de la matriz de distancias con nF filas y nC columnas
     * @param nF:   numero de filas de la matriz
     * @param nC:   numero de columnas de la matriz
     * @param nP:   numero de posiciones de la matriz
     * @param fT:   forma del teclado
     */
    public distancia(String fT, int nF, int nC, int nP){
	setFormaTeclado(fT);
        setNumeroFilas(nF);
        setNumeroColumnas(nC);
        setNumeroPosiciones(nP);
	int primerasPosicionesForma[] = new int primerasPosicionesForma[nF]
	setPrimeraPosicionForma(nF);
        setMatriz(nF, nC, nP);
    }
    
    
        /**
     * setFormaTeclado.	Asigna una forma al teclado
     * @param fT:	forma del teclado
     */
    public void setFormaTeclado(String fT) {
        if (!(fT).equals("rectangular") && !(fT).equals("hexagonal") && !(fT).equals("dosHexagonos")) {
            throw new IllegalArgumentException("Error en el nombre del teclado:" + 
                    " rectangular || hexagonal || dosHexagonos");
        }
	formaTeclado = fT;
    }
    
    
    /**
     * getFormaTeclado.	Obtiene la forma del teclado
     * @return		Devuelve la forma del teclado
     */
    public String getFormaTeclado() {
            return formaTeclado;
    }
    
    
    /**
     * setNumeroFilas.  Asigna el numero de filas de la matriz
     * @param nF        numero de filas de la matriz
     */
    public void setNumeroFilas(int nF) {
	if (nF < 0) {
            throw new IllegalArgumentException("Error al asignar las filas: numeroFilas < 0");
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
            throw new IllegalArgumentException("Error al asignar las columnas: numeroColumnas < 0");
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
     * setNumeroPosiciones. Asigna el numero de posiciones de la matriz
     * @param nP            numero de posiciones de la matriz
     */
    public void setNumeroPosiciones(int nP) {
	if (nP < 0 || nP > getNumeroFilas()*getNumeroColumnas()) {
            throw new IllegalArgumentException("Error al asignar las posiciones: numeroPosiciones < 0 || numeroPosiciones > numeroFilas*numeroColumnas");
        }
        numeroPosiciones = nP;
    }
    
    
    /**
     * getNumeroPosiciones. Obtiene el numero de posiciones de la matriz
     * @return		    Devuelve el numero de posiciones de la matriz
     */
    public int getNumeroPosiciones() {
        return numeroPosiciones;
    }
    
    
    public void setPrimeraPosicionForma(int numeroFila, int posicion) {
	if (numeroFila < 0 || numeroFila > getNumeroFilas()) {
            throw new IllegalArgumentException("Error al asignar la primera posicion de una fila: nF < 0 || nF > numeroFilas");
        }
	if (posicion < 0 || posicion > getNumeroColumnas()) {
            throw new IllegalArgumentException("Error al asignar la primera posicion de una fila: pos < 0 || pos > numeroColumnas");
        }
	primerasPosicionesForma[numeroFila] = posicion;
    }
    
    
    public int getPrimeraPosicionForma(int numeroFila) {
	return primerasPosicionesForma[numeroFila];
    }
    
    
    /**
     * setMatriz.   Declara una matriz de tamano [nF][nC]
     * @param nF:   numero de filas de la matriz
     * @param nC:   numero de columnas de la matriz
     * @param nP:   numero de parametros de ma matriz
     */
    public void setMatriz(int nF, int nC, int nP) {
	if (nF < 0) {
            throw new IllegalArgumentException("Error al asignar el numero de filas: numeroFilas < 0");
        }
        if (nC < 0) {
            throw new IllegalArgumentException("Error al asignar el numero de columnas: numeroColumnas < 0");
        }
        setNumeroFilas(nF);
        setNumeroColumnas(nC);
        setNumeroPosiciones(nP);
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
    
    
    /**
     * getPosicion. Obtiene la posicion 
     * @param pos
     * @return
     */
    public int getPosicionMatriz(int pos) {
        int numF, numC, f, c;
        if (getFormaTeclado() == "rectangular") {
            numF = getNumeroFilas();
            numC = getNumeroColumnas();
            f = pos%numC;
            c = pos/numC;
        }
        else if (getFormaTeclado() == "hexagonal") {
            
        }
        else if (getFormaTeclado() == "dosHexagonos") {
            
        }
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