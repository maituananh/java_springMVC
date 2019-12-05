package vn.viettuts.example;

public class HelloVietnam {
    private String message1;
    private String message2;
    private String message3;
    private HelloWorld helloWorld;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void getMessage1() {
        System.out.println("Your Message : " + message1);
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public void getMessage2() {
        System.out.println("Your Message : " + message2);
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public void getMessage3() {
        System.out.println("Your Message : " + message3);
    }

    public HelloVietnam(String message1, String message2, String message3, HelloWorld helloWorld) {
        this.message1 = message1;
        this.message2 = message2;
        this.message3 = message3;
        this.helloWorld = helloWorld;
    }

    public HelloVietnam() {
    }
}
