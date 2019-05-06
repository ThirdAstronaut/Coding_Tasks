
import java.util.Objects;

public class Vertex {

    //@Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])")
    private String ip;

    Vertex(String ip) {
        if(validateIp(ip))
        this.ip = ip;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) obj;
        return Objects.equals(ip, vertex.ip);
    }

    @Override
    public String toString() {
        return "[IP : " + ip + "]";
    }

    @Override
    public final int hashCode() {
        return Objects.hash(ip);
    }

    String getIp() {
        return ip;
    }

    void setIp(String ip) {
        if(validateIp(ip))
        this.ip = ip;
    }

    private boolean validateIp(String ip) throws IllegalArgumentException {
        String zeroTo255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

        String IP_REGEXP = zeroTo255 + "\\." + zeroTo255 + "\\."
                + zeroTo255 + "\\." + zeroTo255;
        if(ip == null || !ip.matches(IP_REGEXP))
        throw new IllegalArgumentException();
        return true;
    }

}

