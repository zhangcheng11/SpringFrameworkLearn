package com.stone.string.ioc.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class IocContainerDemo {
    public static void main(String[] args) {
        //创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        //加载资源
        final String location = "classpath:/META-INFO/dependency-injection-context.xml";
        int beanNum = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        
        System.out.println(beanNum);
    }
}
