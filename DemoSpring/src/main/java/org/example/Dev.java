package org.example;





public class Dev {
    Laptop laptop;

//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop; // setter injection configured in spring.xml
//    }

    public Dev(Laptop laptop){
        this.laptop=laptop; // constructor injection
    }

    public void depInject(){
        laptop.compile();
        System.out.println("This is an example of Spring Project");
    }
}
