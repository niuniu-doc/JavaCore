package org.example.redis;


import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClusterTest {

    @Test
    public void testCluster() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(10); // 最大连接数
        poolConfig.setMaxIdle(3); // 最大空闲数
        poolConfig.setMaxWaitMillis(5); // 最大等待时间


        Set<HostAndPort> nodes = new LinkedHashSet<>();
        nodes.add(new HostAndPort("127.0.0.1", 6380));
        nodes.add(new HostAndPort("127.0.0.1", 6381));
        nodes.add(new HostAndPort("127.0.0.1", 6382));
        nodes.add(new HostAndPort("127.0.0.1", 6383));
        nodes.add(new HostAndPort("127.0.0.1", 6384));
        nodes.add(new HostAndPort("127.0.0.1", 6385));

        JedisCluster cluster = new JedisCluster(nodes, poolConfig);

        String name = cluster.get("name");
        System.out.println(name);


        System.out.println("tttttt: + " + poolConfig.toString());


        /**
         * a / x -> 6382
         * test -> 6381
         * b -> 6380
         */
        cluster.set("name", "niuniu");
        name = cluster.get("name");
        System.out.println(name);

        cluster.set("test", "test");
        System.out.println(cluster.get("test"));

        System.out.println(cluster.get("x"));
    }

    @Test
    public void testCacheManager() {
        String name = CacheManager.get("name");
        System.out.println(name);
    }
}
