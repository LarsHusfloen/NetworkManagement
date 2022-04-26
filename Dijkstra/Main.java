package Dijkstra;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graph network = new Graph(true, false);
        Vertex a = network.addVertex("A");
        Vertex b = network.addVertex("B");
        Vertex c = network.addVertex("C");
        Vertex d = network.addVertex("D");
        Vertex e = network.addVertex("E");
        Vertex f = network.addVertex("F");

        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);

        network.addEdge(a, b, 10);
        network.addEdge(a, c, 5);
        network.addEdge(a, d, 9999);
        network.addEdge(a, e, 3);
        network.addEdge(a, f, 12);

        network.addEdge(b, c, 17);
        network.addEdge(b, d, 9);
        network.addEdge(b, e, 17);
        network.addEdge(b, f, 12);

        network.addEdge(c, d, 35);
        network.addEdge(c, e, 3);
        network.addEdge(c, f, 12);

        network.addEdge(d, e, 9999);
        network.addEdge(d, f, 12);

        network.addEdge(e, f, 12);

        for (Vertex startingVertex : vertices) {
            System.out.println("\t\tVertex " + startingVertex.getData() + ":");
            for (Vertex endVertex : network.getVertices()) {
                Dijkstra.shortestPathBetween(network, startingVertex, endVertex);
                System.out.println(" ");
            }
            System.out.println("Summary for vertex " + startingVertex.getData() + ":\n");
            Dijkstra.dijkstraResultPrinter(Dijkstra.dijkstra(network, startingVertex));
            System.out.println("-------------------------------");
        }
    }
}