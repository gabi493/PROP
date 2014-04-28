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
        system.out.print("Driver" + nombreclase + "ejemplo con el caracter <k>");
        
        char k = 'k';
        
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) Simbolo()");
                System.out.println("\t 2) Simbolo(char c)");
                System.out.println("\t 3) Simbolo(Simbolo original)");
                System.out.println("\t 4) char Info()");
                System.out.println("\t 5) void ModificarCaracter(char newchar)");
            }
        }
        catch (Exception e) {
            
        }
    }
}
