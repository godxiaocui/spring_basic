package com.czh.bean;

import com.czh.ano.Bean;
import com.czh.ano.Di;
import org.springframework.beans.factory.BeanFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author godxiaocui
 * @date 2024/8/217:22
 */
public class AnnotationApplicationContext implements ApplicationContext {

    //存储bean的容器
    private HashMap<Class, Object> beanFactory = new HashMap<>();

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    private static String rootPath;

    /**
     * 创建有餐构造，传递包的路径，设置包的扫描规则
     * 当前包及其子包，那个类有@Bean注解，将这个类反射实例化
     * 根据包扫描加载bean
     *
     * @param basePackage
     */
    public AnnotationApplicationContext(String basePackage) {
        //com.czh
        //因为要扫描文件，所以要把com.czh 中的.转为/
        String packageDirName = basePackage.replaceAll("\\.", "/");

        //获取这个包的绝对路径
        try {
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                //获取包前面的路径的部分
                rootPath = filePath.substring(0, filePath.length() - packageDirName.length());
                //包扫描的过程
                System.out.println(filePath);
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            loadDi();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //
    private void loadBean(File fileParent) {
        //1.判断包是否是文件夹
        if (fileParent.isDirectory()) {
            //2.获取文件夹里的内容
            File[] childrenFiles = fileParent.listFiles();
            //3.如果文件为空返回
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            //4.文件不为空，遍历所有内容
            for (File child : childrenFiles) {
                //4.1得到的结果是文件
                if (child.isDirectory()) {
                    //递归
                    loadBean(child);
                } else {
                    //4.2 得到包路径+类的名字，字符串的提取部分
                    //通过文件路径转变成全类名,第一步把绝对路径部分去掉
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length());
                    //4，3 当前文件是class
                    if (pathWithClass.contains(".class")) {
                        //4.4 如果是.class 把路径中的\替换成. 把。class去掉
                        //    com.xinzhi.dao.UserDao
                        //去掉.class后缀，并且把 \ 替换成 .
                        String fullName = pathWithClass.replaceAll("/", ".").replace(".class", "");

                        //4.5 判断类是否有@bean ,有的话实例化
                        //4.5获取class对象
                        try {
                            Class<?> aClass = Class.forName(fullName);
                            //把非接口的类实例化放在map中
                            if (!aClass.isInterface()) {
                                //是否有注解
                                Bean annotation = aClass.getAnnotation(Bean.class);
                                if (annotation != null) {
                                    //实例化
                                    Object instance = aClass.newInstance();
                                    //4.7 实例化之后，放到map中的beanFactory
                                    //如果当前的类如果有接口，让接口的class 作为map的key
                                    //判断一下有没有接口
                                    if (aClass.getInterfaces().length > 0) {
                                        //如果有接口把接口的class当成key，实例对象当成value
                                        System.out.println("正在加载【" + aClass.getInterfaces()[0] + "】,实例对象是：" + instance.getClass().getName());
                                        beanFactory.put(aClass.getInterfaces()[0], instance);
                                    } else {
                                        //如果有接口把自己的class当成key，实例对象当成value
                                        System.out.println("正在加载【" + aClass.getName() + "】,实例对象是：" + instance.getClass().getName());
                                        beanFactory.put(aClass, instance);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

        //5.递归
    }

    // 属性注入
    private void loadDi() throws IllegalAccessException {
        //1.得到实例化的对象在beanFactory的集合中
        for (Map.Entry<Class,Object> entry : beanFactory.entrySet()){
            //2. 获取map中每个对象value,每个对象属性获取
            Object obj = entry.getValue();
            //获取class
            Class<?> aClass = obj.getClass();
            //获取所有的属性包括私有
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields){
                Di annotation = field.getAnnotation(Di.class);
                //判断是否有Di注解
                if (annotation!=null){
                    //5.对进行属性设置,私有属性进行爆破设置
                    field.setAccessible(true);
                    field.set(obj, beanFactory.get(field.getType()));
                }
            }
        }





    }

}
