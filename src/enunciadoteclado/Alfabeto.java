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
public class Alfabeto {
    private String nombreAlfabeto;
    private int numCaracteres;
    private ArrayList<Simbolo> alfabeto;
    
    
   /**
    * Creadora por defecto. Crea un alfabeto sin ningun simbolo asociado.
    */
    public Alfabeto() {
        this.nombreAlfabeto = null;
        this.numCaracteres = 0;
        this.alfabeto = new ArrayList<>();
    }
    
    /**
     * Creadora. Crea un alfabeto con el nombre 'idioma', de n simbolos.
     * @param idioma Nom de l'alfabet
     * @param n Número de simbolos del alfabeto. 
     * @throws IllegalArgumentException.
     */
    public Alfabeto(String idioma, int n) throws IllegalArgumentException {
        this();
        if (n < 1) {
            throw new IllegalArgumentException("Error al crear alfabeto: n < 1");
        }
        this.nombreAlfabeto = idioma;
        this.numCaracteres = n;
        for (int i = 0; i < n; i++) this.alfabeto.add(new Simbolo());
    }
    
    /**
     * Constructora copia. Copia el alfabeto pasado por parametro explicito al parametro implícito.
     * @param original 
     */
    public Alfabeto(Alfabeto original) {
        this.nombreAlfabeto = original.nombreAlfabeto;
        this.numCaracteres = original.numCaracteres;
        this.alfabeto = original.alfabeto;
    }
    /**
     * Consultora d'un simbol a partir de posición. Devuelve el símbolo de la posición pos.
     * @param pos.
     * @return 
     * @throws IllegalArgumentException.
     */
    public Simbolo ConsultarSimbolo(int pos) {
        if (pos < 0) throw new IllegalArgumentException("Error al consultar: n < 1");
        if (pos > numCaracteres) throw new IllegalArgumentException("Error al consultar: pos > numCaracteres");
        return this.alfabeto.get(pos);
    }
    
    /**
     * Booleano de un simbolo. True si el simbolo esta en el alfabeto. False si no esta.
     * @param s.
     * @return
     */
    public boolean BoolSimbolo (Simbolo s) {
        return this.alfabeto.contains(s);
    }
    
    /**
     * Consultora d'una posició a partir de un simbolo. Retorna la posición del símbolo s.
     * @param s.
     * @return  
     * @throws IllegalArgumentException.
     */
    public int ConsultarPosicion(Simbolo s) {
        for (int i = 0; i < numCaracteres; i++) {
            if (this.alfabeto.contains(s)) return i;
        }
        throw new IllegalArgumentException("Error: El simbolo no está en el alfabeto.");
    }
    
    /**
     * Añadir simbolo. Se añade un neuevo simbolo al alfabeto.
     * @param newsimbolo.
     * @throws IllegalArgumentException.
     */
    public void AnadirSimbolo (Simbolo newsimbolo) {
        for (int i = 0; i < numCaracteres; i++) {
            if (this.alfabeto.contains(newsimbolo)) throw new IllegalArgumentException("Error: El simbolo ya está en el alfabeto.");
        }
        this.alfabeto.add(newsimbolo);
    }
}
