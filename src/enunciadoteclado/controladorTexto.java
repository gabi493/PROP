/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enunciadoteclado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
/**
 *
 * @author alex
 */
public class controladorTexto {
    File archivo;
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    

    /**
     *
     */
    public controladorTexto (){
        archivo = null;
        fr = null;
        br = null;
    }
    

    /**
     * 
     * @param path 
     * @throws IOException 
     */
    public void abrirTexto(String path) throws IOException {
        archivo = new File(path);
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        
    }
    /**
     *
     * @throws IOException
     */
    public void cerrarTexto() throws IOException{
        archivo = null;
        if(null != fr) {
            fr.close();
        }
        if(null != fw) {
            br.close();
        }
    }
    public void leerParDeLetras(estadisticas e,alfabeto c) throws IOException {
        if(archivo == null){
           throw new IllegalArgumentException("Error: No tienes ningun archivo abierto.");
        }
        fr = new FileReader(archivo);
        BufferedReader in = new BufferedReader(fr);
        String linia = in.readLine();
        linia = in.readLine();
        int caract1 = fr.read();
        int caract2 = fr.read();
            //Se recorre el fichero hasta encontrar el carácter -1
            //   que marca el final del fichero
        while(caract1 != -1 && caract2 != -1) {
                simbolo a = new simbolo((char)caract1);
                simbolo b = new simbolo((char)caract2);
                e.insertarEstadistica(a,b,1,c);
                caract2 = caract1;
                caract2 = fr.read();  
            }

        }
    
     public void EcribirTexto(String SCadena){
        try {
            //Escribe en el fichero la cardena que recibe la funcion. la cadena "\r\n" significa salto de linea
             //Si no Existe el fichero lo crea
            //Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. Ademas   en
            //el pedazo de sentencia "FileOutputStream(Ffichero,true)", true es por si existe el fichero
            //segir añadiendo texto y no borrar lo que tenia
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.archivo,true), "utf-8"));
                //Escribe en el fichero la cardena que recibe la funcion. la cadena "\r\n" significa salto de linea
            Fescribe.write(SCadena + "\r\n");
       
            }catch (IOException ex) {
               //Captura un posible error y le imprime en pantalla 
               System.out.println(ex.getMessage());
            }
        
    } 
     public void ModificarTexto(String Satigualinea,String Snuevalinea){        
        /*Obtengo un numero aleatorio*/
        Random numaleatorio= new Random(3816L); 
        /*Creo un nombre para el nuevo fichero apartir del
         *numero aleatorio*/
        String SnombFichNuev=archivo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo=new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if(archivo.exists()){
                try ( /*Abro un flujo de lectura*/ 
                    BufferedReader Flee = new BufferedReader(new FileReader(archivo))) {
                    String Slinea;
                    /*Recorro el fichero de texto linea a linea*/
                    while((Slinea=Flee.readLine())!=null) {
                        /*Si la lia obtenida es igual al la bucada
                        *para modificar*/
                        if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                            /*Escribo la nueva linea en vez de la que tenia*/
                            this.EcribirTexto(Snuevalinea);
                        }else{
                            /*Escribo la linea antigua*/
                            this.EcribirTexto(Satigualinea);
                        }
                    }             
                    /*Obtengo el nombre del fichero inicial*/
                    String SnomAntiguo=archivo.getName();
                    /*Borro el fichero inicial*/
                    archivo.delete();
                    /*renombro el nuevo fichero con el nombre del fichero inicial*/
                    FficheroNuevo.renameTo(archivo);
                }
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (IOException ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    public void LeerTexto(){
    try {
       /*Si existe el fichero*/
       if(!archivo.exists()){
           System.out.println("Fichero No Existe");
       }else{
           try ( /*Abre un flujo de lectura a el fichero*/ 
               BufferedReader Flee = new BufferedReader(new FileReader(archivo))) {
               String linia = Flee.readLine();
               linia = Flee.readLine();
               String Slinea;
               System.out.println("**********Leyendo Fichero***********");
               /*Lee el fichero line a linea hasta llegar a la ultima*/
               while((Slinea=Flee.readLine())!=null) {
                   /*Imprime la linea leida*/
                   System.out.println(Slinea);
               }              
               System.out.println("*********Fin Leer Fichero**********");
           }
       }
   } catch (IOException ex) {
       /*Captura un posible error y le imprime en pantalla*/ 
        System.out.println(ex.getMessage());
   }
 }
    
}

