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
                System.out.println("\t 4) simbolo Consultarsimbolo(int pos)");
                System.out.println("\t 5) boolean Boolsimbolo (simbolo s)");
                System.out.println("\t 6) int ConsultarPosicion(simbolo s)");
                System.out.println("\t 7) Anadirsimbolo (simbolo newsimbolo)");
                System.out.println("\t 8) Escribiralfabeto()");
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
                            break;
                        case "4": 
                            simbolo c = alf.consultarSimbolo(Integer.parseInt(palabras[1]));
                            System.out.println("Caracter que contiene la posicion " + palabras[1] + ": " + c.Info() + ".");
                            break;
                        case "5":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo e = new simbolo(dr);
                            alf.boolSimbolo(e);                            
                            System.out.println("Boolean is :" + alf.boolSimbolo(e));
                            break;
                        case "6":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo e1 = new simbolo(dr);
                            int pos = alf.consultarPosicion(e1);
                            System.out.println("Posicio " + pos);
                            break;
                        case "7":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo add = new simbolo(dr);
                            alf.anadirSimbolo(add);
                            break;
                        case "8":                            
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
