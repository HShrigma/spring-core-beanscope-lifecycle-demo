# spring-core-beanscope-lifecycle-demo

A hands-on exploration of Spring Framework core concepts. This project serves as my personal learning lab for understanding:

## Features
- **Bean Management**: Manual vs. automatic configuration
- **Lifecycle Hooks**: `@PostConstruct` and `@PreDestroy`
- **Scopes**: Singleton vs. Prototype behaviors
- **Advanced Features**:
  - Profile-based beans (`@Profile`)
  - Conditional registration (`@Conditional`)
  - Bean factory post-processors
  - Application events and listeners

## What This Is
✅ A practical sandbox for Spring Core experimentation  
✅ Demonstrations of fundamental IoC container behaviors  
✅ Annotated examples with console logging for visibility  

## What This Isn't
❌ A production-ready application  
❌ A complete Spring reference implementation  
❌ Following enterprise patterns or best practices  

## How I Use This
1. Tweak bean configurations in `AppConfig` 
2. `application.properties` serves for control of environment, profiles, and Conditionals
3. Observe initialization/destruction sequences
4. Test different scope combinations
5. Experiment with event publishing
6. Watch console output to understand Spring's internals

## Key Lessons Demonstrated
- How Spring manages bean lifecycles
- The difference between configuration approaches
- When to use qualifiers vs. primary beans
- How environment profiles affect bean availability