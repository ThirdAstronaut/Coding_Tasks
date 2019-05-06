import java.util.Objects;

public class Edge {

    private Vertex destination;
    private Vertex source;
    private long ping;

    Edge(Vertex source, Vertex destination, long ping) {
        this.destination = destination;
        this.source = source;
        this.ping = ping;
    }

    Vertex getDestination() {
        return destination;
    }

    void setDestination(Vertex destination) {
        this.destination = destination;
    }

    Vertex getSource() {
        return source;
    }

    void setSource(Vertex source) {
        this.source = source;
    }

    long getPing() {
        return ping;
    }

    void setPing(long ping) {
        this.ping = ping;
    }

    @Override
    public String toString() {
        return "Ping value : " + ping + " from " + destination.toString() + ", to " + source.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) obj;
        return ping == edge.ping && Objects.equals(source, edge.source) && Objects.equals(destination, edge.destination);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(destination, source, ping);
    }
}
