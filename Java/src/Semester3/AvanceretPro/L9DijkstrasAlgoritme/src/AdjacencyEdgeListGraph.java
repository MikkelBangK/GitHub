import java.util.ArrayList;
import java.util.List;

public class AdjacencyEdgeListGraph<V> implements Graph<V> {
    protected List<V> vertices;
    protected List<List<Edge>> neighbors;

    /**
     * Construct an empty graph
     */
    public AdjacencyEdgeListGraph() {
        this.vertices = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }

    @Override
    /** Return the number of vertices in the graph */
    public int getSize() {
        return vertices.size();
    }

    @Override
    public int getNumEdges() {
        int count = 0;
        for (List<Edge> list : neighbors) {
            count = count + list.size();
        }
        return count / 2;
    }

    @Override
    /** Return the vertices in the graph */
    public List<V> getVertices() {
        return vertices;
    }

    @Override
    /** Return the edges in the graph */
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (V v : vertices) {
            edges.addAll(getIncidentEdges(v));
        }
        return edges;
    }

    @Override
    /** Return the object for the specified vertex */
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    /** Return the index for the specified vertex object */
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    @Override
    /** Return the neighbors of the specified vertex */
    public List<Integer> getNeighborsIndex(V v) {
        int index = getIndex(v);
        List<Integer> result = new ArrayList<>();
        for (Edge e : neighbors.get(index)) {
            if (e.startVertexIndex == index) {
                result.add(e.endVertexIndex);
            } else {
                result.add(e.startVertexIndex);
            }
        }
        return result;
    }

    @Override
    public List<Edge> getIncidentEdges(V v) {
        int index = getIndex(v);
        List<Edge> result = neighbors.get(index);
        return result;
    }

    @Override
    /** Return the neighbors of the specified vertex */
    public List<V> getNeighbors(V v) {
        int index = getIndex(v);
        List<V> result = new ArrayList<>();
        for (Edge e : neighbors.get(index)) {
            if (e.startVertexIndex == index) {
                result.add(vertices.get(e.endVertexIndex));
            } else {
                result.add(vertices.get(e.startVertexIndex));
            }
        }
        return result;
    }

    @Override
    /** Return the degree for a specified vertex */
    public int getDegree(V v) {
        return neighbors.get(getIndex(v)).size();
    }

    @Override
    /** Print the edges */
    public void printEdges() {
        for (int u = 0; u < neighbors.size(); u++) {
            System.out.print(getVertex(u) + " (" + u + "): ");
            for (Edge e : neighbors.get(u)) {
                System.out.print("(" + getVertex(e.startVertexIndex) + ", " +
                        getVertex(e.endVertexIndex) + ") ");
            }
            System.out.println();
        }
    }

    @Override
    /** Clear the graph */
    public void clear() {
        vertices.clear();
        neighbors.clear();
    }

    @Override
    /** Add a vertex to the graph */
    public boolean addVertex(V vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            neighbors.add(new ArrayList<Edge>());
            return true;
        } else {
            return false;
        }
    }

    @Override
    /** Add an edge to the graph */
    public boolean addEdge(int u, int v) {
        return addEdge(new Edge(u, v, 0)) && addEdge(new Edge(v, u, 0));
    }

    @Override
    /** Add an edge to the graph */
    public boolean addEdge(int u, int v, int e) {
        return addEdge(new Edge(u, v, e)) && addEdge(new Edge(v, u, e));
    }

    private boolean addEdge(Edge e) {
        if (e.startVertexIndex < 0 || e.startVertexIndex > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.startVertexIndex);
        if (e.endVertexIndex < 0 || e.endVertexIndex > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.endVertexIndex);
        if (!neighbors.get(e.startVertexIndex).contains(e)) {
            neighbors.get(e.startVertexIndex).add(e);
            return true;
        } else {
            return false;
        }
    }

    @Override
    /** Remove vertex v and return true if successful */
    public boolean remove(V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    /** Remove edge (u, v) and return true if successful */
    public boolean remove(int u, int v) {
        throw new UnsupportedOperationException();
    }
}

