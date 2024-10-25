import java.util.*;

public class GraphAlgortihms {

    public static <V> void dfsHelp(Graph<V> graph, V vertex, boolean[] isVisited, List<V> visited) {
        int indexV = graph.getIndex(vertex);
        isVisited[indexV] = true;
        visited.add(vertex);
        List<Integer> neighborsIndex = graph.getNeighborsIndex(vertex);
        for (int neighborIndex : neighborsIndex) {
            if (!isVisited[neighborIndex]) {
                dfsHelp(graph, graph.getVertex(neighborIndex), isVisited, visited);
            }
        }
    }
    /**
     * Returnerer en liste af grafens knuder fundet ved et dybdeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        //Opgave 2
        List<V> visited = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.getVertices().size()];
        dfsHelp(graph, v, isVisited, visited);
        return visited;
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        // TODO Opgave 3
        return null;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: Grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        // TODO Opgave 4
        return false;
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        // TODO Opgave 5
        return false;
    }
}