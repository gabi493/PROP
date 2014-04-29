/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enunciadoteclado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



/**
 *
 * @author josep
 */
public class driverSimbolo {
    
    public static void main (String[] args) {
        String nombreclase = "simbolo";
        System.out.print("Driver" + nombreclase + ".");
        
        simbolo c = new simbolo();
        char dr; 
        String aux;     
        
             
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) simbolo()");
                System.out.println("\t 2) simbolo(char newc)");
                System.out.println("\t 3) simbolo(simbolo original)");
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
                            c = new simbolo();
                            break;
                        case "2":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo d = new simbolo(dr);    
                            break;
                        case "3":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            simbolo auxi = new simbolo(dr);
                            simbolo e = new simbolo(auxi);
                            break;
                        case "4": 
                            System.out.println("Caracter que contiene el simbolo: " + c.Info() + ".");
                            break;
                        case "5":
                            aux = palabras[1];
                            dr = aux.charAt(0);
                            c.ModificarCaracter(dr);
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
            System.out.println("Fin del driver");
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }
}
