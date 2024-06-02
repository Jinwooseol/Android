package com.example.ch9_cloneable;

import com.example.ch9_cloneable.Address;

public class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;

    // Constructor
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    // Getter
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() {
        return address;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address + '}';
    }
}

