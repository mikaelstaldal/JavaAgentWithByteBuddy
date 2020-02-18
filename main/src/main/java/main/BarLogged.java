package main;

class BarLogged {
  static void bar() throws InterruptedException {
    System.console().format("Bar\n");
    Thread.sleep(1000);
    System.console().format("raB\n");
  }
}
