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
public class conjunto_texto {
    public ArrayList<Texto> conjunto;
    int numero_textos;
    
    /**
     *
     */
    public conjunto_texto() {
        conjunto = new ArrayList<Texto>();
        this.numero_textos = 0;
        
    }
    
    /**
     *
     * @param text 
     */
    public void insertar_texto(Texto text) {
        this.conjunto.add(text);
        ++numero_textos;
    }

    /**
     *
     * @throws java.io.IOException
     */
    public void leer_textos() throws IOException{
        ControladorTexto Ct = new ControladorTexto();
        for(int i=0; i < this.conjunto.size();++i){
            Ct.abrirTexto(conjunto.get(i).Titulo + ".txt");
            Ct.LeerTexto();
        }
    }

    /**
     *
     * @param text
     */
    public void borrar_texto(Texto text) {
        int n = conjunto.size();
        ArrayList<Texto> textos = new ArrayList<Texto>(n-1);
        for(int i=0; i < n; ++i) {
            if(conjunto.get(i) != text) {
               textos.add(conjunto.get(i));
            }
        }
        conjunto = textos;
    }

}
