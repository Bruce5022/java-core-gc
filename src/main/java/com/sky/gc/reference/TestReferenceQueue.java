package com.sky.gc.reference;

import com.sky.gc.bean.User;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 如果java里面某一个对象不属于强引用,那么就需要有一个专门的机制来清除那些不具有存在价值的对象,强引用对象才有价值.
 * 这个时候如果保存有太多的无价值的对象,就会造成内存的泄露.
 * 为此专门提供一个引用队列,当某一个对象被垃圾回收后,则该对象被保存在引用队列中.
 */
public class TestReferenceQueue {
    public static void main(String[] args) throws Exception {
        User user = new User(1, "szw");
        // 引用队列
        ReferenceQueue<User> queue = new ReferenceQueue<User>();

        // 弱引用
        WeakReference<User> softReference = new WeakReference<User>(user, queue);
        // 是否进入队列
        System.out.println(softReference.isEnqueued());
        // 出队列
        System.out.println(queue.poll());
        // 将强应用去掉
        user = null;
        // 发生gc
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        // 是否进入队列
        System.out.println(softReference.isEnqueued());
        // 出队列
        System.out.println(queue.poll());

        // 是否进入队列
        System.out.println(softReference.isEnqueued());
        // 出队列
        System.out.println(queue.poll());
    }
}
