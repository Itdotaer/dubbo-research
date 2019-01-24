package com.itdotaer.basiclearn.consistenthash;

/**
 * Server
 *
 * @author jt_hu
 * @date 2019-01-16
 */
public class Server {

    private String serverName;
    private Long hash;

    public Server(String serverName, Long hash) {
        this.setServerName(serverName);
        this.setHash(hash);
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Long getHash() {
        return hash;
    }

    public void setHash(Long hash) {
        this.hash = hash;
    }
}
