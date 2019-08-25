package com.sky.gc.reference;

/**
 *
 * 本地方法栈中JNI引用的对象也可以作为GC roots
 *
 */

public class TestJNIReference {

    public native static void sort(int[] arr);

    public static void test(int[] arr){
        sort(arr);
    }

    public static void main(String[] args) {
        int[] arr =new int[]{1,2,3};
        test(arr);
    }
}
