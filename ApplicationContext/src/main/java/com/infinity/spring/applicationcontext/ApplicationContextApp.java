package com.infinity.spring.applicationcontext;

public class ApplicationContextApp {

    public static void main(String[] args) {
        //Container Instantiation Difference example:
        ContainerInstantiationDifference containerInstantiationDifference = new ContainerInstantiationDifference();
        containerInstantiationDifference.example();

        //Util Schema example:
        UtilSchemaExample utilSchemaExample = new UtilSchemaExample();
        utilSchemaExample.example();

        //Context Schema example:
        ContextSchemaExample contextSchemaExample = new ContextSchemaExample();
        contextSchemaExample.example();
    }
}
