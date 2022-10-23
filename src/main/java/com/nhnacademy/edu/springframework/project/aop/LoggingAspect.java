package com.nhnacademy.edu.springframework.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LoggingAspect {
   @Pointcut("within(com.nhnacademy.edu.springframework.project.service..*)")
   private void servicePointCut(){

   }
   @Around("servicePointCut()")
   private Object logging(ProceedingJoinPoint pjp){
      StopWatch stopWatch = new StopWatch("Logging Tracker");

      try{
         stopWatch.start();
         String s = pjp.getSignature().toString().substring(pjp.getSignature().toString().indexOf("service")+8);
         String[] splits = s.split("\\.");
         System.out.print("["+splits[0]+"].["+splits[1]+"]");

         Object retVal = pjp.proceed();
         return retVal;

      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
      finally {
         stopWatch.stop();

         System.out.println("  ["+stopWatch.getTotalTimeMillis()+"] ms");


      }

   }
}
