package Dijkstra;

public class QueueObject implements Comparable<QueueObject> {
    public final Vertex vertex;
    public final int priority;

    public QueueObject(Vertex v, int p) {
        this.vertex = v;
        this.priority = p;
    }

    @Override
    public int compareTo(QueueObject o) {
        return Integer.compare(this.priority, o.priority);
    }
}
