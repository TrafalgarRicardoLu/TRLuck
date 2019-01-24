package utils.conf;

/**
 * 提供相关配置项常亮
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-05.
 */
public interface ConfigConstant {

    String CONFIG_FILE = "redis.properties";

    String REDIS_IP = "redis.ip";
    String REDIS_PORT="redis.port";
    String REDIS_SWITCH="redis.switch";
    String JEDIS_POOL_MAX_ACTIVE = "jedis.pool.maxActive";
    String JEDIS_POOL_MAX_IDLE = "jedis.pool.maxIdle";
    String JEDIS_POOL_MAX_WAIT = "jedis.pool.maxWait";

}
