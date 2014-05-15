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
        String nombreclase = "Teclado";
        System.out.print("Driver" + nombreclase);
        
        teclado tec = null;
        controladorTeclado cTec = new controladorTeclado();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
				System.out.println("Elige una opicion:");
				System.out.println("\t 1) crearTeclado(formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados)");
				System.out.println("\t 2) cambiarForma(teclado, tipoTeclado)");
				System.out.println("\t 3) consultarForma(teclado)");
				System.out.println("\t 4) cambiarNumeroFilas(teclado, tamano)");
				System.out.println("\t 5) consultarNumeroFilas(teclado)");
				System.out.println("\t 6) cambiarNumeroColumnas(teclado, tamano)");
				System.out.println("\t 7) consultarNumeroColumnas(teclado)");
				System.out.println("\t 8) cambiarTeclasDe4Lados(teclado, b)");
				System.out.println("\t 9) consultarTeclasDe4Lados(teclado)");
				System.out.println("\t 10) cambiarNumeroPosiciones(teclado, numeroPosiciones)");
				System.out.println("\t 11) consultarNumeroPosiciones(teclado)");
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
						case "1": //formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados
							tec = cTec.crearTeclado(palabras[1], Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3]), Integer.parseInt(palabras[4]), Boolean.parseBoolean(palabras[5]));
							break;
						case "2":   //cambiarForma(teclado, tipoTeclado)
							cTec.cambiarForma(tec, palabras[1]);
                                                        break;
						case "3":   //consultarForma(teclado)
							System.out.println("Forma = " + tec.getForma());
							break;
						case "4":   //cambiarNumeroFilas(teclado, tamano)
							cTec.cambiarNumeroFilas(tec, Integer.parseInt(palabras[1]));
							break;
						case "5":   //consultarNumeroFilas(teclado)
							System.out.println("Numero Filas = " + tec.getNumeroFilas());
							break;
						case "6":   //cambiarNumeroColumnas(teclado, tamano)
							cTec.cambiarNumeroColumnas(tec, Integer.parseInt(palabras[1]));
							break;
						case "7":   //consultarNumeroColumnas(teclado)
							System.out.println("Numero Columnas = " + tec.getNumeroColumnas());
							break;
						case "8":   //cambiarTeclasDe4Lados(teclado, b)
							cTec.cambiarTeclasDe4Lados(tec, (palabras[1].equals("1")));
							break;
						case "9":   //consultarTeclasDe4Lados(teclado)
							System.out.println("Tiene teclas de 4 lados? = " + tec.getTeclasDe4Lados());
							break;
						case "10":   //cambiarNumeroPosiciones(teclado, numeroPosiciones)
							cTec.cambiarNumeroPosiciones(tec, Integer.parseInt(palabras[1]));
							break;
						case "11":   //consultarNumeroPosiciones(teclado)
							System.out.println("Numero de Posiciones = " + tec.getNumeroPosiciones());
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
