package utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;

public class MyBeanUtils {
    /**
     * 将数据封装给JavaBean，支持时间类型转换
     * 例如：
     *  User user = new User();
     *  MyBeanUtils.populate(user,request.getParameterMap());
     * @param bean
     * @param map
     */
    public static void populate(Object bean, Map<String, String[]> map) {
        try {
            // 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
            // 1.创建时间类型的转换器
            DateConverter dt = new DateConverter();
            // 2.设置转换的格式
            dt.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            // 3.注册转换器
            ConvertUtils.register(dt, java.util.Date.class);

            // 4.封装数据
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 高级封装，不需要new JavaBean
     *  例如：
     *      User user = MyBeanUtils.populate(User.class,request.getParameterMap());
     * @param clazz
     * @param map
     * @param <T>
     * @return
     */
    public static<T> T  populate(Class<T> clazz, Map<String, String[]> map) {
        try {
            // 1.使用反射创建实例
            T obj=clazz.newInstance();

            // 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
            // 2.1 创建时间类型的转换器
            DateConverter dt = new DateConverter();
            // 2.2 设置转换的格式
            dt.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            // 2.3 注册转换器
            ConvertUtils.register(dt, java.util.Date.class);

            // 3.封装数据
            BeanUtils.populate(obj, map);

            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
