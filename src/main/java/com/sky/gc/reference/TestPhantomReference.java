package com.sky.gc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 *
 * 1.虚引用的回收机制跟弱引用差不多，但是它被回收之前，会被放入ReferenceQueue中。
 * 注意:其它引用是被JVM回收后才被传入ReferenceQueue中的。由于这个机制，所以虚引用大多被用于引用销毁前的处理工作。
 *还有就是，虚引用创建的时候，必须带有ReferenceQueue，使用例子：
 *
 * 2.可用场景：
 * 对象销毁前的一些操作，比如说资源释放等。Object.finalize()虽然也可以做这类动作，但是这个方式即不安全又低效
 */
public class TestPhantomReference {

    private static ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

    public static void main(String[] args) throws Exception {

        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());


        startMonitor();

        // 这里虽然没有在下面使用,还是要给起名,不然,回收收不到通知
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc, referenceQueue);
        abc = null;
        System.gc();
    }

    private static void startMonitor() {
        Runnable runnable = () -> {
            while (true) {
                Object obj = referenceQueue.poll();
                if (obj != null) {
                    try {
                        Field rereferent = Reference.class.getDeclaredField("referent");
                        rereferent.setAccessible(true);
                        Object result = rereferent.get(obj);
                        System.out.println("gc will collect：" + result.getClass() + "@"+ result.hashCode() + "\t"+ (String) result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
    }


}
