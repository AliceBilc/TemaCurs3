package com.devmind.app;

import java.sql.SQLOutput;

import com.sun.source.util.SourcePositions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFirstSpringApp{

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container

        // 1. interface -> interface
        IAnimal myFirstAnimal = context.getBean("myCat", IAnimal.class);

        // 2. interface -> object
        IAnimal mySecondAnimal = context.getBean("myMouse", Mouse.class);

        // 3. object -> object
        Dog myThirdAnimal = context.getBean("myDog", Dog.class);

        // 4. object -> interface -> not okay(required Dog - provided IAnimal)
        // Dog myFourthAnimal = context.getBean("myDog", IAnimal.class);



        // call method on the bean
        System.out.println(myFirstAnimal.makeSound());

        System.out.println(mySecondAnimal.makeSound());

        System.out.println(myThirdAnimal.makeSound());

        // close the context
        context.close();
    }

}
