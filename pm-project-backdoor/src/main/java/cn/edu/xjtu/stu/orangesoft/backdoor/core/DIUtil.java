package cn.edu.xjtu.stu.orangesoft.backdoor.core;

import org.springframework.context.ApplicationContext;

public class DIUtil {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    protected static void setApplicationContext(ApplicationContext applicationContext) {
        if (applicationContext != null) {
            DIUtil.applicationContext = applicationContext;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) getApplicationContext().getBean(name);
    }
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
