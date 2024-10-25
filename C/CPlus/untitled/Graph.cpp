#include "graph.h"
#include <iostream>
#include <queue>
#include <limits>

const int INF = std::numeric_limits<int>::max();

Graph::Graph(const std::vector<std::vector<Edge>>& graph) : adjacencyList(graph) {}

void Graph::dijkstra(int start) {
    int n = adjacencyList.size();
    std::vector<int> dist(n, INF);
    std::vector<bool> visited(n, false);

    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;

    dist[start] = 0;
    pq.push({0, start});

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        if (visited[u])
            continue;

        visited[u] = true;

        for (const Edge& e : adjacencyList[u]) {
            int v = e.to;
            int weight = e.weight;
            if (!visited[v] && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.push({dist[v], v});
            }
        }
    }

    std::cout << "Shortest distances from node " << start << ":" << std::endl;
    for (int i = 0; i < n; ++i) {
        std::cout << "Node " << i << ": " << dist[i] << std::endl;
    }
}