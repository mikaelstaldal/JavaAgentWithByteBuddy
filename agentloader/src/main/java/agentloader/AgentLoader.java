package agentloader;

import com.sun.tools.attach.VirtualMachine;

public class AgentLoader {
  public static void main(String[] args) throws Exception {
    final String pid = args[0];
    final String agentPath = args[1];
    final String agentArg = args[2];
    System.console().format("attaching to JVM with pid=%s...\n", pid);
    VirtualMachine vm = VirtualMachine.attach(pid);
    System.console().format("...attached\n");
    try {
      System.console().format("loading agent %s with arg %s...\n", agentPath, agentArg);
      vm.loadAgent(agentPath, agentArg);
      System.console().format("...loaded\n");
    } finally {
      System.console().format("detaching...\n");
      vm.detach();
      System.console().format("...detached\n");
    }
  }
}
