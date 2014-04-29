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
public class driverAlfabeto {
    public static void main (String[] args) {
        String nombreclase = "Alfabeto";
        System.out.print("Driver" + nombreclase + "ejemplo con alfabeto cast");
        
        Alfabeto cast = new Alfabeto();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) Alfabeto()");
                System.out.println("\t 2) Alfabeto(String idioma, int n)");
                System.out.println("\t 3) Alfabeto(Alfabeto original)");
                System.out.println("\t 4) Simbolo ConsultarSimbolo(int pos)");
                System.out.println("\t 5) boolean BoolSimbolo (Simbolo s)");
                System.out.println("\t 6) int ConsultarPosicion(Simbolo s)");
                System.out.println("\t 7) AnadirSimbolo (Simbolo newsimbolo)");
                System.out.println("\t 8) EscribirAlfabeto()");
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
                            cast = new Alfabeto();
                            break;
                        case "2":
                            cast = new Alfabeto((palabras[1]), parseInt(palabras[2])); // ???
                            break;
                        case "3":
                            Alfabeto d(cast);  //  ???
                            cast = d;
                            break;
                        case "4": 
                            Simbolo c = cast.ConsultarSimbolo(parseInt(palabras[1]));
                            System.out.println("Caracter que contiene la posicion " + palabras[1] + ": " + c.Info() + ".");
                            break;
                        case "5":
                            Simbolo e(palabras[1]);
                            //cast.BoolSimbolo(e);
                            System.out.println("Boolean is :" + cast.BoolSimbolo(e));
                            break;
                        case "6":
                            Simbolo aux(palabras[1]);
                            int pos = cast.ConsultarPosicion(aux);
                            System.out.println("Posicio " + aux);
                            break;
                        case "7":
                            Simbolo add(palabras[1]);
                            cast.AnadirSimbolo(add);
                            break;
                        case "8":                            
                            cast.EscribirAlfabeto();
                            break;
                        case "0":
                            out = true;
                            break;
                        default: 
                            System.out.println("La opcion elegida no existe.");
                            break;
                    }
                    
                }
                catch (Exception e) System.out.println(e.getMessage());
            } 
        }
        catch (Exception e) System.out.println(e.getMessage());
    }
}
