import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsTest {

    @Test
    void test_shortestPathWeights() {

        // Arrange
        Graph<Integer> graph = new AdjacencyEdgeListGraph();
        graph.addVertex(15);  // 0
        graph.addVertex(38);  // 1
        graph.addVertex(6);   // 2
        graph.addVertex(123); // 3
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
        int[] weightsExpected = new int[]{27, 17, 7, 0, 15};
        int[] weightsActual = GraphAlgorithms.shortestPathWeights(graph, 123);

        // Assert
        for (int i = 0; i < weightsExpected.length; i++) {
            assertEquals(weightsExpected[i], weightsActual[i]);
        }
    }
}