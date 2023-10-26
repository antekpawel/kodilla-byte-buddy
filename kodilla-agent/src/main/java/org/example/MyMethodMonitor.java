package org.example;

import net.bytebuddy.asm.Advice;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class MyMethodMonitor
{
  @Advice.OnMethodEnter
  public static void enter(@Advice.Origin Class clazz, @Advice.Origin("#m") String methodName) {
    System.out.println("Entering method: " + methodName);
  }

  @Advice.OnMethodExit
  public static void exit() {
    System.out.println("Exiting method.");
  }
}
