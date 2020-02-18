package dynamicagent;

class AgentThread implements Runnable {
  private final String arg;

  AgentThread(String arg) {
    this.arg = arg;
  }

  @Override
  public void run() {
    System.console().format("%s started\n", arg);
    try {
      Thread.sleep(10 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.console().format("%s finished\n", arg);
  }
}
