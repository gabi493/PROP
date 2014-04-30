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
public class driverControladorAlfabeto {
    public static void main (String[] args) {
        String nombreclase = "alfabeto";
        System.out.print("Driver" + nombreclase + ".");
        
        alfabeto alf = new alfabeto();
        String aux;
        char dr;
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) alfabeto()");
                System.out.println("\t 2) alfabeto(String idioma, int n)");
                System.out.println("\t 3) alfabeto(alfabeto original)");
                System.out.println("\t 4) addSimbolo (simbolo newsimbolo)");
                System.out.println("\t 5) swapSimbolo (simbolo a, simbolo b)");
                System.out.println("\t 6) escribirAlfabeto()");
                System.out.println("\t 0) Salir");
                
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
                            alf = new alfabeto();
                            break;
                        case "2":
                            alf = new alfabeto((palabras[1]), Integer.parseInt(palabras[2]));
                            break;
                        case "3":
                            alf = new alfabeto((palabras[1]), Integer.parseInt(palabras[2]));
                            alfabeto copia = new alfabeto(alf);
                            System.out.println("La copia del alfabeto es: ");
                            copia.escribirAlfabeto();
                            break;
                        case "4": 
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo add = new simbolo(dr);
                            alf.addSimbolo(add);
                            break;
                        case "5":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo e = new simbolo(dr);
                            
                            String aux1 = palabras[2];
                            char dr1 = aux1.charAt(0);
                            simbolo e1 = new simbolo(dr1);
                            
                            System.out.println("Simbolos iniciales: " + e.getInfo() + " " + e1.getInfo());
                            alf.swapSimbolos(e, e1);;
                            System.out.println("Simbolos finales: " + e.getInfo() + " " + e1.getInfo());
                            break;
                        case "6":
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
