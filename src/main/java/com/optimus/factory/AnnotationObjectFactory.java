package com.optimus.factory;

import java.lang.reflect.Field;

/**
 * Created by sujay on 14/11/14.
 */
public class AnnotationObjectFactory {

    public static void create(TargetTypeAnnotationAware annotationAware){

        Class<?> annotatedType = annotationAware.getClass();

        Field fields[] = annotatedType.getDeclaredFields();

        for(Field field: fields){
            Class<?> fieldType = field.getType();
            TargetType targetType = field.getAnnotation(TargetType.class);
            String targetClazzValue = targetType.value();

            try {
                Class<?> targetClazz = Class.forName(targetClazzValue);
                if(fieldType.isAssignableFrom(targetClazz)){
                    field.setAccessible(true);
                    try {
                        field.set(annotationAware, targetClazz.newInstance());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(
                                String.format("Target Class %s cannot be created",
                                        targetClazz.getName()));
                    } catch (InstantiationException e) {
                        throw new RuntimeException(
                                String.format("Target Class %s cannot be created",
                                        targetClazz.getName()));
                    }
                }else {
                    throw new RuntimeException(
                     String.format("Target Class %s cannot be cast to %s",
                            targetClazzValue, targetClazz.getName()));
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(
                        String.format("Target Class %s for declared field %s not found",
                                targetClazzValue, field.getName()));
            }

        }

    }
}
