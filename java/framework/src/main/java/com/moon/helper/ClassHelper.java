package com.moon.helper;

import com.moon.ClassUtil;
import com.moon.annotation.Controller;
import com.moon.annotation.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Paul on 2017/2/3.
 */
public final class ClassHelper {
    // 定义类集合（用于存放所加载的类）
    private static final Set<Class<?>> CLASS_SET;

    static{
        String basePackage="";
        CLASS_SET= ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取应用包名下的所有Service类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet(){
        return CLASS_SET.stream().filter(x->x.isAnnotationPresent(Service.class)).collect(Collectors.toSet());
    }

    /**
     * 获取应用包名下的所有Controller类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        return CLASS_SET.stream().filter(x->x.isAnnotationPresent(Controller.class)).collect(Collectors.toSet());
    }
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet=new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

}
