package Dijkstra;

import java.util.ArrayList;
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

    public ArrayList<Vertex> getVertices() {
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
        for (Vertex v : this.vertices) {
            if (Objects.equals(v.getData(), value)) {
                return v;
            }
        }
        return new Vertex("");
    }

    public void print() {
        for (Vertex v : this.vertices) {
            v.print();
        }
    }
}