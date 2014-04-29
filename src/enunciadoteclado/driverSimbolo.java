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
public class driverSimbolo {
    
    public static void main (String[] args) {
        String nombreclase = "Simbolo";
        System.out.print("Driver" + nombreclase + "ejemplo con el simbolo c");
        
        Simbolo c = new Simbolo();
        
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) Simbolo()");
                System.out.println("\t 2) Simbolo(char newc)");
                System.out.println("\t 3) Simbolo(Simbolo original)");
                System.out.println("\t 4) char Info()");
                System.out.println("\t 5) void ModificarCaracter(char newchar)");
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
                            c = new Simbolo();
                            break;
                        case "2":
                            c = Simbolo(palabras[1]);
                            break;
                        case "3":
                            Simbolo d(c);                   
                            c = d;
                            break;
                        case "4": 
                            System.out.println("Caracter que contiene el simbolo: " + c.Info() + ".");
                            break;
                        case "5":
                            c.ModificarCaracter(palabras.[1]);
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
            System.out.println("Fin del driver");
        }
        catch (Exception e) System.out.println(e.getMessage());
    }
}
