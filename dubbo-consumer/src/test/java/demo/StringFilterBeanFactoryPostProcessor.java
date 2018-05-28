package demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * StringFilterBeanFactoryPostProcessor
 *
 * @author jt_hu
 * @date 2018/5/18
 */
public class StringFilterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final String SECURITY_STRING = "****";
    private Set<String> filterStrings;

    public StringFilterBeanFactoryPostProcessor() {
        filterStrings = new HashSet<String>();
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition(beanName);

            StringValueResolver valueResolver = new StringValueResolver() {
                public String resolveStringValue(String s) {
                    if (isObscene(s)) {
                        return SECURITY_STRING;
                    }

                    return s;
                }
            };

            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }
    }

    private boolean isObscene(Object value) {
        String potentialString = String.valueOf(value).toUpperCase();
        return this.filterStrings.contains(potentialString);
    }

    public void setFilterStrings(Set<String> filterStrings) {
        this.filterStrings.clear();

        for (String string : filterStrings) {
            this.filterStrings.add(string.toUpperCase());
        }
    }
}
