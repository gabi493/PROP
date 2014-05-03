/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package enunciadoteclado;

/**
 *
 * @author gabriel
 */
public class distancia {
    
//  Atributos 
    private int matrizDistancias[][];
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
        matrizDistancias = new int[0][0];
        numeroFilas = 0;
        numeroColumnas = 0;
        numeroPosiciones = 0;
        formaTeclado = "";
	primerasPosicionesForma = new int[0];
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
	int primerasPosicionesForma[] = new int[nF];
	int matrizDistancias[][] = new int[nP][nP];
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
    
    /**
     * setPrimeraPosicionForma.	Asigna la posicion inicial de una fila al vector de primerasPosiciones
     * @param numeroFila:	numero de fila al que se quiere asignar la posicion
     * @param posicion		posicion que se quiere asignar al numero de fila
     */
    public void setPrimeraPosicionForma(int numeroFila, int posicion) {
	if (numeroFila < 0 || numeroFila > getNumeroFilas() - 1) {
            throw new IllegalArgumentException("Error al asignar la primera posicion de una fila: nF < 0 || nF > numeroFilas -> " + (getNumeroFilas() - 1));
        }
	if (posicion < 0 || posicion > getNumeroPosiciones() - 1) {
            throw new IllegalArgumentException("Error al asignar la primera posicion de una fila: pos < 0 || pos > numeroPosiciones -> " + (getNumeroPosiciones() - 1));
        }
	primerasPosicionesForma[numeroFila] = posicion;
    }
    
    /**
     * getPrimeraPosicionForma. Obtiene la primera posicion de una fila
     * @param numeroFila:	fila de la que se quiere obtener la primera posicion
     * @return			Devuelve la primera posicion de la fila numeroFila
     */
    public int getPrimeraPosicionForma(int numeroFila) {
	return primerasPosicionesForma[numeroFila];
    }
    
/*    public void setTodasPrimerasPosicionesForma() {
	int n = getNumeroFilas();
	for (int i = 0; i < n; ++i) setPrimeraPosicionForma(i, ):
    }*/
    
    /**
     * setDistanciaMatriz.  Asigna una distancia entre dos posiciones a la matriz de distancias
     * @param posicionA:    posicion A de la matriz
     * @param posicionB:    posicion B de la matriz
     * @param distancia:    distancia entre las posiciones
     */
    public void setDistanciaMatriz(int posicionA, int posicionB, int distancia) {
	if (posicionA < 0) {
            throw new IllegalArgumentException("Error al asignar la posicionA: posicionA < 0");
        }
	if (posicionA > (getNumeroPosiciones() - 1)) {
            throw new IllegalArgumentException("Error al asignar la posicionA: posicionA > numeroPosiciones");
        }
        if (posicionB < 0) {
            throw new IllegalArgumentException("Error al asignar la posicionB: posicionB < 0");
        }
	if (posicionB > (getNumeroPosiciones() - 1)) {
            throw new IllegalArgumentException("Error al asignar la posicionB: posicionB > numeroPosiciones");
        }
	if (distancia < 0) {
            throw new IllegalArgumentException("Error al asignar la distancia: distancia < 0");
        }
        matrizDistancias[posicionA][posicionB] = distancia;
	matrizDistancias[posicionB][posicionA] = distancia;
    }
    
    /**
     * getDistanciaMatriz.  Obtiene la distancia entre dos posiciones de la matriz de distancias
     * @param posicionA:    posicion A de la matriz
     * @param posicionB:    posicion B de la matriz
     * @return		    Devielve la distancia entre dos posiciones de la matriz de distancias
     */
    public int getDistanciaMatriz(int posicionA, int posicionB) {
	return matrizDistancias[posicionA][posicionB];
    }

}



/*  ****************************DriverDistancia********************************
    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public void setPosicionMatriz(int nF, int nC) {
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
