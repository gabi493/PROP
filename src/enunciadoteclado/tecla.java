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
public class tecla {
    
//  Atributos
    private char nombre;
    private int fila;
    private int columna;
    
//  Metodos
    public tecla() {}			    //constructor por defecto
    
    public tecla(char n, int x, int y) {    //constructor
	setNombre(n);
	setFila(x);
	setColumna(y);
    }
        
    public void setNombre(char n) {
	nombre = n;
    }
    
    public char getNombre() {
	return nombre;
    }
    
    public void setFila(int x) {
	if (x < 0) {
	    System.out.println("Error: fila negativa");
	    return;
	}
	fila = x;
    }
    
    public int getFila() {
	return fila;
    }
    
    public void setColumna(int y) {
	if (y < 0) {
	    System.out.println("Error: columna negativa");
	    return;
	}
	columna = y;
    }

    public int getColumna() {
	return columna;
    }
}
