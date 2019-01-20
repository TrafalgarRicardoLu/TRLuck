package utils;

import java.util.Properties;

/**
 * 属性文件助手类
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-05.
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getRedisIP() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.REDIS_IP);
    }

    public static String getRedisPort() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.REDIS_PORT);
    }

    public static String getMaxActive(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JEDIS_POOL_MAX_ACTIVE);
    }

    public static String getMaxIdle(){return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JEDIS_POOL_MAX_IDLE);}

    public static String getMaxWait(){return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JEDIS_POOL_MAX_WAIT);}

    public static String getRedsiSwitch(){return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.REDIS_SWITCH);}
}
