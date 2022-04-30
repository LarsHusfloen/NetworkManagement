package dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Graph {
    private final ArrayList<Vertex> vertices;
    private final boolean isDirected;
    private final boolean isWeighted;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public List<Vertex> getVertices() {
        return this.vertices;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(Vertex v) {
        this.vertices.remove(v);
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        if (!isWeighted) {
            weight = 0;
        }
        v1.addEdge(v2, weight);
        if (!this.isDirected) {
            v2.addEdge(v1, weight);
        }
    }

    public void removeEdge(Vertex v1, Vertex v2) {
        v1.removeEdge(v2);
        if (!this.isDirected) {
            v2.removeEdge(v1);
        }
    }

    public Vertex getVertexByValue(String value) {
        return vertices.stream().filter(v -> Objects.equals(v.getData(), value)).findFirst().orElse(new Vertex(""));
    }

    public void print() {
        this.vertices.forEach(Vertex::print);
    }
}
