package com.stone.spring.context.bean;


import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Intercepter;

import java.beans.*;
import java.util.stream.Stream;

public class PersonTest {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);
        });

    }
}
