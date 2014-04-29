    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
/**
 *
 * @author alex
 */
public class Texto {

    String Idioma;
    String Titulo;
    int numero_caracteres;
    
    /**
     *
     */
    public Texto(){
        this.Idioma  = null;
	this.Titulo = null;
        this.numero_caracteres = 0;
    }
    
    /**
     *
     * @param Idioma
     * @param Titulo
     * @param n_caracteres
     */
    public Texto(String Idioma,String Titulo,int n_caracteres) {
        this.Idioma = Idioma;
        this.Titulo = Titulo;
        this.numero_caracteres = n_caracteres;
    }

    /**
     *
     * @return
     */
    public String consultar_idioma(){
        return this.Idioma;
    }

    /**
     *
     * @return
     */
    public String consular_titulo() {
        return this.Titulo;
    }

    /**
     *
     * @return
     */
    public int consultar_numero_de_caracteres(){
        return this.numero_caracteres;
    }
    
    
    
    
    
    
    
    
    
}