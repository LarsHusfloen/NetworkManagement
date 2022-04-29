package Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private final String data;
    private final ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<>();
    }

    public String getData() {
        return this.data;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(Vertex v, int weight) {
        this.edges.add(new Edge(this, v, weight));
    }

    public void removeEdge(Vertex v) {
        this.edges.removeIf(e -> e.getEnd().equals(v));
    }

    public void print() {
        if (this.edges.isEmpty()) {
            System.out.println(this.data + " -->");
            return;
        }
        System.out.println(stringBuilder());
    }

    private String stringBuilder(){
        StringBuilder message = new StringBuilder();

        message.append(this.edges.get(0).getStart().data).append(" -->  ");
        this.edges.forEach(edge -> message.append(edge.getEnd().data).append(" (").append(edge.getWeight()).append(")"));
        message.append(", ");

        return message.toString();
    }
}
