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
public class controladorTeclado {
	
//	Atributos
	private teclado tecladoControlador;
    
//	Metodos
    public controladorTeclado (){
        tecladoControlador = null;
    }
    


    public void setTecladoControlador() {
		

        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			
			String linea;
			String palabras[];
			String opcion;

			linea = buffer.readLine();
			palabras = linea.split(" ");
			opcion = palabras[0];
			
			boolean out0 = false;
			boolean out1 = false;
			while (!out0) {
				while (!out1) {
					try {
						System.out.println("Escoger la forma del teclado:");
						System.out.println("\t 1) rectangular");
						System.out.println("\t 2) hexagonal");
						System.out.println("\t 0) SALIR SIN GUARDAR");

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
				
				if (!out0 && out1) out1 = false;
				while (!out1) {
					try {
						System.out.println("Escoger la forma de las teclas:");
						System.out.println("\t 1) rectangular");
						System.out.println("\t 2) hexagonal");
						System.out.println("\t 0) SALIR SIN GUARDAR");

						System.out.println("Opcion " + opcion + " seleccionada.");
						switch (opcion) {
							case "1":
								tecladoControlador.setTeclasDe4Lados(true);
								System.out.println("Forma teclas escogida = rectangular");
								out1 = true;
								break;
							case "2":
								tecladoControlador.setTeclasDe4Lados(false);
								System.out.println("Forma teclas escogida = hexagonal");
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
				
				if (!out0 && out1) out1 = false;
				while (!out1) {
					try {
						System.out.println("Escoger el numero de filas del teclado:");
						System.out.println("\t 0) SALIR SIN GUARDAR");
						switch (opcion) {
							case "0":
								System.out.print("SALIENDO...");
								out0 = out1 = true;
								break;
							default:
								tecladoControlador.setNumeroFilas(Integer.parseInt(palabras[0]));
								System.out.println("numero de filas = " + tecladoControlador.getNumeroFilas());
								out1 = true;
								break;
						}
					}
					catch (Exception e) { 
						System.out.println(e.getMessage());
					}
				}
				
				if (!out0 && out1) out1 = false;
				while (!out1) {
					try {
						System.out.println("Escoger el numero de columnas del teclado:");
						System.out.println("\t 0) SALIR SIN GUARDAR");

						switch (opcion) {
							case "0":
								System.out.print("SALIENDO...");
								out0 = out1 = true;
								break;
							default:
								tecladoControlador.setNumeroColumnas(Integer.parseInt(palabras[0]));
								System.out.println("numero de columnas = " + tecladoControlador.getNumeroColumnas());
								out1 = true;
								break;
						}
					}
					catch (Exception e) { 
						System.out.println(e.getMessage());
					}
				}
				
				if (!out0 && out1) out1 = false;
				while (!out1) {
					try {	
						System.out.println("Escoger el numero de Posiciones del teclado:");
						System.out.println("\t 0) SALIR SIN GUARDAR");

						switch (opcion) {
							case "0":
								System.out.print("SALIENDO...");
								out0 = out1 = true;
								break;
							default:
								tecladoControlador.setNumeroPosiciones(Integer.parseInt(palabras[0]));
								System.out.println("numero de posiciones = " + tecladoControlador.getNumeroPosiciones());
								out1 = true;
								break;
						}
					}
					catch (Exception e) { 
						System.out.println(e.getMessage());
					}
				}
				
			}
		}
        catch (Exception e) { 
			System.out.println(e.getMessage());
		}
	}
	
	
	
 
}
