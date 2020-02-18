package staticagent;

import net.bytebuddy.asm.Advice;

class LoggingAdvice {
  @Advice.OnMethodEnter
  static void onEnter() {
    System.console().format("Method enter\n");
  }

  @Advice.OnMethodExit
  static void onExit() {
    System.console().format("Method exit\n");
  }
}
