package toyfactory;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

@Component
public class ContextSpy implements ApplicationContextAware, EnvironmentAware {

    private ApplicationContext context;
    private Environment env;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;

        System.out.println("[CTX] ApplicationContext injected into ContextSpy");
        logBeanPresence("singletonToy");
        logBeanPresence("nonExistentBean");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
        System.out.println("[CTX] Environment injected into ContextSpy");
        logActiveProfiles();
        logProperty("spring.application.name");
    }

    private void logActiveProfiles() {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length > 0) {
            System.out.print("[CTX] Active profiles: ");
            for (String profile : profiles) {
                System.out.printf("%s ", profile);
            }
            System.out.println();
            return;
        }
        System.out.println("[CTX] No active profiles.");
    }

    private void logProperty(String key) {
        String value = env.getProperty(key);
        System.out.printf("[CTX] Property '%s' = %s\n", key, value != null ? value : "(not found)");
    }

    private void logBeanPresence(String beanName) {
        boolean exists = context.containsBean(beanName);
        System.out.printf("[CTX] Bean '%s' present? %s\n", beanName, exists ? "YES" : "NO");
    }
}