# Application context

## BeanFactory VS ApplicationContext

BeanFactory (beans package) and ApplicationContext (context package) are the 2 base interfaces provided by 
Spring Framework to work with some of its basic features like dependency injection, however, these 2 interfaces have 
important differences.

In general terms, BeanFactory is the main interface and provides basic functionality to load bean definitions, wire beans
together and others.

By the other hand, ApplicationContext interface is built on top of BeanFactory and offer more advanced and automatic 
capabilities like: 
* MessageSource: to provide access to messages in i18n-style
* Access to resources such as URLs and files.
* Event propagation for beans that implement the ApplicationListener interface
* Loading of multiple (hierarchical) contexts, allowing to have a context focused on one particular layer, for example, 
the web layer of an application.


### Which one should I use?
Well, it depends...
In most of the cases we should go for using the ApplicationContext which has a complete offer of features for big projects.

But, by the other hand, we should go for using the BeanFactory when the memory consumption might be critical 
(for example, in mobile projects).

##Bean XML configuration attributes
#### init-method and destroy-method
 When we're using xml configuration for defining beans in spring, there are some useful attributes tha we can use in order
 to execute methods from the class during initialization or destruction of the bean.
 
 These methods are:
 * **init-method:** this attribute defines the method from the bean that is going to be executed after the container sets 
 the properties in the bean. Usually useful to initialize complex variables based on the existing bean properties.
 * **destroy-method:** this attribute defines the method from the bean that is going to be executed just before the bean
 is destroyed. Usually used to release resources.
 

####  The util schema
The util schema contains a series of tags that deal with some common utility configuration issues such as configuring 
collections, referencing constants and so on.

To use the util schema, we need to "import" the namespace at the top of the configuration file by adding :

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:util="http://www.springframework.org/schema/util" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd"> <!-- bean definitions here -->

</beans>
```


####  The context schema
The context schema contains some tags that help us with "tuning" or configuring some features of the Application Context.

To use the context schema, we need to "import" the namespace by adding:
``` 
 <?xml version="1.0" encoding="UTF-8"?>
 <beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="
         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"> <!-- bean definitions here -->
 
 </beans>
 ```
 
 **<property-placeholder>**
 This tag is used take properties from an external file and let them ready to use in the context file by using the ${} 
 placeholders.