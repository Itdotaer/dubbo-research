package com.itdotaer.basiclearn.consistenthash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.CRC32;

/**
 * BetterHash
 *
 * @author jt_hu
 * @date 2019-01-16
 */
public class BetterHash {

    private static List<Server> serverList = new ArrayList<>();

    public static void addServer(String serverName) {
        Long hash = getHash(serverName);
        serverList.add(new Server(serverName, hash));

        Collections.sort(serverList, (o1, o2) -> {
            if (o1.getHash() < o2.getHash()) {
                return 1;
            }

            return -1;
        });
    }

    public static void deleteServer(String serverName) {
        if (!serverList.isEmpty()) {
            long hash = getHash(serverName);
            serverList = serverList.stream().filter(t -> t.getHash().equals(hash))
                    .collect(Collectors.toList());
        }
    }

    public static long getHash(String serverName) {
        CRC32 crc32 = new CRC32();
        crc32.update(serverName.getBytes());

        return crc32.getValue();
    }

    public static String getServer(String key) {
        long hash = getHash(key);

        Optional<Server> found = serverList.stream().filter(t -> t.getHash() >= hash).findFirst();

        if (found.isPresent()) {
            return found.get().getServerName();
        }

        return serverList.isEmpty() ? "" : serverList.get(0).getServerName();
    }
}
