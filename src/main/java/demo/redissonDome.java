package demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/7/17
 */
public class redissonDome {

    public static void main(String[] args) throws InterruptedException {

        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://10.19.162.175:7019")
                .setPassword("6Lq8Qq4Zk4")
                .setDatabase(0);

        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("test_my_r_lock");

        lock.lock();
        System.out.println( Thread.currentThread().getName());
        lock.unlock();



    }
}
