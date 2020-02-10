# Spring framework
Spring is the most used java framework nowadays.

In this repo, we're going to have different projects demonstrating the usage of many features provided by spring.


## Inversion of Control (IoC) and Dependency Injection (DI)
The Spring framework is based in 2 principles:
* The inversion of control principle
* The dependency injection principle

Both of them working together build the base of Spring Framework.

## Inversion of Control
In a classic java program, the developer was in charge of instantiating each class he wanted to use by using the "new" keyword which couples the dependencies and push the developer to handle the life cycle of the objects that he needs every time.

In spring, by the other hand, exists something called "the container" which is in charge of managing all the life cycle of the beans, from creation to destruction so that the developer defines how the container is going to manage each bean and even what to do after creation and/or before destruction of each of them.


## Dependency Injection
So, having said the above, if the developer doesn't instantiates by himself the dependencies, how can he call a method from class B into class A?

Well, that is done by the Dependency Injection principle in which having the class A, you can "inject" its dependencies just by  adding the class B with an specific annotation. Something like:

```
public class A{
  @Autowired
  private B classB;
}
```
so now, you can have classB.anyMethod()...
