/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enunciadoteclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*enum TipoTeclado {
    rectangular,
    hexagonal,
    dosHexagonos,
}*/

/**
 *
 * @author gabriel
 */
public class driverTeclado {
    public static void main (String[] args) {
        String nombreclase = "Teclado";
        System.out.print("Driver" + nombreclase + "ejemplo con distancia cast");
        
        teclado tcdo = new teclado();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) teclado()");
                System.out.println("\t 2) teclado(formaTeclado, numeroFilas, numeroColumnas, teclas4Lados)");
                System.out.println("\t 3) setForma(tipoTeclado)");
                System.out.println("\t 4) getForma()");
                System.out.println("\t 5) setNumFilas(tamano)");
                System.out.println("\t 6) getNumFilas()");
                System.out.println("\t 7) setNumCols(tamano)");
                System.out.println("\t 8) getNumCols()");
                System.out.println("\t 9) setTeclasDe4Lados(b)");
                System.out.println("\t 10) getTeclasDe4Lados()");
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
                            tcdo = new teclado();
                            break;
                        case "2":
                            int b = Integer.parseInt(palabras[3]);
                            Boolean bl;
                            if (b == '1') bl = true;
                            else bl = false;
                            //String tt = palabras[1];
                            tcdo = new teclado(palabras[1], Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3]), bl);
                            break;
                        case "3":   //setForma
                            String tt = palabras[1];
                            tcdo.setForma(tt);
                            break;
                        case "4":   //getForma
                            System.out.println("Forma = " + tcdo.getForma());
                            break;
                        case "5":   //setNumFilas
                            tcdo.setNumFilas(Integer.parseInt(palabras[1]));
                            break;
                        case "6":   //getNumFilas
                            System.out.println("Numero Filas = " + tcdo.getNumFilas());
                            break;
                        case "7":   //setNumCols
                            tcdo.setNumCols(Integer.parseInt(palabras[1]));
                            break;
                        case "8":   //getNumCols
                            System.out.println("Numero Columnas = " + tcdo.getNumCols());
                            break;
                        case "9":   //setTeclasDe4Lados
			    int bb = Integer.parseInt(palabras[3]);
                            Boolean bbl;
                            if (bb == '1') bbl = true;
                            else bbl = false;
                            tcdo.setTeclasDe4Lados(bbl);
                            break;
                        case "10":   //getTeclasDe4Lados
                            System.out.println("Tiene teclas de 4 lados? = " + tcdo.getTeclasDe4Lados());
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
