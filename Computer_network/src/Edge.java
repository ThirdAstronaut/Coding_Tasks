public class Edge {

    private Vertex destination;
    private Vertex source;
    private long ping;

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public long getPing() {
        return ping;
    }

    public void setPing(long ping) {
        this.ping = ping;
    }

    @Override
    public String toString() {
        return "Ping value : " + ping + " from " +destination.toString() + ", to " + source.toString();
    }
}
