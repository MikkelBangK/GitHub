import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EdgeListGraphTest {

    @Test
    void test_getMaxVertex() {

        // Arrange
        Graph<Integer> graph = new EdgeListGraph();
        graph.addVertex(15);  // 0
        graph.addVertex(38);  // 1
        graph.addVertex(6);   //2
        graph.addVertex(123);  // 3
        graph.addVertex(66);  // 4

        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 4, 8);
        graph.addEdge(4, 3, 76);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 23);
        graph.addEdge(0, 4, 90);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 3, 55);

        // Act
        int expected = 123;
        int actual = graph.getMaxVertex();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void test_remove_vertex() {

        // Arrange
        Graph<Integer> graph = new EdgeListGraph();
        graph.addVertex(15);  // 0
        graph.addVertex(38);  // 1
        graph.addVertex(6);   //2
        graph.addVertex(123);  // 3
        graph.addVertex(66);  // 4

        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 4, 8);
        graph.addEdge(4, 3, 76);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 23);
        graph.addEdge(0, 4, 90);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 3, 55);

        // Act & Assert
        boolean removed = graph.remove(38);
        List<Integer> vertices = graph.getVertices();
        List<Edge> edges = graph.getEdges();
        assertTrue(removed);
        assertFalse(vertices.contains(38), "Vertex 38 still exists");
        for (Edge edge : edges) {
            assertFalse(edge.v == 1 || edge.u == 1, "Edge(s) for removed vertex 38 (index 1) still exists");
        }
        assertFalse(graph.remove(38));
    }

    @Test
    void test_remove_edge() {

        // Arrange
        Graph<Integer> graph = new EdgeListGraph();
        graph.addVertex(15);  // 0
        graph.addVertex(38);  // 1
        graph.addVertex(6);   //2
        graph.addVertex(123);  // 3
        graph.addVertex(66);  // 4

        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 4, 8);
        graph.addEdge(4, 3, 76);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 23);
        graph.addEdge(0, 4, 90);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 3, 55);

        // Act & Assert
        boolean removed = graph.remove(0, 1);
        List<Edge> edges = graph.getEdges();
        //assertTrue(removed);
        for (Edge edge : edges) {
            assertFalse(edge.u == 0 && edge.v == 1, "Edge (0,1) still exists");
            assertFalse(edge.u == 1 && edge.v == 0, "Edge (1,0) still exists");
        }
        assertFalse(graph.remove(0, 1));
        assertFalse(graph.remove(1, 0));
    }
}