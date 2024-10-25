#include "graph.h" // Inkluderer headerfilen for Graph-klassen

using namespace std;

int main() {
    // Opret en graf vha. en adjacency liste
    vector<vector<Edge>> graph = {
            {{1, 6}, {3, 1}},     // Node 0
            {{0, 6}, {2, 1},{3, 2}, {4, 6}},  // Node 1
            {{1, 1}, {4, 5}},     // Node 2
            {{0, 1}, {1, 2}, {4, 1}},     // Node 3
            {{2, 5}, {3, 1}}      // Node 4
    };

    // Opret en instans af Graph-klassen med den angivne graf
    Graph myGraph(graph);

    // Kør Dijkstras algoritme med startknude 0
    myGraph.dijkstra(0);

    return 0;
}