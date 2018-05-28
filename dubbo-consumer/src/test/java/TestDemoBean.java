import circle.TestA;
import circle.TestB;
import circle.TestC;
import demo.TestBeanFactoryAware;
import demo.TestEvent;
import demo.converter.StringToPhoneNumberConverter;
import demo.invocation.CustomInvocationHandler;
import demo.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * TestDemoBean
 *
 * @author jt_hu
 * @date 2018/5/16
 */
public class TestDemoBean {

    @Test
    public void testXmlBeanFactory() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("xml-bean-factory-test.xml"));

        DemoBean demoBean = (DemoBean) beanFactory.getBean("demo.models.DemoBean#0");

        //验证scope=singleton缓存于beanFactory->beanObjects
        DemoBean demoBean_1 = (DemoBean) beanFactory.getBean("demo.models.DemoBean#0");

        String hellStr = demoBean.sayHello("this is a string.");

        System.out.println(hellStr);
    }

    @Test
    public void springPostBeanProcessorTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml-bean-factory-test.xml");

        DemoBean demoBean = (DemoBean) applicationContext.getBean("demo.models.DemoBean#0");

        String hellStr = demoBean.sayHello("this is a string.");

        System.out.println(hellStr);
    }

    @Test
    public void circleDependencyTest() {
        try {
            BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("circle-test.xml"));

            TestA testA = (TestA) beanFactory.getBean("testA");
            TestB testB = (TestB) beanFactory.getBean("testB");
            TestC testC = (TestC) beanFactory.getBean("testC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void springCircleDependencyTest() {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circle-test.xml");

            TestA testA = (TestA) applicationContext.getBean("testA");
            TestB testB = (TestB) applicationContext.getBean("testB");
            TestC testC = (TestC) applicationContext.getBean("testC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void springBeanFactoryAwareTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-factory-aware.xml");

        TestBeanFactoryAware testBeanFactoryAware = (TestBeanFactoryAware) applicationContext.getBean("beanFactoryAware");

        testBeanFactoryAware.testAwareMethod();
    }

    @Test
    public void springCustomDateEditorTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("date-bean.xml");

        DateBean dateBean = (DateBean) applicationContext.getBean("dateBean");

        System.out.println("message:" + dateBean.getMessage() + "; date:" + dateBean.getDateValue());
    }

    @Test
    public void springBeanLifeTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-life-test.xml");

        DemoBean demoBean = (DemoBean) applicationContext.getBean("demoBean");

        System.out.println(demoBean.sayHello("ctrip"));
    }

    @Test
    public void stringFilterBeanFactoryPostProcessorTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("string-filter.xml");

        FilterStringBean filterStringBean = (FilterStringBean) applicationContext.getBean("filterStringBean");

        System.out.println(filterStringBean.toString());
    }

    @Test
    public void springLocaleMessageTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("locale-messages.xml");

        Object[] params = { "Harry", new GregorianCalendar().getTime()};

        String str1 = applicationContext.getMessage("test", params, Locale.US);
        String str2 = applicationContext.getMessage("test", params, Locale.CHINA);

        System.out.println("default locale str1: " + str1);
        System.out.println("简体中文 str2: " + str2);
    }

    @Test
    public void springApplicationListenerTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-listener-test.xml");

        TestEvent testEvent = new TestEvent("source", "this is a test event message");
        applicationContext.publishEvent(testEvent);
    }

    @Test
    public void stringToPhoneNumberConvertTest() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToPhoneNumberConverter());

        String phoneNumber = "010-12345678";
        PhoneNumberModel phoneNumberModel = conversionService.convert(phoneNumber, PhoneNumberModel.class);
        Assert.assertEquals("010", phoneNumberModel.getAreaCode());
        Assert.assertEquals("12345678", phoneNumberModel.getNumber());
    }

    @Test
    public void springConversionServiceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conversion-service-test.xml");

        User user = (User) applicationContext.getBean("user");
    }


    @Test
    public void springAopTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-test.xml");

        TestBeanInterface testBean = (TestBeanInterface) applicationContext.getBean("test");
        testBean.test();
    }

    @Test
    public void invocationHandlerTest() {
        TestBeanInterface testBean = new TestBean();

        CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(testBean);

        TestBeanInterface proxy = (TestBeanInterface) customInvocationHandler.getProxy();
        proxy.test();
    }

    @Test
    public void stringTest() {
        String strA = new String("a");

        changeStr(strA);
    }


    private void changeStr(String str) {
        str = "b";
    }

}
