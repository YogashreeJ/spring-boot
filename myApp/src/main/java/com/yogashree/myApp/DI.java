package com.yogashree.myApp;


import org.springframework.stereotype.Component;

@Component  // To notify the spring that I need object of this class
public class DI {
    public void depInject(){
        System.out.println("This is an example of Dependency Injection");
    }
}
