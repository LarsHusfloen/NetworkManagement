package dijkstra;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueueObject that)) return false;
        return priority == that.priority && vertex.equals(that.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex, priority);
    }
}
