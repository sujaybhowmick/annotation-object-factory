# Annotation based Object factory

##How to use

1. Class for which you want objects to be created should implement AnnotationAware 
interface
2. Annotate the Class fields for which you need instance created by the factory 
with @TargetType("<full qualified class name string">)
3. Implement the init() method and call AnnotationObjectFactory.create(this);
4. Thats all! You will have your fields initialized with instances of class you 
specified in the @TargetType annotation
5. For example see TestController class examples in test source root