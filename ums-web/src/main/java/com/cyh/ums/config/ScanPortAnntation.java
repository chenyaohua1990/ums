package com.cyh.ums.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

@Component
public class ScanPortAnntation implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        RequestMapping []annotation = bean.getClass().getAnnotationsByType(RequestMapping.class);
        if(ObjectUtils.isEmpty(annotation)){
            return bean;
        }

        RequestMapping requestMapping = annotation[0];
        //类路径
        String[] value1 = requestMapping.value();

        Method[] methods = bean.getClass().getMethods();

        if (ObjectUtils.isEmpty(methods)) {
            return bean;
        }

        for (Method method : methods) {
            RequestMapping []annotation1 = method.getAnnotationsByType(RequestMapping.class);
            GetMapping[] annotationsByType = method.getAnnotationsByType(GetMapping.class);
            if(ObjectUtils.isEmpty(annotation1)){
                continue;
            }
            String[] value = annotation1[0].value();
            RequestMethod[] method1 = annotation1[0].method();
            String sp="";
            if (!ObjectUtils.isEmpty(method1)) {
                for (RequestMethod requestMethod : method1) {
                    sp+=requestMethod.name()+",";
                }
            }else {
                sp=new StringBuffer(RequestMethod.DELETE.name()+",")
                                .append(RequestMethod.PUT.name()+",")
                                .append(RequestMethod.POST.name()+",")
                                .append(RequestMethod.HEAD.name()+",")
                                .append(RequestMethod.GET.name()+",").toString();
            }

            System.out.println("路径名："+(ObjectUtils.isEmpty(value1)?"":value1[0])+(ObjectUtils.isEmpty(value)?"":value[0])+"请求方式："+sp.replaceAll(",$",""));
        }
        return bean;
    }
}
