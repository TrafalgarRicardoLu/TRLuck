package utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import utils.conf.ConfigHelper;

public class RedisPool {
    private static JedisPool pool;

    private RedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(ConfigHelper.getMaxActive());
        config.setMaxIdle(ConfigHelper.getMaxIdle());
        config.setMaxWaitMillis(ConfigHelper.getMaxWait());

        //创建连接池
        pool = new JedisPool(config, ConfigHelper.getRedisIP(), ConfigHelper.getRedisPort());
    }

    public synchronized static JedisPool getPool() {
        if (pool == null) {
            new RedisPool();
        }
        return pool;
    }
}

