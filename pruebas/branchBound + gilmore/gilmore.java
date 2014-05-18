
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class gilmore {
    private int[][] estadisticas;
    private int[][] distancia;
    
    public gilmore(int [][] estadistica, int [][] distancia){
        this.estadisticas = estadistica;
        this.distancia = distancia;
    }
    public double g(int[] asignado, int pos) {
        double cost = 0;
        for(int i=0; i < pos;++i) {
            for(int j=0; j < pos; ++j) {
                cost += estadisticas[asignado[i]][asignado[j]]*distancia[i][j];
                cost += estadisticas[asignado[j]][asignado[i]]*distancia[j][i];   
            }
            
        }
        return cost;
    }
    public int[][] termino2(Vector<Integer> pendiente, int[] asignado, int pos) {
        int [][] matriz2 = new int [pendiente.size()][pendiente.size()];
        for(int i =0; i < pendiente.size();++i) {
            for(int j = 0; j < pendiente.size();++j){
                   for(int k = 0; k < pos; ++k) {
                       matriz2[i][j] += estadisticas[asignado[k]][pendiente.get(i)] * distancia[k][j+pos+1];
                   } 
            }
        }
        return matriz2;
    }
    
    public int[][] termino3 (Vector<Integer> pendiente, int[] asignado, int pos) {
        int [][] matriz3 = new int[pendiente.size()][pendiente.size()];
        return matriz3;
        
    }
    
    
    
    
    public double h(Vector<Integer> pendiente, int[] asignado, int pos) {
        int [][] matriz2 = termino2 (pendiente,asignado,pos);
        int [][] matriz3 = termino3 (pendiente,asignado,pos);
        int [][] matriz = new int[matriz2[0].length][matriz2[0].length];
        
        
        for(int i = 0; i < matriz2[0].length; ++i) {
            for(int j = 0; j < matriz2[0].length;++j) {
                matriz[i][j] = matriz2[i][j]+ matriz3[i][j];
            }
        }
        
        
        
        
        return 0;
    }
    
    
    public double calcularCoste(Vector<Integer> pendiente, int[] asignado, int pos) {
        return g(asignado,pos)+ h(pendiente,asignado,pos);   
    }
}
