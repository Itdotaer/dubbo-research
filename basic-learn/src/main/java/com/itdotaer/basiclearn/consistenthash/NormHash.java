package com.itdotaer.basiclearn.consistenthash;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * NormHash
 *
 * @author jt_hu
 * @date 2019-01-16
 */
public class NormHash {

    private static int MAX_SIZE = 8;
    private static List<Server> serverList = new ArrayList<>();

    public static void addServer(String serverName) throws Exception {
        if (serverList.size() >= MAX_SIZE) {
            throw new Exception("server is out of max_size");
        }

        long hash = getHash(serverName);
        serverList.add(new Server(serverName, hash));
    }

    public static void deleteServer(String serverName) {
        if (!serverList.isEmpty()) {
            long hash = getHash(serverName);
            serverList = serverList.stream().filter(t -> t.getHash().equals(hash))
                    .collect(Collectors.toList());
        }
    }

    public static long getHash(String serverName) {
        int hashCode = serverName.hashCode();

        if (hashCode < 0) {
            hashCode = -hashCode;
        }

        return Long.valueOf(hashCode % MAX_SIZE);
    }

    public static String getServer(String key) {
        long hash = getHash(key);

        Optional<Server> found = serverList.stream().filter(t -> t.getHash().equals(hash)).findFirst();

        if (found.isPresent()) {
            return found.get().getServerName();
        }

        return serverList.isEmpty() ? "" : serverList.get(0).getServerName();
    }

}
