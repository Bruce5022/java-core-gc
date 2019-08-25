package com.sky.gc.reference;

/**
 * 1.弱引用就是只要JVM垃圾回收器发现了它，就会将之回收
 * 2.Java源码中的java.util.WeakHashMap中的key就是使用弱引用，我的理解就是，一旦我不需要某个引用，JVM会自动帮我处理它，这样我就不需要做其它操作。
 */
public class TestWeakReference {
}
