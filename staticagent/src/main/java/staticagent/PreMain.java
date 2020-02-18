package staticagent;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class PreMain {
  public static void premain(String arg, Instrumentation instrumentation) {
    System.console().format("Starting agent %s\n", arg);
    new AgentBuilder.Default()
        .type(ElementMatchers.nameEndsWith("Timed"))
        .transform(
            (builder, type, classLoader, module) ->
                builder
                    .method(ElementMatchers.any())
                    .intercept(MethodDelegation.to(TimingInterceptor.class)))
        .type(ElementMatchers.nameEndsWith("Logged"))
        .transform(
            (builder, type, classLoader, module) ->
                builder
                    .method(ElementMatchers.any())
                    .intercept(Advice.to(LoggingAdvice.class)))
        .installOn(instrumentation);
  }
}
