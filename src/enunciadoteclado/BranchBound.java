/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enunciadoteclado;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 *
 * @author alejandro.del.amo.gonzalez
 */
public class BranchBound {
    private PriorityQueue<Node> nodes;
    private int[][] estadistica;
    private int[][] distancia;
    private Node mejorSolucion;
    private Node solucionParcial;
    
    
    
    public BranchBound() {
        mejorSolucion.cost = Integer.MAX_VALUE;
        mejorSolucion.teclasAssignadas = new ArrayList<Integer> ();
        mejorSolucion.teclasPendientes = new ArrayList<Integer> ();
        nodes = new PriorityQueue<Node> ();
    }
    
    public BranchBound(int[][] estadistica, int[][] distancia) {
        mejorSolucion.cost = Integer.MAX_VALUE;
        mejorSolucion.teclasAssignadas = new ArrayList<Integer> ();
        mejorSolucion.teclasPendientes = new ArrayList<Integer> ();
        nodes = new PriorityQueue<Node> ();
        this.distancia = distancia;
    }
    
    class Node {
         ArrayList<Integer> teclasPendientes;
         ArrayList<Integer> teclasAssignadas;
         int cost;
    }
    
    
    
    public ArrayList<Integer> solve(int n) {
        
        if(esSolucion()) {
            if(esMejor()) {
                mejorSolucion = solucionParcial;
            }          
        }
        else {
            
            
        }
        
        
        
        Comparator<Node> comparator = new NodeComparador();
        nodes = new PriorityQueue<Node>(0,comparator);
        for(int i=0; i < estadistica.length; ++i) {
            Node a = new Node();
            a.añadirAssignacion(i);
            for(int j = 0; j < estadistica.length; ++j) {
                if(i != j) a.añadirPendientes(j);
            }
            nodes.add(a);
        }
        

        return mejorSolucion.teclasAssignadas;
        
    }
    public void calcularCoste(Node a) {
        
        
    }
    public boolean esSolucion() {
        return (solucionParcial.teclasAssignadas.size() == (estadistica.length-1));
    }
    public boolean esMejor() {
        if(mejorSolucion == null || (solucionParcial.cost < mejorSolucion.cost)) return true;
        else return false; 
    }
    


    
}
    
    
    
    
    
    
    

