package com.yogashree.myApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // To notify the spring that I need object of this class
public class Dev {

    // @Autowired // field injection
    Laptop laptop;

    // constructor injection
    public Dev(Laptop laptop){
        this.laptop=laptop;
    }

    public void depInject(){
        laptop.compile();
        System.out.println("This is an example of Dependency Injection");
    }
}
