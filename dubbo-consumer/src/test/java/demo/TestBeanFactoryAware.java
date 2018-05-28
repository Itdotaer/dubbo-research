package demo;

import demo.models.DemoBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * demo.TestBeanFactoryAware
 *
 * @author jt_hu
 * @date 2018/5/17
 */
public class TestBeanFactoryAware implements BeanFactoryAware {

    protected final Log logger = LogFactory.getLog(this.getClass());
    private BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAwareMethod() {
        DemoBean demoBean = (DemoBean) beanFactory.getBean("demo.models.DemoBean#0");
        logger.info(demoBean.sayHello("this is a string from bean factory aware."));
    }
}
