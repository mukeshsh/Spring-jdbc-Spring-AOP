package com.nt.aspect;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class TestDriveAdvice {
     public void testDriving(JoinPoint jp)throws Throwable{
    	 System.out.println(jp.getSignature()+" "+Arrays.deepToString(jp.getArgs()));
    	 Object args[]=null;
    	 Writer writer=null;
    	 args=jp.getArgs();
    	 try {
    		 writer=new FileWriter("E:/auditlog.txt",true);
    		 writer.write(args[0]+" "+args[1]+" "+args[2]+" "+args[3]+new Date());
    		 writer.flush();
    		 writer.close();
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
}
