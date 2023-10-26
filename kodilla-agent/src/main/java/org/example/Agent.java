package org.example;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.hasMethodName;
import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class Agent
{
  public static void premain(String args, Instrumentation instrumentation) {
    System.out.println("Kodilla agent is running.");
    System.out.println(
      "Is redefine classes allowed: " + instrumentation.isRedefineClassesSupported());
    System.out.println(
      "Is retransform classes allowed: " + instrumentation.isRetransformClassesSupported());

    AgentBuilder agentBuilder = new AgentBuilder.Default()
      .type(ElementMatchers.nameStartsWith("org.example").and(ElementMatchers.not(ElementMatchers.named("org.example.JavaAgentController"))))
      .transform(((builder, typeDescription, classLoader, module) -> {
        System.out.println("Class " + typeDescription);
        return builder.visit(Advice.to(MyMethodMonitor.class).on(ElementMatchers.any()));
      }));

//    agentBuilder.installOn(instrumentation);

    AgentBuilder agentBuilderUser = new AgentBuilder.Default()
      .type(ElementMatchers.named("org.example.JavaAgentController"))
      .transform(((builder, typeDescription, classLoader, module) -> {
        System.out.println("Class " + typeDescription);
        return builder.visit(Advice.to(UserMonitor.class).on(ElementMatchers.any()));
      }));

    agentBuilderUser.installOn(instrumentation);

  }

  public static void agentmain(String args, Instrumentation instrumentation) {
    premain(args, instrumentation);
  }
}