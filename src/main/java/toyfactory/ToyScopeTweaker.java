package toyfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class ToyScopeTweaker implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("[BFPP] Inspecting and tweaking bean definitions...");
        BeanDefinition def;

        for (String name : beanFactory.getBeanDefinitionNames()) {
             def = beanFactory.getBeanDefinition(name);

            System.out.printf("[BFPP] Bean '%s' -> Scope: %s, Class: %s\n",
                    name,
                    def.getScope().isEmpty() ? "singleton (default)" : def.getScope(),
                    def.getBeanClassName());
            // [OPTIONAL] For Debug Purposes
            if(name.equals("prototypeToy1")){
                def.setScope("singleton");
                System.out.println("[BFPP] Changed 'prototypeToy1' to 'singleton'");
            }
        }
    }

}