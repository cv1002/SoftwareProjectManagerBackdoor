package cn.edu.xjtu.stu.orangesoft.backdoor.core;

/**
 * 用于依赖注入的静态工具类，由于ApplicationContext是线程安全的，所以DIUtil是线程安全的
 */
public class DIUtil {
    /**
     * 单例模式：防止实例化
     */
    private DIUtil() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) ContextUtil.getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return ContextUtil.getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return ContextUtil.getApplicationContext().getBean(name, clazz);
    }
}
