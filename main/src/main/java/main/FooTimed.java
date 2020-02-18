package main;

class FooTimed {
  static void foo() throws InterruptedException {
    System.console().format("Foo\n");
    Thread.sleep(2*1000);
    System.console().format("ooF\n");
  }
}
