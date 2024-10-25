public class Edge implements Comparable<Edge> {
    int startVertexIndex;
    int endVertexIndex;
    int weight;

    public Edge(int startVertexIndex, int endVertexIndex, int weight) {
        this.startVertexIndex = startVertexIndex;
        this.endVertexIndex = endVertexIndex;
        this.weight = weight;
    }

    public boolean equals(Object o) {
        return startVertexIndex == ((Edge) o).startVertexIndex && endVertexIndex == ((Edge) o).endVertexIndex;
    }

    public int getWeight() {
        return weight;
    }


    public String toString() {
        return "(" + startVertexIndex + ", " + endVertexIndex + "): " + weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}