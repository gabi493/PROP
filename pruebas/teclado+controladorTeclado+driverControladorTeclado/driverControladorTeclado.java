/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package enunciadoteclado;

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
			/*	System.out.println("Elige una opicion:");
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
			*/	
				
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
                                                String formaTeclado = "no seleccionado";
                                                int numeroFilas = 0;
                                                int numeroColumnas = 0;
                                                int numeroPosiciones = 0;
                                                boolean teclas4Lados = false;
                                                
						case "1": //formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados
                                                        

                                                        boolean out1 = false;
                                                        while (!out1) {
                                                            System.out.println("Escoger forma del teclado: ");
                                                            System.out.println("\t 1) rectangular");
                                                            System.out.println("\t 2) hexagonal");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                switch(palabras[1]) {
                                                                        case "1":   //rectangular
                                                                                formaTeclado = "rectangular";
                                                                                out1 = true;
                                                                                break;
                                                                        case "2":   //hexagonal
                                                                                formaTeclado = "hexagonal";
                                                                                out1 = true;
                                                                                break;
                                                                        case "0":   //SALIR
                                                                                System.out.print("SALIENDO...");
                                                                                out = out1 = true;
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
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado);


                                                        out1 = false;
                                                        int n = 0;
                                                        while (!out && !out1) {
                                                            System.out.println("Introducir numero de filas del teclado: ");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[2]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    n = Integer.parseInt(opcion[2]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n);


                                                        out1 = false;
                                                        int m = 0;
                                                        while (!out && !out1) {
                                                            System.out.println("Introducir numero de columnas del teclado: ");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[3]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    m = Integer.parseInt(opcion[2]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n + ", numeroColumnas = " + m);


                                                        out1 = false;
                                                        int p = 0;
                                                        while (!out && !out1) {
                                                            System.out.println("Introducir numero de posiciones del teclado: ");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[4]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    p = Integer.parseInt(opcion[2]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n + ", numeroColumnas = " + m + ", numeroPosiciones = " + p);


                                                        out1 = false;
                                                        boolean b = false;
                                                        while (!out && !out1) {
                                                            System.out.println("Escoger numero de lados del teclado: ");
                                                            System.out.println("\t 4) 4 lados");
                                                            System.out.println("\t 6) 6 lados");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[5]) {
                                                                            case "4":   //4 lados
                                                                                    b = true;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "6":   //6 lados
                                                                                    b = false;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
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
                                                        if (!out) {
                                                            System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n + ", numeroColumnas = " + m + ", numeroPosiciones = " + p + ", teclasDe4Lados? = " + b);
                                                            tec = cTec.crearTeclado(formaTeclado, n, m, p, b);
                                                        }
                                                        else System.out.println("Ya he salido");
							break;
						case "2":   //cambiarForma(teclado, tipoTeclado)
                                                        boolean out1 = false;
                                                        while (!out1) {
                                                            System.out.println("Escoger forma del teclado: ");
                                                            System.out.println("\t 1) rectangular");
                                                            System.out.println("\t 2) hexagonal");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[1]) {
                                                                            case "1":   //rectangular
                                                                                    formaTeclado = "rectangular";
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "2":   //hexagonal
                                                                                    formaTeclado = "hexagonal";
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
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
                                                        if (!out) {
                                                            System.out.println("formaTeclado = " + formaTeclado);
                                                            cTec.cambiarForma(tec, formaTeclado);
                                                        }
                                                        break;
						case "3":   //consultarForma(teclado)
							System.out.println("Forma = " + tec.getForma());
							break;
						case "4":   //cambiarNumeroFilas(teclado, tamano)
                                                        boolean out1 = false;
                                                        while (!out1) {
                                                            System.out.println("Introducir numero de filas del teclado: ");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[1]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    n = Integer.parseInt(opcion[2]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        if (!out) {
                                                            System.out.println("numeroFilas = " + n);
                                                            cTec.cambiarNumeroFilas(tec, n);
                                                        }
                                                        break;
						case "5":   //consultarNumeroFilas(teclado)
							System.out.println("Numero Filas = " + tec.getNumeroFilas());
							break;
						case "6":   //cambiarNumeroColumnas(teclado, tamano)
                                                        boolean out1 = false;
                                                        while (!out1) {
                                                            System.out.println("Introducir numero de columnas del teclado: ");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[1]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    m = Integer.parseInt(opcion[2]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        if (!out) {
                                                            System.out.println("numeroFilas = " + m);
                                                            cTec.cambiarNumeroColumnas(tec, m);
                                                        }
                                                        break;
						case "7":   //consultarNumeroColumnas(teclado)
							System.out.println("Numero Columnas = " + tec.getNumeroColumnas());
							break;
						case "8":   //cambiarTeclasDe4Lados(teclado, b)
                                                        boolean out1 = false;
                                                        boolean b = false;
                                                        while (!out1) {
                                                            System.out.println("Escoger numero de lados del teclado: ");
                                                            System.out.println("\t 4) 4 lados");
                                                            System.out.println("\t 6) 6 lados");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[1]) {
                                                                            case "4":   //4 lados
                                                                                    b = true;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "6":   //6 lados
                                                                                    b = false;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
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
                                                        if (!out) {
                                                            System.out.println("teclasDe4Lados? = " + b);
                                                            cTec.cambiarTeclasDe4Lados(tec, b);
                                                        }
                                                        break;
                                                        
							//cTec.cambiarTeclasDe4Lados(tec, (palabras[1].equals("1")));
							//break;
						case "9":   //consultarTeclasDe4Lados(teclado)
							System.out.println("Tiene teclas de 4 lados? = " + tec.getTeclasDe4Lados());
							break;
						case "10":   //cambiarNumeroPosiciones(teclado, numeroPosiciones)
                                                        boolean out1 = false;
                                                        int p = 0;
                                                        while (!out1) {
                                                            System.out.println("Introducir numero de posiciones del teclado: ");
                                                            System.out.println("\t 0) SALIR");

                                                            try {
                                                                    switch(palabras[1]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    p = Integer.parseInt(opcion[2]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        if (!out) {
                                                            System.out.println("numeroPosiciones = " + p);
                                                            cTec.cambiarNumeroPosiciones(tec, p);
                                                        }
                                                        break;

							//cTec.cambiarNumeroPosiciones(tec, Integer.parseInt(palabras[1]));
							//break;
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
