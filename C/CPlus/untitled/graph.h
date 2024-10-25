
#ifndef graph_h
#define graph_h

#include <vector>

struct Edge {
    int to;
    int weight;
    Edge(int t, int w) : to(t), weight(w) {}
};

class Graph {
public:
    Graph(const std::vector<std::vector<Edge>>& graph);
    void dijkstra(int start);
private:
    std::vector<std::vector<Edge>> adjacencyList;
};

#endif  //graph_h