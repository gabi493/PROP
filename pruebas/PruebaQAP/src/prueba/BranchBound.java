

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 *
 * @author alejandro.del.amo.gonzalez
 */
public class BranchBound {
    private PriorityQueue<Node> nodes;
    private int mida;
    private int[][] estadistica;
    private int[][] distancia;
    public  Node mejorSolucion;
    private Node solucionParcial;
    double  mejorCost;
    
    public BranchBound(int mida) {
        mejorCost = Integer.MAX_VALUE;
        double coste = 0;
        int h[] = new int [mida];
        Vector<Integer> v  = new Vector<Integer> ();
        mejorSolucion = new Node(v,h,coste,0);
        nodes = new PriorityQueue<Node> (1,new NodeComparador());
        nodes.add(mejorSolucion);
    }
    
    public BranchBound(int[][] estadistica, int[][] distancia) {
        this.mida = estadistica.length;
        this.distancia = distancia;
        this.estadistica = estadistica;
        mejorCost = Integer.MAX_VALUE;
        double coste = 0;
        int h[] = new int [mida];
        Vector<Integer> v = new Vector<Integer> (estadistica[0].length);
        mejorSolucion = new Node (v,h,0,0);
        anadirPendientes();
        System.out.println ("Mida teclas Pendientes"+ mejorSolucion.teclasPendientes.size());
        nodes = new PriorityQueue<> (1,new NodeComparador());
        nodes.add(mejorSolucion);
        solve();
        for (int i = 0; i < mejorSolucion.teclasAssignadas.length; i++) {
          System.out.println ("La mejor solucion es "+ i +"  "+mejorSolucion.teclasAssignadas[i]);
        }
        
    }
    
    public void anadirPendientes(){
        System.out.println ("Entro");
        for(int i=0; i < estadistica.length; ++i) {
            mejorSolucion.teclasPendientes.add(i);
            
        }
    }
    public double calcularCost(int [] b, int n,double cost) {
        for(int i=0; i < n;++i) {
            System.out.println("Posicio de la i: "+ i);
            cost += estadistica[b[i]][b[n]]*distancia[i][n];
        }
        return cost;
    }
/*    public void assignarTecla(Node b, int n) {
       if(n < b.teclasPendientes.size()) {
           int x = b.teclasPendientes.get(n); 
           System.out.println ("Valor de x: "+ x);
           b.teclasPendientes.remove(n);
           b.teclasAssignadas.add(x);
       }
    }*/
    
    public void solve()  {
        Node a = nodes.peek();
        while(!nodes.isEmpty()){
            Node b = nodes.poll();
            for (int k = 0; k < b.teclasAssignadas.length; k++) {
                 System.out.print("Teclas asignadas: " + b.teclasAssignadas[k] + " ");
            }
            System.out.println("");
            Vector<Integer> v1 = b.getTeclasPendientes();
            if(esMejor(b.cost)) {
                System.out.println("Mejor coste");
                if(v1.isEmpty()) {
                    System.out.print("Es una solucion: ");
                    for (int i = 0; i < b.teclasAssignadas.length; i++) {
                    System.out.print(b.teclasAssignadas[i] + " ");
                    }
                    System.out.println("");
                    mejorSolucion = b;
                    mejorCost = b.cost;
                }          
                else {
                    System.out.println ("Else");
                    for(int i=0; i < v1.size(); ++i) {
                            int aux [] = b.getTeclasAssginadas();
                            
                            for (int k = 0; k < aux.length; k++) {
                                  System.out.print("Teclas asignadas del padre: " + aux[k] + " ");
                            }
                            System.out.println("Numero de teclas asignadas "+ aux.length);
                            for (int k = 0; k < v1.size(); k++) {
                                  System.out.print("Teclas Pendientes del padre : " + v1.get(k) + " ");
                            }
                            System.out.println("Numero de teclas Pendientes "+ v1.size());
                            
                            System.out.println ("Asigno tecla ");
                            aux[b.etapa] = v1.get(0);
                            System.out.println ("La tecla asignada es: "+ v1.get(i));
                            for (int k = 0; k < aux.length; k++) {
                                  System.out.print("Teclas asignadas: " + aux[k] + " ");
                            }
                            System.out.println("");
                            Vector<Integer> h1 = new Vector<Integer>();
                            for(int m = 0; m < v1.size();++m) h1.add(v1.get(m));
                            h1.remove(0);
                            for (int m = 0; m < h1.size(); m++) {
                                  System.out.print("Teclas pendientes: " + h1.get(m)+ " ");
                            }
                            System.out.println("");
                            System.out.println ("Calculo coste");
                            int pos = mida-v1.size()-1;
                            System.out.println("Posicion de pos: "+ pos);
                            double x = calcularCost(aux,pos,b.cost);
                            System.out.println ("El coste es: "+ x);
                            Node c = new Node(h1,aux,x,b.etapa+1);                          
                            nodes.add(c);
                            
                //            for (int k = 0; k < b.teclasAssignadas.size(); k++) {
               //                  System.out.print(b.teclasAssignadas.get(k) + " ");
               //             }
               //             System.out.println("");
                     
                    }
                }

            }
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
        if(a <= mejorCost) return true;
        else return false; 
    }
    


    
}
    
    
    
    
    
    
    

