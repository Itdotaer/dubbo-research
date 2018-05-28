package demo.models;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * demo.models.DemoBean
 *
 * @author jt_hu
 * @date 2018/5/16
 */
public class DemoBean implements InitializingBean {

    protected final Log logger = LogFactory.getLog(this.getClass());

    private String appendMessage = "";

    public DemoBean(String appendMessage) {
        logger.info("into constructor method: " + appendMessage);
        this.appendMessage = appendMessage;
    }

    public String sayHello(String hello) {
        return this.appendMessage + hello;
    }

    public String getAppendMessage() {
        return appendMessage;
    }

    public void setAppendMessage(String appendMessage) {
        this.appendMessage = appendMessage;
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet");

        setAppendMessage(this.appendMessage + ";  afterPropertiesSet; ");
    }

    public void init() {
        logger.info("custom init method");

        setAppendMessage(this.appendMessage + "; init; ");
    }
}
