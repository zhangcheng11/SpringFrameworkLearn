package com.stone.string.ioc.dependency.injection;

import com.stone.string.ioc.annotation.Super;
import com.stone.string.ioc.domain.User;
import com.stone.string.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        //System.out.println(userRepository.getBeanFactory());

        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject() == beanFactory);

        //lookupInRealTime(beanFactory);
        //lookupInLazy(beanFactory);

        //lookupInType(beanFactory);
        
        //lookupInCollect(beanFactory);

        //lookupInAnnotation(beanFactory);

    }

    private static void lookupInAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);

            System.out.println("查找注解user:"+ beansWithAnnotation);
        }
    }

    private static void lookupInCollect(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到集合中所有的users:"+beans);
        }
    }

    private static void lookupInType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找："+user.toString());

    }


    private static void lookupInRealTime(BeanFactory beanFactory){
        User bean = (User) beanFactory.getBean("user");
        System.out.println("实时查找："+bean.toString());
    }

    private static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找："+ user.toString());
    }

    
}
