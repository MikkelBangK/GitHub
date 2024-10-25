import java.util.ArrayList;
import java.util.List;

public class GraphAlgorithms {
    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static <V> int[] shortestPathWeights(Graph<V> graph, V v) {

        // Opret en liste for udforskede noder (nodernes indeks)
        List<Integer> exploredVertexIndexes = new ArrayList<>();

        // Opret et array for mindst fundne "rejseomkostning" fra kildenode til nodeindeks (sum af kanters vægt)
        int[] cost = new int[graph.getSize()];


        // TODO: Sæt mindste omkostning til 0 for kildenoden selv og "uendeligt" for de øvrige noder
        int sourceVertexIndex = graph.getIndex(v);
        for (int i = 0; i < graph.getSize(); i++) {
            if (i == sourceVertexIndex) {
                cost[i] = 0;
            } else {
                cost[i] = Integer.MAX_VALUE;
            }
        }
        // TODO: Gentag nedenstående så længe der er uudforskede noder...
         while (exploredVertexIndexes.size() < graph.getSize()){
             int minCostIndex =  -1;
             int minCostValue = Integer.MAX_VALUE;
             for (int i = 0; i <cost.length ; i++) {
                 if (cost[i] < minCostValue && !exploredVertexIndexes.contains(i)){
                     minCostIndex = i;
                     minCostValue = cost[i];
                 }
             }
             List<Edge> incidentEdges = graph.getIncidentEdges(graph.getVertex(minCostIndex));


         }
        // TODO: Find den node, der foreløbigt har laveste rejseomkostning blandt de uudforskede noder
        // TODO: Udforsk rejseomkostningen for den fundne nodes uudforskede naboer
        // TODO: Opdater array for mindste omkostning (cost), hvor mindre omkostning findes
        // TODO: Tilføj den udforske node til listen (exploredVertexIndexes) og gentag udforskningen
        for (int count = 0; count < cost.length; count++){
            int u = mindistance(cost ,exploredVertexIndexes);
            exploredVertexIndexes.add(u);

            for (int w = 0; w < cost.length; w++){
                if (cost[w] && )
            }
        }


        return cost;
    }
}