
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import enunciadoteclado.estadisticas;
import enunciadoteclado.simbolo;
import enunciadoteclado.alfabeto;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author alex
 */
public class controladorTexto {
    File archivo;
    FileReader fr;
    BufferedReader br;
    String ruta;
    
    
        
  
    /**
     *
     */
    public controladorTexto (){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        ruta = chooser.getCurrentDirectory().getAbsolutePath();
        ruta += "\\Documentacion\\";
        System.out.println("Ruta " + ruta);
    }
    
    
    public void realizarAccion(String accion,String nombre) throws IOException {
        JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Textos", "txt");
            chooser.setFileFilter(filter);
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Abre,edita,lee o crea");
            //Elegiremos archivos del directorio
            
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setAcceptAllFileFilterUsed(true);
            //Si seleccionamos algún archivo retornaremos su directorio
            if(accion == "abrir" || accion == "editar" || accion == "seleccionar") {
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Directorio: " + chooser.getCurrentDirectory().getAbsolutePath());
                    File textoSeleccionado = chooser.getSelectedFile();
                    System.out.println(textoSeleccionado);
                    Desktop desktop = null;
                    Desktop.Action action = null;
                    if( Desktop.isDesktopSupported() == true ){
                            desktop = Desktop.getDesktop();
                            if(accion.equalsIgnoreCase( "abrir" ) ){
                                action = Desktop.Action.OPEN;
                            }
                            if(accion.equalsIgnoreCase( "seleccionar" ) ){
                                archivo = textoSeleccionado;
                            }
                            else if(accion.equalsIgnoreCase( "editar" ) ){
                            action = Desktop.Action.EDIT;
                            }
                            
                    }
                    switch( action ){
                        case OPEN :
                        System.out.println( "DENTRO DE OPCION: OPEN" );
                        desktop.open(textoSeleccionado);
                        break;
                        case EDIT :
                        System.out.println( "DENTRO DE OPCION: EDIT" );
                        desktop.edit(textoSeleccionado);
                        break;
                        
                        

                    }
                }
                else System.out.println("No seleccion ");
            
            }
            else if(accion == "crear") {
                String rutaArchivo = ruta + nombre + ".txt";
                System.out.println("La ruta del archivo es "+ rutaArchivo);
                File texto = new File(rutaArchivo);
                if(!texto.exists()) {
                    if(texto.createNewFile()) System.out.println("Se a creado un texto");
                    else System.out.println("No se a podido crear el texto");
                }
                
            }
            else System.out.println("La accion no es possible ");          
            
            
    }
    
    
    
    
    

    
    public void abrirTexto(String nombre) throws IOException {
        archivo = new File(nombre);
        ruta = archivo.getAbsolutePath();
        if(!archivo.exists()){
            throw new IOException ("Error: Texto no existe");
        }
        
    }
    /**
     *
     * @throws IOException
     */
    public void cerrarTexto() throws IOException{
        archivo = null;
        ruta = null;
        if(null != fr) {
            fr.close();
        }
        if(null != br) {
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
            if(!c.boolSimbolo(a)) {
                if(c.boolSimbolo(b)) a = b;
                else {
                    while(!c.boolSimbolo(a) && caract1 != -1) {
                        caract1 = fr.read();
                        a = new simbolo((char)caract1);
                    }
                }
            }
            if(!c.boolSimbolo(b)) {
                while(!c.boolSimbolo(b) && caract2 != -1) {
                    caract2 = fr.read();
                    b = new simbolo((char)caract2);
                }  
            }  
            int i = c.getPosicion(a);
            int j = c.getPosicion(b);
            e.insertarEstadistica(i,j,1);
            caract2 = caract1;
            caract2 = fr.read();  
            }

        }
    
     public void escribirTexto(String SCadena){
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
     public void modificarTexto(String Satigualinea,String Snuevalinea){        
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
                            this.escribirTexto(Snuevalinea);
                        }else{
                            /*Escribo la linea antigua*/
                            this.escribirTexto(Satigualinea);
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
    public void leerTexto(){
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
    
    /**
     *
     * @return
     */
    public String getRuta(){
        return ruta;
    }
    public String getTitulo() throws IOException {
        BufferedReader Flee = new BufferedReader(new FileReader(archivo));
        return Flee.readLine();
    }
    public String getIdioma() throws IOException {
        BufferedReader Flee = new BufferedReader(new FileReader(archivo));
        Flee.readLine();
        return Flee.readLine();
    }
 
    
}
