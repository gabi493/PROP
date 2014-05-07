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
public class driverEstadisticas {
    public static void main (String[] args) {
        String nombreclase = "estadisticas";
        System.out.print("Driver " + nombreclase + ".");
        
        estadisticas es = new estadisticas();
                     
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            estadisticas e = new estadisticas();
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) estadisticas()");
                System.out.println("\t 2) estadisticas(int mida)()");
                System.out.println("\t 3) insertarEstadistica (int i, int j, double similitud)");
                System.out.println("\t 4) consultarEstadistica (int i, int j)");
                System.out.println("\t 0) Salir");
                
                String linea;
                String palabras[];
                String opcion;

                linea = buffer.readLine();
                palabras = linea.split(" ");
                opcion = palabras[0];
<<<<<<< HEAD
                e.leerMatriz();
                try {
                    System.out.println("Opcion " + opcion + " seleccionada.");
                    switch (opcion) {
                        case "1": 
                            int mida = Integer.parseInt(palabras[1]);
                            e = new estadisticas(mida);
                            e.leerMatriz();
=======
                
                
                try {
                    System.out.println("Opcion " + opcion + " seleccionada.");
                    switch (opcion) {
			case "1":
			    es = new estadisticas();
                        case "2": 
                            es = new estadisticas(Integer.parseInt(palabras[1]));
>>>>>>> a5d9f8b555bb90998b18c06ce2f57df321c9266d
                            break;
                        case "3":
                            int i = Integer.parseInt(palabras[1]);
                            int j = Integer.parseInt(palabras[2]);
                            int similitud = Integer.parseInt(palabras[3]);
<<<<<<< HEAD
                            System.out.println(i);
                            System.out.println(j);
                            System.out.println(similitud);
                            e.insertarEstadistica(i, j, similitud);
                            System.out.println("Se han añadido las nuevas estadisticas en la matriz.");
                            e.leerMatriz();
=======
                            es.insertarEstadistica(i, j, similitud);
                            System.out.println("Se han añadido las nuevas estadisticas en la matriz.");
                            es.leerMatriz();
>>>>>>> a5d9f8b555bb90998b18c06ce2f57df321c9266d
                            break;
                        case "4":
                            int i2 = Integer.parseInt(palabras[1]);
                            int j2 = Integer.parseInt(palabras[2]);
                            double est = es.consultarEstadistica(i2, j2);
                            System.out.println("La afinidad entre estas dos letras es " + est);
<<<<<<< HEAD
                            e.leerMatriz();
=======
                            es.leerMatriz();
>>>>>>> a5d9f8b555bb90998b18c06ce2f57df321c9266d
                            break;
                        case "0":
                            out = true;
                            break;
                        default: 
                            System.out.println("La opcion elegida no existe.");
                            break;
                        
                    }
                } 
                catch (Exception ex) { 
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println("Fin del driver");
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }
}
