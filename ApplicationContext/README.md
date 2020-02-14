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


## Which one should I use?
Well, it depends...
In most of the cases we should go for using the ApplicationContext which has a complete offer of features for big projects.

But, by the other hand, we should go for using the BeanFactory when the memory consumption might be critical 
(for example, in mobile projects).

