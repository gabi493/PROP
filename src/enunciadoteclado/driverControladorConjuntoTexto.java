/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enunciadoteclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author josep
 */
public class driverControladorConjuntoTexto {
    public static void main (String[] args) {
        String nombreclase = "ConjuntoTexto";
        System.out.print("Driver" + nombreclase + ".");
        
        conjuntoTexto ct = new conjuntoTexto();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) conjuntoTexto()");
                System.out.println("\t 2) getSizeConjunto()");
                System.out.println("\t 3) getTextoI(int i)");
                System.out.println("\t 4) leerTextos()");
                System.out.println("\t 5) insertarTexto(texto text)");
                System.out.println("\t 6) borrarTexto(texto text)");
                System.out.println("\t 0) salir");
                
                String linea;
                String palabras[];
                String opcion;

                linea = buffer.readLine();
                palabras = linea.split(" ");
                opcion = palabras[0];
                
                try {
                    System.out.println("Opcion " + opcion + " seleccionada.");
                    switch (opcion) {
                        case "1": 
                            ct = new conjuntoTexto();
                            break;
                        case "2":
                            System.out.println("El conjunto contiene " + ct.getSizeConjunto() + " textos.");
                            break;
                        case "3":
                            int i = Integer.parseInt(palabras[1]);
                            texto ret = ct.getTextoI(i);
                            System.out.println("")
                            
                            

                            break;
                        case "4": 
                            simbolo add = new simbolo(palabras[1].charAt(0));
                            alf.addSimbolo(add);
                            break;
                        case "5":
                            alf.escribirAlfabeto();
                            break;
                        case "0":
                            out = true;
                            break;
                        default: 
                            System.out.println("La opcion elegida no existe.");
                            break;
                    }
                    
                }
                catch (Exception e) { 
                    System.out.println(e.getMessage());
                }
            } 
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }
    
}
