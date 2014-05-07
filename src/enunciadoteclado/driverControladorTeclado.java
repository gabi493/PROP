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
 * @author gabrielcarrillolopez
 */
public class driverControladorTeclado {
	public static void main (String[] args) {
        String nombreclase = "controladorTeclado";
        System.out.print("Driver" + nombreclase);
        
        controladorTeclado tecladoControlador = new controladorTeclado();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
			boolean outFinal = false;
            boolean out = false;
			while (!outFinal) {
				try {
					while (!out) {
						System.out.println("Escoger la forma del teclado:");
						System.out.println("\t 1) rectangular");
						System.out.println("\t 2) hexagonal");
						System.out.println("\t 0) SALIR SIN GUARDAR");

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
									tecladoControlador.setForma("rectangular");
									System.out.println("Forma escogida = " + tecladoControlador.getForma());
									out1 = true;
									break;
								case "2":
									tecladoControlador.setForma("hexagonal");
									System.out.println("Forma escogida = " + tecladoControlador.getForma());
									out1 = true;
									break;
								case "0":
									System.out.print("SALIENDO...");
									out0 = out1 = true;
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
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
