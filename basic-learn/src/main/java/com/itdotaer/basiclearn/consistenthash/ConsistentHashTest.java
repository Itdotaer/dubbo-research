package com.itdotaer.basiclearn.consistenthash;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ConsistantHashTest
 *
 * @author jt_hu
 * @date 2019-01-16
 */
public class ConsistentHashTest {

    @Test
    public void NormHashTest() {
        // arrange
        Map<String, Integer> total = new LinkedHashMap<>();

        int serverCount = 8;
        String serverNamePreFix = "server-%s";

        int clientCount = 100;
        String clientNamePreFix = "client-%s";

        // act
        for (int i = 0; i < serverCount; i++) {
            String serverName = String.format(serverNamePreFix, i);
            try {
                NormHash.addServer(serverName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < clientCount; i++) {
            String clientName = String.format(clientNamePreFix, i);

            String serverName = NormHash.getServer(clientName);

            System.out.println(String.format("%s found a server name: %s", clientName, serverName));

            if (total.containsKey(serverName)) {
                total.put(serverName, total.get(serverName)+1);
            } else {
                total.put(serverName, 1);
            }
        }

        // assert
        total.forEach((key, value) -> System.out.println(String.format("%s:%s", key, value)));
    }

    @Test
    public void BetterHashTest() {
        // arrange
        Map<String, Integer> total = new LinkedHashMap<>();

        int serverCount = 100;
        String serverNamePreFix = "server-%s";

        int clientCount = 100;
        String clientNamePreFix = "client-%s";

        // act
        for (int i = 0; i < serverCount; i++) {
            String serverName = String.format(serverNamePreFix, i);
            try {
                BetterHash.addServer(serverName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < clientCount; i++) {
            String clientName = String.format(clientNamePreFix, i);

            String serverName = BetterHash.getServer(clientName);

            System.out.println(String.format("%s found a server name: %s", clientName, serverName));

            if (total.containsKey(serverName)) {
                total.put(serverName, total.get(serverName)+1);
            } else {
                total.put(serverName, 1);
            }
        }

        // assert
        total.forEach((key, value) -> System.out.println(String.format("%s:%s", key, value)));
    }

}
