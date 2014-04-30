/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enunciadoteclado;

/**
 *
 * @author alejandro.del.amo.gonzalez
 */
import enunciadoteclado.BranchBound.Node;
import java.util.Comparator;

public class NodeComparador implements Comparator<Node>
{
    @Override
    public int compare(Node x, Node y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        if (x.cost < y.cost)
        {
            return -1;
        }
        if (x.cost > y.cost)
        {
            return 1;
        }
        return 0;
    }
}