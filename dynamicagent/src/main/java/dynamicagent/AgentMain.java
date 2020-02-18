package dynamicagent;

public class AgentMain {
  public static void agentmain(String arg) {
    System.console().format("%s starting\n", arg);
    Thread agentThread = new Thread(new AgentThread(arg));
    agentThread.start();
  }
}
