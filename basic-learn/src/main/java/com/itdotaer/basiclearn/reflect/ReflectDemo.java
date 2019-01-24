package com.itdotaer.basiclearn.reflect;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ReflectDemo
 *
 * @author jt_hu
 * @date 2019-01-23
 */
public class ReflectDemo {

    @Test
    public void constructTest() throws ClassNotFoundException {
        Class<?> serverClass = ClassLoader.getSystemClassLoader().loadClass(Student.class.getName());

        Constructor[] constructors = serverClass.getDeclaredConstructors();

        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];

            Class<?>[] params = constructor.getParameterTypes();

            for (int j = 0; j < params.length; j++) {
                System.out.print(constructor.getName() + ":" + params[j] + "\n");
            }
        }

        // 公共的、私有的变量（不包含继承字段)
        Field[] fields = serverClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            System.out.println("field: " + field.getName());
        }

        // 公共的变量（包含继承字段)
        Field[] fields1 = serverClass.getFields();
        for (int i = 0; i < fields1.length; i++) {
            Field field = fields1[i];

            System.out.println("field1: " + field.getName());
        }

        Method[] methods = serverClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            System.out.println("method: " + method.getName());
        }

        Method[] methods1 = serverClass.getMethods();
        for (int i = 0; i < methods1.length; i++) {
            Method method = methods1[i];

            System.out.println("method1: " + method.getName());
        }

        int[] array = {1, 2, 3, 4};
        Class<?> arrClass = array.getClass().getComponentType();

        Object arrayRef = Array.newInstance(arrClass, array.length);

        System.arraycopy(array, 0, arrayRef, 0, array.length);
    }

}
