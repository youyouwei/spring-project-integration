package spring.project.integration.springdemoapp;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:12 2021/1/21
 */
public class Demo {

    private static AtomicInteger count = new AtomicInteger();

    private static int max = 10;

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();

        Thread consumer = new Thread(new Consumer(lock, empty, full), "consumer");
        Thread consumer1 = new Thread(new Consumer(lock, empty, full),"consumer1");
        Thread consumer2 = new Thread(new Consumer(lock, empty, full),"consumer2");
        Thread producer = new Thread(new Producer(lock, empty, full),"producer");

        producer.start();
        consumer.start();
        consumer1.start();
        consumer2.start();

    }

    static class Consumer implements Runnable {

        private ReentrantLock lock;
        private Condition empty;
        private Condition full;


        public Consumer(ReentrantLock lock, Condition empty, Condition full) {

            this.lock = lock;
            this.empty = empty;
            this.full = full;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (; ; ) {
                    if (count.get() > 0) {
                        if (count.get() >= max) {
                            count.decrementAndGet();
                            full.signal();
                        } else {
                            count.decrementAndGet();
                        }
                        System.out.println(Thread.currentThread().getName() + " consumer and get " + count.get());
                    } else {
                        System.out.println(" count is  " + count.get() + " and consumer await " + Thread.currentThread().getName());

                        empty.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class Producer implements Runnable {

        private ReentrantLock lock;
        private Condition empty;
        private Condition full;


        public Producer(ReentrantLock lock, Condition empty, Condition full) {

            this.lock = lock;
            this.empty = empty;
            this.full = full;
        }

        @Override
        public void run() {

            lock.lock();
            try {
                for (; ; ) {
                    if (count.get() >= max) {
                        System.out.println(" count is  " + count.get() + " and producer is await" + Thread.currentThread().getName());
                        full.await();
                    } else {
                        if (count.get() <= 0) {
                            count.incrementAndGet();
                            empty.signal();
                        } else {
                            count.incrementAndGet();
                        }
                        System.out.println(Thread.currentThread().getName() + "producer and get " + count.get());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }
        }
    }


}
