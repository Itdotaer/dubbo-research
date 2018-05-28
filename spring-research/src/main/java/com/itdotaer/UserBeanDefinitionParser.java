package com.itdotaer;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * UserBeanDefinitionParser
 *
 * @author jt_hu
 * @date 2018/5/16
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private static final String USER_NAME = "userName";
    private static final String EMAIL = "email";

    @Override
    protected Class getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute(USER_NAME);
        String email = element.getAttribute(EMAIL);

        if (StringUtils.hasText(userName)) {
            builder.addPropertyValue(USER_NAME, userName);
        }

        if (StringUtils.hasText(email)) {
            builder.addPropertyValue(EMAIL, email);
        }
    }
}
