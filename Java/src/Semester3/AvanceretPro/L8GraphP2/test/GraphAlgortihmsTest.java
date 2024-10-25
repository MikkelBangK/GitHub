import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GraphAlgortihmsTest {

    @Test
    void test_dfs_returns_correct_list() {

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
        List<Integer> dfsExpected = Arrays.asList(6, 15, 38, 66, 123);
        List<Integer> dfsActual = GraphAlgortihms.dfs(graph, 123);

        // Assert
        if (dfsActual != null) {
            Collections.sort(dfsActual);
            for (int i = 0; i < dfsExpected.size() - 1; i++) {
                assertEquals(dfsExpected.get(i), dfsActual.get(i));
            }
        } else fail();
    }

    @Test
    void test_bfs_returns_correct_list() {
        // TODO Opgave 3
        fail();
    }

    @Test
    void test_connected() {
        // TODO Opgave 4
        fail();
    }

    @Test
    void test_isPath() {
        // TODO Opgave 5
        fail();
    }
}