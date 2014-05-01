package prueba;





import prueba.ctrlPersistencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author alex
 */
public class driverBranchBound {
    
    public static void main (String[] args) {
        String nombreclase = "BrancBound";
        System.out.print("Driver" + nombreclase + ".");
        ctrlPersistencia cp = new  ctrlPersistencia();
        cp.leerJuegoDePrueba("chr12a");
        BranchBound bb = new BranchBound(cp.getAfin(),cp.getDist());
        for (int i = 0; i < bb.mejorSolucion.teclasAssignadas.size(); i++) {
            System.out.println (bb.mejorSolucion.teclasAssignadas.get(i) + " ");
        }
    }
}
