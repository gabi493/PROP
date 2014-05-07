

import enunciadoteclado.controladorTexto;
import enunciadoteclado.simbolo;
import enunciadoteclado.texto;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alex
 */
public class driverControladorTexto {
    public static void main (String[] args) throws IOException {
        String nombreclase = "ControladorTexto";
        System.out.print("Driver" + nombreclase + ".");
        
        controladorTexto ct = new controladorTexto();
         try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) controladorTexto()");
                System.out.println("\t 2) abrirTexto(String nombre)");
                System.out.println("\t 3) cerrarTexto()");
                System.out.println("\t 4) leerParDeLetras(estadisticas e,alfabeto c)");
                System.out.println("\t 5) EcribirTexto(String SCadena)");
                System.out.println("\t 6) ModificarTexto(String Satigualinea,String Snuevalinea)");
                System.out.println("\t 7) LeerTexto()");
                System.out.println("\t 8) getRuta()");
                System.out.println("\t 9) getTitulo()");
                System.out.println("\t 10) getIdioma()");
                System.out.println("\t 0) salir");
                
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
                            ct = new controladortexto();
                            break;
                        case "2":
                            System.out.println("El conjunto contiene " + ct.getSizeConjunto() + " textos.");
                            break;
                        case "3":
                            int i = Integer.parseInt(palabras[1]);
                            texto ret = ct.getTextoI(i);
                            System.out.println("")
                            
                            

                            break;
                        case "4": 
                            simbolo add = new simbolo(palabras[1].charAt(0));
                            alf.addSimbolo(add);
                            break;
                        case "5":
                            alf.escribirAlfabeto();
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
    
