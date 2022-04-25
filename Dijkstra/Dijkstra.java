package Dijkstra;
import java.util.*;

public class Dijkstra {
    public static Dictionary[] dijkstra (Graph g, Vertex startingVertex){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Vertex v: g.getVertices()) {
            if(v != startingVertex){
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        while(queue.size() != 0){
            Vertex current = queue.poll().vertex;
            for (Edge e: current.getEdges()) {
                Integer alternate = distances.get(current.getData()) + e.getWeight();
                String neighborValue = e.getEnd().getData();
                if (alternate < distances.get(neighborValue)){
                    distances.put(neighborValue, alternate);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex){
        Dictionary[] dijkstraDicts = dijkstra(g, startingVertex);
        Dictionary distances = dijkstraDicts[0];
        Dictionary previous = dijkstraDicts[1];
        Integer distance = (Integer) distances.get(targetVertex.getData());

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;
        while(!Objects.equals(v.getData(), "Null")){
            path.add(0,v);
            v = (Vertex) previous.get(v.getData());
        }
        StringBuilder shortestPath = new StringBuilder();
        for (Vertex pathVertex: path){
            shortestPath.append(pathVertex.getData());
            shortestPath.append("-");
        }
        shortestPath.setLength(shortestPath.length() - 1);
        System.out.println("Shortest Path between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println("Path: " + "[" + shortestPath + "] " + "Distance: " + distance);
    }

    public static void dijkstraResultPrinter(Dictionary[] d){
        /* Shows the shortest distance between the input vertex and all other vertices */
        System.out.println("Distances:");
        for (Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        /* Shows the previous visited vertex in the shortest path to all other vertices */
        System.out.println("\nPrevious:");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
        System.out.println(" ");
    }
}

