package org.example.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "RedisClusterProperties")
@ConfigurationProperties(prefix = "redis")
public class RedisClusterProperties {
    /**
     * 集群配置redis.cluster
     */
    private static String redisCluster;

    /**
     * 集群配置redis.prefix
     */
    private static String redisPrefix;

    /**
     * 集群配置redis.password
     */
    private static String redisPassword;
    @Value("${redis.cluster}")
    public  void setRedisCluster(String redisClusters) {
        redisCluster = redisClusters;
    }
    @Value("${redis.prefix}")
    public  void setRedisPrefix(String redisPrefixs) {
        redisPrefix = redisPrefixs;
    }
    @Value("${redis.password}")
    public  void setRedisPassword(String redisPasswords) {
        redisPassword = redisPasswords;
    }

    public static String getRedisCluster() {
        return RedisClusterProperties.redisCluster;
    }

    public static String getRedisPrefix() {
        return RedisClusterProperties.redisPrefix;
    }

    public static String getRedisPassword() {
        return RedisClusterProperties.redisPassword;
    }
}

