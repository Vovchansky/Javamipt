package com.company;

import java.util.Objects;

public class Person {
    protected String name;
    protected int age;
    protected int height;
    protected int weight;

    Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + name.hashCode();
        result = result * 17 + age;
        result = result * 17 + height;
        result = result * 17 + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person that = (Person) obj;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.age, that.age)
                && Objects.equals(this.weight, that.weight)
                && Objects.equals(this.height, that.height);
    }
}
