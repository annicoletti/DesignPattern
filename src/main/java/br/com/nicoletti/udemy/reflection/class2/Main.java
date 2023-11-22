package br.com.nicoletti.udemy.reflection.class2;

import br.com.nicoletti.udemy.reflection.ReflectionUtils;
import java.util.ArrayList;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        Address address = ReflectionUtils.createInstanceWithArguments(Address.class, "First Street", 10);
        Person person = ReflectionUtils.createInstanceWithArguments(Person.class, address, "Nicoletti", 35);
        System.out.println(person);

        Integer numero = ReflectionUtils.createInstanceWithArguments(Integer.class, "10");
        System.out.println("numero: " + numero);

        ArrayList array = ReflectionUtils.createInstanceWithArguments(ArrayList.class);
        array.add(1);
        array.add("A");
        array.add(Boolean.TRUE);
        System.out.println("array: " + array);

    }

    public static class Person {

        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.address = null;
            this.name = "anonymous";
            this.age = 0;
        }

        public Person(String name) {
            this.address = null;
            this.name = name;
            this.age = 0;
        }

        public Person(String name, int age) {
            this.address = null;
            this.name = name;
            this.age = age;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" + "address=" + address + ", name=" + name + ", age=" + age + '}';
        }

    }

    public static class Address {

        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" + "street=" + street + ", number=" + number + '}';
        }

    }

}
