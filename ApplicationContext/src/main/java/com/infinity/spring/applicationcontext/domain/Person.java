package com.infinity.spring.applicationcontext.domain;

public class Person {

    private String name;
    private int age;
    private Gender gender;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void postConstruct(){
        System.out.println("postConstruct method executed for " + name + " bean");
    }

    public void onDestroy(){
        System.out.println("Releasing resources consumed by " + name + " bean");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
