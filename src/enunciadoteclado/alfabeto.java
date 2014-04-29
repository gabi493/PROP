package enunciadoteclado;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josep
 */
public class alfabeto {
    private String nombreAlfabeto;
    private int numCaracteres;
    private ArrayList<simbolo> alf;
    
    
   /**
    * Creadora por defecto. Crea un alfabeto sin ningun simbolo asociado.
    */
    public alfabeto() {
        this.nombreAlfabeto = null;
        this.numCaracteres = 0;
        this.alf = new ArrayList<>();
    }
    
    /**
     * Creadora. Crea un alfabeto con el nombre 'idioma', de n simbolos.
     * @param idioma Nom de l'alfabet
     * @param n Número de simbolos del alfabeto. 
     * @throws IllegalArgumentException.
     */
    public alfabeto(String idioma, int n) throws IllegalArgumentException {
        this();
        if (n < 1) {
            throw new IllegalArgumentException("Error al crear alfabeto: n < 1");
        }
        this.nombreAlfabeto = idioma;
        this.numCaracteres = n;
        for (int i = 0; i < n; i++) this.alf.add(new simbolo());
    }
    
    
    
    /**
     * Constructora copia. Copia el alfabeto pasado por parametro explicito al parametro implícito.
     * @param original 
     */
    public alfabeto(alfabeto original) {
        this.nombreAlfabeto = original.nombreAlfabeto;
        this.numCaracteres = original.numCaracteres;
        this.alf = original.alf;
    }
    /**
     * Consultora d'un simbol a partir de posición. Devuelve el símbolo de la posición pos.
     * @param pos.
     * @return 
     * @throws IllegalArgumentException.
     */
    public simbolo consultarSimbolo(int pos) {
        if (pos < 0) throw new IllegalArgumentException("Error al consultar: n < 1");
        if (pos > numCaracteres) throw new IllegalArgumentException("Error al consultar: pos > numCaracteres");
        return this.alf.get(pos);
    }
    
    /**
     * Booleano de un simbolo. True si el simbolo esta en el alfabeto. False si no esta.
     * @param s.
     * @return
     */
    public boolean boolSimbolo (simbolo s) {
        return this.alf.contains(s);
    }
    
    /**
     * Consultora d'una posició a partir de un simbolo. Retorna la posición del símbolo s.
     * @param s.
     * @return  
     * @throws IllegalArgumentException.
     */
    public int consultarPosicion(simbolo s) {
        for (int i = 0; i < numCaracteres; i++) {
            if (this.alf.contains(s)) return i;
        }
        throw new IllegalArgumentException("Error: El simbolo no está en el alfabeto.");
    }
    
    /**
     * Añadir simbolo. Se añade un neuevo simbolo al alfabeto.
     * @param newsimbolo.
     * @throws IllegalArgumentException.
     */
    public void anadirSimbolo (simbolo newsimbolo) {
        for (int i = 0; i < numCaracteres; i++) {
            if (this.alf.contains(newsimbolo)) throw new IllegalArgumentException("Error: El simbolo ya está en el alfabeto.");
        }
        this.alf.add(newsimbolo);
    }
    
    public void escribirAlfabeto() {
        for (int i = 0; i < numCaracteres; i++) System.out.println (this.alf.get(i).Info() + " ");
    }
}
