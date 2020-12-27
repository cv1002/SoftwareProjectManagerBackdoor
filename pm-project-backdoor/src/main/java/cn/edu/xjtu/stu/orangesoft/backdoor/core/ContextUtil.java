package cn.edu.xjtu.stu.orangesoft.backdoor.core;

import org.springframework.context.ApplicationContext;

/**
 * 用于获取ApplicationContext的工具类，采用了单例模式，由于ApplicationContext是线程安全的，所以ContextUtil是线程安全的
 */
public class ContextUtil {
    private static ApplicationContext applicationContext;

    /**
     * 单例模式：防止实例化
     */
    private ContextUtil() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    protected static void setApplicationContext(ApplicationContext applicationContext) {
        if (ContextUtil.applicationContext == null) {
            ContextUtil.applicationContext = applicationContext;
        }
    }
}
