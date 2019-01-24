package utils.conf;

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

    public static int getRedisPort() {
        return PropsUtil.getInt(CONFIG_PROPS, ConfigConstant.REDIS_PORT);
    }

    public static int getMaxActive(){
        return PropsUtil.getInt(CONFIG_PROPS,ConfigConstant.JEDIS_POOL_MAX_ACTIVE);
    }

    public static int getMaxIdle(){return  PropsUtil.getInt(CONFIG_PROPS,ConfigConstant.JEDIS_POOL_MAX_IDLE);}

    public static int getMaxWait(){return  PropsUtil.getInt(CONFIG_PROPS,ConfigConstant.JEDIS_POOL_MAX_WAIT);}

    public static String getRedsiSwitch(){return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.REDIS_SWITCH);}
}
