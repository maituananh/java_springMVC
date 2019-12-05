package vn.viettuts.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "Beans.xml");
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();

        HelloVietnam objB = (HelloVietnam) context.getBean("helloVietnamConstructor");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
        objB.getHelloWorld().getMessage1();
        objB.getHelloWorld().getMessage2();
    }
}
