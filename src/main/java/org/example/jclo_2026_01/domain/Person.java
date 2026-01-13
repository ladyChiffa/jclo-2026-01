package org.example.jclo_2026_01.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Person {
    @NotBlank
    @Size(min = 0, max = 20)
    private String name;
    @Min(0)
    @Max(150)
    private int age;

    // методы для работы Jackson, который дефолтный для сериализации
    // - конструктор без параметров
    // - геттеры и сеттеры для всех свойств
    // это все можно не генерить в IDE, а указать специальные аннотации
    public Person(){
    }

    public Person(String name, int age) { // заодно добавим конструктор со всеми аргументами
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
