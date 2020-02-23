# Bean Scopes

In spring, when we're defining a bean, we can define how the instances of that bean are going to be created and returned 
by the Spring container.

At the moment, spring offers 5 different bean scopes:
* **Singleton**: This is the default value if no scope is defined for a bean. 
In this case, the container creates a single instance of a bean and all requests to the container for that bean are going 
to return the same instance, which is cached.   
For this scope, if the bean state is modified, that change is going to be
reflected in all references to the bean.

* **Prototype**: In this case, the container creates a new instance every time the bean is requested.  
One of the advices from spring oficial documentation is to use Prototype when working on environments with session 
management (Stateful), however there are many other scenarios where the prototype scope is applicable.

* **Request**: In this case, the container creates a different instance for each HTTP request.
* **Session**: In this case, the container creates an instance each HTTP session so the same instance will be returned 
the container receives a request from the same session.

* **Application**: The container creates an instance of the bean for each ServletContext, and due to an spring 
web application can have several servlet context, the developer will receive the same instances if the request is from 
the same ServletContext.
 
* **Websocket**: In this case, the container will create an instance of the bean for each request produced within the 
lifecycle of a WebSocket. 

from the above list, the last 4 items are only available in a web-aware application.

## Some key scenarios
##### Singleton bean with prototype property:
In case of having a dependency like the following:  
```
@Scope(SCOPE_SINGLETON)
public class A{

    @Autowired
    private B classB;
}
```
where the bean B is :
```
@Scope(SCOPE_PROTOTYPE)
public class B{
    //some attributes
}
```
so that, we have a Singleton bean which has an attribute that is a Prototype bean, then the injection happens when the 
Singleton object is instantiated so injection just happen once. Thus the injected class B will be always the same instance
even though it was defined as Prototype scope.

If we need a singleton-scoped bean that uses a new instance of a prototype-scoped bean each time, we can use _Method Injection_
instead of a simple dependency injection by property. 

##### Prototype scope beans destruction callbacks:
A very important point for beans scoped as prototype is that Spring does not manage their complete lifecycle.
The container instantiates, configures and makes it available to the client but the destruction methods are not called 
so the client must implement its own strategies to release expensive resources consumed by prototype beans (such as bean post-processors).

