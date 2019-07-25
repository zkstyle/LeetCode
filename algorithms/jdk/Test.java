package jdk;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.jdk
 * @Author: Elvis
 * @CreateTime: 2019-05-24 14:38
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        // 1 Object
        Object object = new Object();
        // 2 String
        String s = "kkkk";

        //3 4 5 AbstractStringBuilder StringBuffer StringBuilder
        StringBuffer buffer = new StringBuffer();

        // 1 ConcurrentHashMap
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

        // 2 AtomicInteger
        AtomicInteger ac = new AtomicInteger(5);

        // AQS
        AbstractQueuedSynchronizer synchronizer;

        // 可重入锁　独占锁
        ReentrantLock reentrantLock;

        ReentrantReadWriteLock rrw;
    }


    /**
     * ABA Demo
     */
        /*static AtomicReference<String> atomicReference = new AtomicReference<>("A");
        public static void main(String[] args){
            new Thread(() -> {
                atomicReference.compareAndSet("A","B");
                atomicReference.compareAndSet("B","A");
            },"t2").start();
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicReference.compareAndSet("A","C")
                        + "\t" + atomicReference.get());
            },"t1").start();
        }*/

    /**
     * ABA Demo
     */
    /*static AtomicStampedReference<String> atomicReference = new AtomicStampedReference<>("A", 1);
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);// 睡一秒，让t1线程拿到最初的版本号
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet("A", "B", atomicReference.getStamp(), atomicReference.getStamp() + 1);
            atomicReference.compareAndSet("B", "A", atomicReference.getStamp(), atomicReference.getStamp() + 1);
        }, "t2").start();
        new Thread(() -> {
            int stamp = atomicReference.getStamp();//拿到最开始的版本号
            try {
                TimeUnit.SECONDS.sleep(3);// 睡3秒，让t2线程的ABA操作执行完
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet("A", "C", stamp, stamp + 1));
        }, "t1").start();
    }*/

}
