package no_wire.no_wire.ping.model;

public class Ping {

    private String ipAddress;
    private boolean reachable;
    private String output;

    public Ping(String ipAddress, boolean reachable, String output) {
        this.ipAddress = ipAddress;
        this.reachable = reachable;
        this.output = output;
    }

    public Ping() {}

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean isReachable() {
        return reachable;
    }

    public String getOutput() {
        return output;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
