import org.example.DirectedGraph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectedGraphTest {
    @Test
    public void test3() {
        int Vertexnum = 7;
        int[][] Edge = {{0, 1}, {1, 3}, {2, 3}, {2, 5}, {3, 1}, {3, 4}, {4, 2}, {4, 5}, {6, 1}};
        DirectedGraph graph = new DirectedGraph(Vertexnum, Edge);
        assertEquals("(1,3)(2,3)(3,1)(3,4)(4,2)", DirectedGraph.FindCycle(graph).toString());
    }
}
