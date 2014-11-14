package com.optimus.factory;

import java.lang.reflect.Field;

/**
 * Created by sujay on 14/11/14.
 */
public final class AnnotationObjectFactory {

    public static void create(TargetTypeAnnotationAware targetTypeAnnotationAware){

        Class<?> annotatedType = targetTypeAnnotationAware.getClass();

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
                        field.set(targetTypeAnnotationAware,
                                                targetClazz.newInstance());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(
                                String.format("Target Class %s instance cannot be created",
                                        targetClazz.getName()), e);
                    } catch (InstantiationException e) {
                        throw new RuntimeException(
                                String.format("Target Class %s instance cannot be created",
                                        targetClazz.getName()), e);
                    }
                }else {
                    throw new RuntimeException(
                     String.format("Target Class %s cannot be cast to %s",
                            targetClazzValue, targetClazz.getName()));
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(
                        String.format("Target Class %s for declared field %s not found",
                                targetClazzValue, field.getName()), e);
            }

        }

    }
}
