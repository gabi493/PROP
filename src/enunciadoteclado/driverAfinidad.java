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
public class driverAfinidad {
    public static void main (String[] args) {
        String nombreclase = "afinidad";
        System.out.print("Driver " + nombreclase + ".");
        
        afinidad af = new afinidad();
                     
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1)afinidad()");
                System.out.println("\t 2) afinidad(int mida)");
                System.out.println("\t 3) insertarAfinidad(int i,int j,double afinidad)");
                System.out.println("\t 4) consultarAfinidad(int i,int j)");
                System.out.println("\t 5) escribirMatriz()");
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
                            af = new afinidad();
                            break;
                        case "2":
                            int n = Integer.parseInt(palabras[1]);
                            af = new afinidad(n);
                            break;
                        case "3":
                            int i = Integer.parseInt(palabras[1]);
                            int j = Integer.parseInt(palabras[2]);
                            double k = Double.parseDouble(palabras[3]);
                            af.insertarAfinidad(i, j, k);
                            break;
                        case "4":
                            int i2 = Integer.parseInt(palabras[1]);
                            int j2 = Integer.parseInt(palabras[2]);
                            double consulta = af.consultarAfinidad(i2, j2);
                            System.out.println("L'afinitat és de " + consulta);
                        case "5":
                            af.escribirMatriz();
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