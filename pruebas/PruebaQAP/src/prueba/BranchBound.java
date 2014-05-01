package prueba;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import prueba.NodeComparador;
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
    public  Node mejorSolucion;
    private Node solucionParcial;
    int mejorCost;
    
    class Node {
         ArrayList<Integer> teclasPendientes;
         ArrayList<Integer> teclasAssignadas;
         int cost;
    }
    
    
    
    public BranchBound() {
        mejorCost = Integer.MAX_VALUE;
        mejorSolucion.cost = 0;
        mejorSolucion.teclasAssignadas = new ArrayList<Integer> ();
        mejorSolucion.teclasPendientes = new ArrayList<Integer> ();
        nodes = new PriorityQueue<Node> (1,new NodeComparador());
        nodes.add(mejorSolucion);
    }
    
    public BranchBound(int[][] estadistica, int[][] distancia) {
        mejorCost = Integer.MAX_VALUE;
        mejorSolucion.cost = 0;
        mejorSolucion.teclasAssignadas = new ArrayList<Integer> ();
        mejorSolucion.teclasPendientes = new ArrayList<Integer> (estadistica[0].length);
        anadirPendientes();
        nodes = new PriorityQueue<Node> (1,new NodeComparador());
        nodes.add(mejorSolucion);
        this.distancia = distancia;
        this.estadistica = estadistica;
        solve(0);
    }
    
    public void anadirPendientes(){
        for(int i=0; i < mejorSolucion.teclasPendientes.size(); ++i) {
            mejorSolucion.teclasPendientes.add(i);
        }
    }
    public void calcularCost(Node b, int n) {
        for(int i=0; i < n;++i) {
            b.cost += estadistica[b.teclasAssignadas.get(i)][b.teclasAssignadas.get(n)]*distancia[i][n];
        }
    }
    public void assignarTecla(Node b, int n) {
       int x = b.teclasPendientes.get(n);
       b.teclasPendientes.remove(n);
       b.teclasAssignadas.add(x);
    }
    
    public void solve(int n) {
        Node a = nodes.remove();
        if(esSolucion(a.teclasAssignadas)) {
            if(esMejor(a.cost)) {
                mejorSolucion = a;
            }          
        }
        else {
            int i = 0;
            int mida = a.teclasPendientes.size();
            while(mida > 0) {
                Node b = new Node();
                b.teclasAssignadas = a.teclasAssignadas;
                b.teclasPendientes = a.teclasPendientes;
                b.cost = a.cost;
                assignarTecla(b,i);
                calcularCost(b,n);
                if(b.cost < mejorCost) {
                    nodes.add(b);
                }
                ++i;
                --mida;
            }
            solve(n+1);
        }
  
    }
    
        
    /**
     *
     * @param b
     * @param n
     */
    
    
    public boolean esSolucion(ArrayList<Integer> a) {
        return (a.size() == (estadistica.length-1));
    }
    public boolean esMejor(Integer a) {
        if(mejorSolucion == null || (a < mejorCost)) return true;
        else return false; 
    }
    


    
}
    
    
    
    
    
    
    

