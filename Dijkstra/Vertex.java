package Dijkstra;

import java.util.ArrayList;

public class Vertex {

    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<>();
    }

    public String getData() {
        return this.data;
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    public void addEdge(Vertex v, int weight) {
        this.edges.add(new Edge(this, v, weight));
    }

    public void removeEdge(Vertex v) {
        //I don't love this solution, we don't teach removeIf
        this.edges.removeIf(e -> e.getEnd().equals(v));
    }

    public void print() {
        StringBuilder message = new StringBuilder();

        if(this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if(i == 0) {
                message.append(this.edges.get(i).getStart().data).append(" -->  ");
            }
            message.append(this.edges.get(i).getEnd().data).append(" (").append(this.edges.get(i).getWeight()).append(")");
            if (i != this.edges.size() - 1) {
                message.append(", ");
            }
        }
        System.out.println(message);
    }
}
