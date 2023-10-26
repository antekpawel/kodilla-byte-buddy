package org.example;

import net.bytebuddy.asm.Advice;

/**
 * User: Z6PWA
 * Date: 26.10.2023
 */
public class UserMonitor
{
  @Advice.OnMethodEnter
  public static void enter(@Advice.Origin Class clazz, @Advice.Origin("#m") String methodName) {
    System.out.println("Start doSomething");
  }

  @Advice.OnMethodExit
  public static void exit() {
    System.out.println("Done doSomething");
  }
}
