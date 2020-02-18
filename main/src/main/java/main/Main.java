package main;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    System.console().format("Main start\n");
    FooTimed.foo();
    BarLogged.bar();
    Thread.sleep(60*60*1000);
    System.console().format("Main finished\n");
  }
}
