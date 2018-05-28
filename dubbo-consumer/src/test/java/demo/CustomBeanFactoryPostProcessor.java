package demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * demo.CustomBeanFactoryPostProcessor
 *
 * @author jt_hu
 * @date 2018/5/18
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    protected final Log logger = LogFactory.getLog(this.getClass());

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        logger.info("postProcessBeanFactory");
    }
}
