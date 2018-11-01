package com.itdotaer.dubbo.research.bean.main;

import com.itdotaer.dubbo.research.bean.models.FromBean;
import com.itdotaer.dubbo.research.bean.models.ToBean;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * BeanCopyFromToEntrence
 *
 * @author jt_hu
 * @date 2018/10/25
 */
public class BeanCopyFromToEntrance {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // Source bean
        FromBean fromBean = new FromBean();
        fromBean.setAddress("地址测试奇偶及佛诞节覅几点睡我of京东is发送到");
        fromBean.setId(12313123L);
        fromBean.setAge(223);
        fromBean.setName("测试名称");
        fromBean.setRemark("测试标签胸襟基金囧囧囧");
        fromBean.setFloatPrice(1.0001F);
        fromBean.setPrice(new BigDecimal("1.234234234"));
        fromBean.setMinPrice(1.121D);

        int times = 10000000;
        apacheBeanCopy(fromBean, times);
        apacheBeanCopy2(fromBean, times);
        springBeanCopy(fromBean, times);
        cglibBeanCopy(fromBean, times);
    }

    public static void apacheBeanCopy(FromBean fromBean, int times) throws InvocationTargetException,
            IllegalAccessException {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            ToBean toBean = new ToBean();

            BeanUtils.copyProperties(toBean, fromBean);
        }
        long end = System.nanoTime();

        System.out.println(String.format("apacheBeanCopy(times=%s; cost=%s)", times, ((end - start)/Math.pow(10, 9))));
    }

    public static void apacheBeanCopy2(FromBean fromBean, int times) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            ToBean toBean = new ToBean();

            PropertyUtils.copyProperties(toBean, fromBean);
        }
        long end = System.nanoTime();

        System.out.println(String.format("apacheBeanCopy2(times=%s; cost=%s", times, ((end - start)/Math.pow(10, 9))));
    }
    public static void springBeanCopy(FromBean fromBean, int times) throws InvocationTargetException,
            IllegalAccessException {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            ToBean toBean = new ToBean();

            org.springframework.beans.BeanUtils.copyProperties(fromBean, toBean, "class");
        }
        long end = System.nanoTime();

        System.out.println(String.format("springBeanCopy(times=%s; cost=%s", times, ((end - start)/Math.pow(10, 9))));
    }

    public static void cglibBeanCopy(FromBean fromBean, int times) {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            ToBean toBean = new ToBean();

            BeanCopier bc = BeanCopier.create(FromBean.class, ToBean.class, false);

            bc.copy(fromBean, toBean, null);
        }
        long end = System.nanoTime();

        System.out.println(String.format("cglibBeanCopyy(times=%s; cost=%s", times, ((end - start)/Math.pow(10, 9))));
    }

}
