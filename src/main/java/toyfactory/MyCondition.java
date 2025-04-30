package toyfactory;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String propertyValidator = context.getEnvironment().getProperty("toy.condition.enabled");
        return "true".equalsIgnoreCase(propertyValidator);
    }
}