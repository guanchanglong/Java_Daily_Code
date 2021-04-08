package com.gcl.demo1helloworld.bean;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/5 17:41
 */
public class Pet {
    private String name;

    public Pet(){
    }

    public Pet(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
