/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author alejandro.del.amo.gonzalez
 */
public class Node {
    private ArrayList<Integer> teclasPendientes;
    private ArrayList<Integer> teclasAssignadas;
    private int cost;
    
    public Node(){
        teclasPendientes = new ArrayList<Integer> ();
        teclasAssignadas = new ArrayList<Integer>();
        cost = 0;
    }
    public Node(int nPendientes,int nAssignadas) {
        teclasPendientes = new ArrayList<Integer>(nPendientes);
        teclasPendientes = new ArrayList<Integer>(nAssignadas);
        cost = 0;
    }
    public Node (ArrayList<Integer> teclasPendientes,ArrayList<Integer>teclasAssignadas,int cost) {
        this.teclasPendientes = teclasPendientes;
        this.teclasAssignadas = teclasAssignadas;
        this.cost = cost;
                        
    }
    public Node(Node a) {
        this.teclasPendientes = a.teclasPendientes;
        this.teclasAssignadas = a.teclasAssignadas;
        this.cost = a.cost;
    }
    public void añadirAssignacion(int i) {
        teclasAssignadas.add(i);
    }
    
    public void añadirPendientes(int i) {
        teclasPendientes.add(i);
    }
    
    public boolean quedanPendientes() {
        return (!teclasPendientes.isEmpty());
    }
    public void modificarCost (int cost){
        this.cost = cost;
    }
    
    public int consultarCost() {
        return cost;
    }
    
    
    
}
