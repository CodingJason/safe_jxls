package com.jason.jxls;


import org.apache.commons.beanutils.PropertyUtils;
import org.jxls.reader.BeanCellMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MyBeanCellMapping extends BeanCellMapping {
    public MyBeanCellMapping(int rowNum, short cellNum, String beanKey, String propertyName) {
        super(rowNum, cellNum, beanKey, propertyName);
    }


    @Override
    public Class getPropertyType(Map beans) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Object bean;
        if (beans.containsKey(getBeanKey())) {
            bean = beans.get(getBeanKey());
            // ZJ
            if (getType() == null) {
                // 如果使用 Map 这里的 clazz 可能为 null 所以需要判断
                Class clazz = PropertyUtils.getPropertyType(bean, getPropertyName());
                return clazz == null?String.class:clazz;
            } else {
                return Class.forName(getType());
            }
        }
        return Object.class;
    }
}
