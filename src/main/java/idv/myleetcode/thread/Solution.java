package idv.myleetcode.thread;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    public static class MyRunner implements Runnable{
        private ThreadLocal<Double> localInt = new ThreadLocal<Double>();
        private double noProtect = 0.0;

        @Override
        public void run(){
            double d = Math.random();
            System.out.println(d);
            noProtect = d;
            localInt.set(d);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                //nothing here now
            }
            System.out.println(localInt.get());
            System.out.println(noProtect);
        }
    }

    public static void go() throws Exception{
        MyRunner m1 = new MyRunner();
        Thread thread1 = new Thread(m1);
        Thread thread2 = new Thread(m1);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
