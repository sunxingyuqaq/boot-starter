package com.boot.study.job.model;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/9 16:04
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class Person {

    private String name = "person";

    public void print(){
        System.out.println(name);
    }

    static class Sub extends Person{
        private String name = "sub";

        @Override
        public void print(){
            System.out.println(this.name);
        }
    }

    public static void main(String[] args) {
        Person person = new Sub();
        person.print();
    }

}
