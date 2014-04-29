/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enunciadoteclado;

/**
 *
 * @author josep
 */
public class Simbolo {
    private char caracter;
    
    /**
     * Constructora por defecto. Inicializamos a 0 porque no se puede poner
     * un char a null.
     */
    public Simbolo() {
        this.caracter = 0;
    }
    
    /**
     * Constructora
     * @param c que contendrá el simbolo creado.
     */
    public Simbolo(char c) {
        this.caracter = c;
    }
    
    /**
     *Constructora copia
     * @param original Simbolo que se va a copiar.
     */
    public Simbolo(Simbolo original) {
        if (original.caracter == 0) this.caracter = 0;
        else this.caracter = original.caracter;
    }
    
    /**
     * Devuelve la informacion del simbolo.
     * @return 
     */
    public char Info() throws IllegalArgumentException {
        if (this.caracter == 0) throw new IllegalArgumentException("Error al consultar la informacion del simbolo: referencia nula");
        return this.caracter;
    }
    
    /**
     * Modifica el caracter del simbolo.
     * @param newchar El nuevo caracter asociado al simbolo.
     */
    public void ModificarCaracter(char newchar) {
        this.caracter = newchar;
    }
    
}
