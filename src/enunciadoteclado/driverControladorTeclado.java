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
public class driverControladorTeclado {
    public static void main (String[] args) {
        String nombreclase = "ControladorTeclado";
        System.out.print("Driver" + nombreclase);
        
        controladorTeclado cTeclado = new controladorTeclado();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
				System.out.println("Elige una opicion:");
				System.out.println("\t 1) teclado()");
				System.out.println("\t 2) teclado(formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados)");
				System.out.println("\t 3) setForma(tipoTeclado)");
				System.out.println("\t 4) getForma()");
				System.out.println("\t 5) setNumFilas(tamano)");
				System.out.println("\t 6) getNumFilas()");
				System.out.println("\t 7) setNumCols(tamano)");
				System.out.println("\t 8) getNumCols()");
				System.out.println("\t 9) setTeclasDe4Lados(b)");
				System.out.println("\t 10) getTeclasDe4Lados()");
				System.out.println("\t 11) setNumeroPosiciones(numeroPosiciones)");
				System.out.println("\t 12) getNumeroPosiciones()");
				System.out.println("\t 0) Salir");
				
				
				System.out.println();
				
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
							cTeclado = new cTeclado();
							break;
						case "2":
							int b = Integer.parseInt(palabras[3]);
							boolean bl;
							if (b == '1') bl = true;
							else bl = false;
						case "4":   //getForma
							System.out.println("Forma = " + cTeclado.getForma());
							break;
						case "5":   //setNumFilas
							cTeclado.setNumeroFilas(Integer.parseInt(palabras[1]));
							break;
						case "6":   //getNumFilas
							System.out.println("Numero Filas = " + cTeclado.getNumeroFilas());
							break;
						case "7":   //setNumCols
							cTeclado.setNumeroColumnas(Integer.parseInt(palabras[1]));
							break;
						case "8":   //getNumCols
							System.out.println("Numero Columnas = " + cTeclado.getNumeroColumnas());
							break;
						case "9":   //setTeclasDe4Lados
							cTeclado.setTeclasDe4Lados(palabras[1].equals("1"));
							break;
						case "10":   //getTeclasDe4Lados
							System.out.println("Tiene teclas de 4 lados? = " + cTeclado.getTeclasDe4Lados());
							break;
						case "11":   //setNumeroPosiciones
							cTeclado.setNumeroPosiciones(Integer.parseInt(palabras[1]));
							break;
						case "12":   //getNumeroPosiciones
							System.out.println("Numero de Posiciones = " + cTeclado.getNumeroPosiciones());
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
