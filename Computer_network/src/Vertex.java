public class Vertex {

    private String ip;
    private long id;

    public Vertex(long id, String ip) {
        this.id = id;
        this.ip = ip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

  /*  @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((Vertex) obj).ip.equals(this.ip) && ((Vertex) obj).id == this.id;
    }
*/
    @Override
    public String toString() {
        return "[id: " + id + ", IP : "+ ip +"]";
    }
}

