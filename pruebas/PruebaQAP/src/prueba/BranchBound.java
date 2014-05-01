

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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
    double  mejorCost;
    
    public BranchBound() {
        mejorCost = Integer.MAX_VALUE;
        mejorSolucion.cost = 0;
        mejorSolucion.teclasAssignadas = new ArrayList<Integer> ();
        mejorSolucion.teclasPendientes = new ArrayList<Integer> ();
        nodes = new PriorityQueue<Node> (1,new NodeComparador());
        nodes.add(mejorSolucion);
    }
    
    public BranchBound(int[][] estadistica, int[][] distancia) {
        this.distancia = distancia;
        this.estadistica = estadistica;
        mejorCost = Integer.MAX_VALUE;
        mejorSolucion = new Node ();
        mejorSolucion.cost = 0;
        mejorSolucion.teclasAssignadas = new ArrayList<> ();
        mejorSolucion.teclasPendientes = new ArrayList<> (estadistica[0].length);
        System.out.println ("Mida teclas Pendientes"+mejorSolucion.teclasPendientes.size());
        anadirPendientes();
        nodes = new PriorityQueue<> (1,new NodeComparador());
        nodes.add(mejorSolucion);
        if(nodes.isEmpty()) System.out.println ("Esta vacio");

        solve(0);
        for (int i = 0; i < mejorSolucion.teclasAssignadas.size(); i++) {
          System.out.println ("La mejor solucion es "+ i +"  "+mejorSolucion.teclasAssignadas.get(i));
        }
        
    }
    
    public void anadirPendientes(){
        System.out.println ("Entro");
        for(int i=0; i < estadistica.length; ++i) {
            mejorSolucion.teclasPendientes.add(i);
            
        }
    }
    public void calcularCost(Node b, int n) {
        for(int i=0; i < n;++i) {
            b.cost += estadistica[b.teclasAssignadas.get(i)][b.teclasAssignadas.get(n)]*distancia[i][n];
        }
    }
    public void assignarTecla(Node b, int n) {
       if(n < b.teclasPendientes.size()) {
           int x = b.teclasPendientes.get(n); 
           System.out.println ("Valor de x: "+ x);
           b.teclasPendientes.remove(n);
           b.teclasAssignadas.add(x);
       }
    }
    
    public void solve(int n) {
        Node a = nodes.poll();
        if(a == null) System.out.println ("Es nullo ");
        else {
            System.out.println ("No es nullo ");
            int x = a.teclasAssignadas.size();
            int c = estadistica.length;
            if(x == c) {
                for (int i = 0; i < a.teclasAssignadas.size(); i++) {
                    System.out.print(a.teclasAssignadas.get(i) + " ");
                }
                System.out.println("");
                if(esMejor(a.cost)) {
                    mejorSolucion = a;
                }          
            }
            else {
                System.out.println ("Else");
                int i = 0;
                int mida = a.teclasPendientes.size();
                while(mida > 0) {
                    System.out.println ("Dentro del while ");
                    System.out.println ("Creo un node ");
                    Node b = a;s
                    System.out.println ("Asigno tecla ");
                    assignarTecla(b,i);
                    System.out.println ("Calculo coste");
                    calcularCost(b,n);
                    for (int k = 0; k < b.teclasAssignadas.size(); k++) {
                         System.out.print(b.teclasAssignadas.get(k) + " ");
                    }
                    System.out.println("");
                    if(b.cost < mejorCost) {
                        nodes.add(b);
                        for (int k = 0; k < b.teclasAssignadas.size(); k++) {
                         System.out.print(b.teclasAssignadas.get(k) + " ");
                        }
                        System.out.println("");
                        
                       
                    }
                    ++i;
                    --mida;
                }
               
            }
            System.out.println("La recursiva");
            solve(n+1);
        }
  
    }
    
        
    /**
     *
     * @param b
     * @param n
     */
    
    
    public boolean esSolucion(ArrayList<Integer> a) {
        System.out.println ("Sale");
        return (a.size() == (estadistica.length-1));
        
    }
    public boolean esMejor(double a) {
        System.out.println ("Entro esMejor");
        if(mejorSolucion == null || (a < mejorCost)) return true;
        else return false; 
    }
    


    
}
    
    
    
    
    
    
    

