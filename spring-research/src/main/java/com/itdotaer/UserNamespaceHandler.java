package com.itdotaer;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * UserNamespaceHanlder
 *
 * @author jt_hu
 * @date 2018/5/16
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
