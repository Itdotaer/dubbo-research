package demo;

import demo.models.DemoBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * demo.DemoBeanPostProcessor
 *
 * @author jt_hu
 * @date 2018/5/17
 */
public class DemoBeanPostProcessor implements BeanPostProcessor {

    protected final Log logger = LogFactory.getLog(this.getClass());

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("postProcessBeforeInitialization->" + s);

        if (o instanceof DemoBean) {
            DemoBean bean = (DemoBean) o;
            bean.setAppendMessage(bean.getAppendMessage() + "; postProcessBeforeInitialization;");

            o = bean;
        }

        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("postProcessAfterInitialization->" + s);
        return o;
    }

}
