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
 * @author gabriel
 */
public class driverDistancia {
    public static void main (String[] args) {
        String nombreclase = "Distancia";
        System.out.print("Driver" + nombreclase);
        
        distancia dist = new distancia();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) distancia()");
                System.out.println("\t 2) distancia(int d, int t");
                System.out.println("\t 3) setDistancia(int d)");
                System.out.println("\t 4) getDistancia()");
                System.out.println("\t 5) setTamano(int t)");
                System.out.println("\t 6) getTamano()");
                System.out.println("\t 0) Salir");
                
                String linea;
                String palabras[];
                int opcion;

                linea = buffer.readLine();
                palabras = linea.split(" ");
                opcion = Integer.parseInt(palabras[0]);
                
                try {
                    System.out.println("Opcion " + opcion + " seleccionada.");
                    switch (opcion) {
                        case '1': 
                            dist = new distancia();
                            break;
                        case '2':
                            dist = new distancia(Integer.parseInt(palabras[1]), Integer.parseInt(palabras[2]));
                            break;
                        case '3':   //setDistancia
                            dist.setDistancia(Integer.parseInt(palabras[1]));
                            break;
                        case '4':   //getDistancia
                            System.out.println("Distancia = " + dist.getDistancia());
                            break;
                        case '5':   //setTamano
                            dist.setTamano(Integer.parseInt(palabras[1]));
                            break;
                        case '6':   //getTamano
                            System.out.println("Tamano = " + dist.getTamano());
                            break;
                        case '0':
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
