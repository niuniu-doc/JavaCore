package org.example.redis;

import com.letv.cache.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CacheManager {
    private static Logger logger = LoggerFactory.getLogger(CacheManager.class);
    @Autowired
    RedisClusterProperties redisClusterProperties;

    private static final RedisClient REDIS_CLIENT = new RedisClient(RedisClusterProperties.getRedisCluster(), RedisClusterProperties.getRedisPrefix(),
            RedisClusterProperties.getRedisPassword());

    private CacheManager() {
    }

    public static String set(String key, Object value) {
        return REDIS_CLIENT.set(key, value);
    }

    public static String set(final String key, final int expTime, final Object value) {
        try {
            return REDIS_CLIENT.set(key, expTime, value);
        } catch (Exception e) {
            logger.error("set Object value cache error", e);
        }

        return null;
    }

    public static <T> T get(String key, Class<T> classType) {
        try {
            return REDIS_CLIENT.get(key, classType);
        } catch (Exception e) {
            logger.error("get object cache error", e);
        }

        return null;
    }

    public static String get(final String key) {
        try {
            return REDIS_CLIENT.get(key);
        } catch (Exception e) {
            logger.error("get list cache error", e);
        }

        return null;
    }
}
