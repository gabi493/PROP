package enunciadoteclado;
import java.io.IOException;
import java.util.LinkedList ;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class conjuntoTexto {
    private ArrayList<texto> conjunto;
    private int numero_textos;
    
    /**
     *
     */
    public conjuntoTexto() {
        this.conjunto = new ArrayList<texto>();
        this.numero_textos = 0;
        
    }
    
    /**
     *
     * @param text 
     */
    public void insertar_texto(texto text) {
        this.conjunto.add(text);
        ++numero_textos;
    }

    /**
     *
     * @throws java.io.IOException
     */
    public void leer_textos() throws IOException{
        controladorTexto Ct = new controladorTexto();
        for(int i=0; i < conjunto.size();++i){
            Ct.abrirTexto(conjunto.get(i).Titulo + ".txt");
            Ct.LeerTexto();
           
            
        }
    }

    /**
     *
     * @param text
     */
    public void borrar_texto(texto text) {
        int n = conjunto.size();
        ArrayList<texto> textos = new ArrayList<texto>(n-1);
        for(int i=0; i < n; ++i) {
            if(conjunto.get(i) != text) {
               textos.add(conjunto.get(i));
            }
        }
        conjunto = textos;
    }

}
