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
    public int g(Node a, int pos) {
        int cost = 0;
        for(int i=0; i < pos;++i) {
            for(int j=0; j < pos; ++j) {
                cost += estadisticas[a.teclasAssignadas[i]][a.teclasAssignadas[j]]*distancia[i][j];
                cost += estadisticas[a.teclasAssignadas[j]][a.teclasAssignadas[i]]*distancia[j][i];   
            }
            
        }
        return cost;
    }
    public int[][] termino2(Node a, int pos) {
        int [][] matriz2 = new int [a.teclasPendientes.size()][a.teclasPendientes.size()];
        for(int i =0; i < a.teclasPendientes.size();++i) {
            for(int j = 0; j < a.teclasPendientes.size();++j){
                   for(int k = 0; k < pos; ++k) {
                       matriz2[i][j] += estadisticas[a.teclasAssignadas[k]][a.teclasPendientes.get(i)] * distancia[k][j+pos+1];
                   } 
            }
        }
        return matriz2;
    }
    
    public int[][] termino3 (Node a, int pos) {
        int [][] matriz3 = new int[a.teclasPendientes.size()][a.teclasPendientes.size()];
        return matriz3;
        
    }
    
    
    
    
    public int h(Node a, int pos) {
        int [][] matriz2 = termino2 (a,pos);
        int [][] matriz3 = termino3 (a,pos);
        int [][] matriz = new int[matriz2[0].length][matriz2[0].length];
        
        
        for(int i = 0; i < matriz2[0].length; ++i) {
            for(int j = 0; j < matriz2[0].length;++j) {
                matriz[i][j] = matriz2[i][j]+ matriz3[i][j];
            }
        }
        
        
        
        
        return 0;
    }
    
    
    public int calcularCoste(Node a, int pos) {
        return g(a,pos)+ h(a,pos);   
    }
}
