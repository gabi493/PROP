
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
public class Node {
    ArrayList<Integer> teclasPendientes;
    ArrayList<Integer> teclasAssignadas;
    double cost;
    
    public Node() {
        teclasPendientes = new ArrayList<Integer> ();
        teclasAssignadas = new ArrayList<Integer> ();
        cost = 0;
    }
    public void modificarCost(int n) {
        cost = n;
    }
}
