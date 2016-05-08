package idv.myleetcode.thread;

import java.util.*;
/**
 * Hello world!
 */
public class ConProExp{
    class Producer extends Thread{
        private List<Integer> queue;
		private int maxSize;
		public Producer(List<Integer> queue, int maxSize, String name){
			super(name);
            this.queue = queue;
            this.maxSize = maxSize;
		}
		@Override
        public void run(){
            while (true){
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            System.out .println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("Producing value : " + i); queue.add(i); queue.notifyAll();
                }
            }
        }
    }
    class Consumer extends Thread {
        private List<Integer> queue;
        private int maxSize;
        public Consumer(List<Integer> queue, int maxSize, String name){
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {//要取得queue的lock
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
                        try {
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Consuming value : " + queue.remove(0));
                    queue.notifyAll();
                }
            }
        }
	}

    public void go() throws Exception{
        System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");
		List<Integer> buffer = new LinkedList<>();
		int maxSize = 10;
		Thread producer = new Producer(buffer, maxSize, "PRODUCER");
		Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");
		producer.start();
        consumer.start();
    }
}
