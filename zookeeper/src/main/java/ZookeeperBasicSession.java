import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * ZookeeperBasicSession
 *
 * @author jt_hu
 * @date 2018/9/7
 */
public class ZookeeperBasicSession {

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 5000, new CustomWatcher());
        System.out.println("state: " + zookeeper.getState());


        try {
            CustomWatcher.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Zookeeper session established");

        long sessionId = zookeeper.getSessionId();
        byte[] pwd = zookeeper.getSessionPasswd();

        zookeeper = new ZooKeeper("localhost:2181", 5000, new CustomWatcher(), sessionId, pwd);

        Thread.sleep(Integer.MAX_VALUE);
    }
}

class CustomWatcher implements Watcher {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event:" + watchedEvent);

        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }
}
