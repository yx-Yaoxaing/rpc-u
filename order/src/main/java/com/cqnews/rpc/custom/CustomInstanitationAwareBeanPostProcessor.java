package com.cqnews.rpc.custom;


import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.lang.reflect.Field;

public class CustomInstanitationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
