## TestReferenceQueue使用串行GC
```
-XX:+UseSerialGC -XX:+PrintGCDetails
```



## 程序执行结果
```
false
null
[Full GC (System.gc()) [Tenured: 0K->628K(174784K), 0.0019312 secs] 2798K->628K(253440K), [Metaspace: 3211K->3211K(1056768K)], 0.0019784 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
true
java.lang.ref.WeakReference@1b6d3586
false
null
Heap
 def new generation   total 78720K, used 2100K [0x00000006c1200000, 0x00000006c6760000, 0x0000000716150000)
  eden space 70016K,   3% used [0x00000006c1200000, 0x00000006c140d370, 0x00000006c5660000)
  from space 8704K,   0% used [0x00000006c5660000, 0x00000006c5660000, 0x00000006c5ee0000)
  to   space 8704K,   0% used [0x00000006c5ee0000, 0x00000006c5ee0000, 0x00000006c6760000)
 tenured generation   total 174784K, used 628K [0x0000000716150000, 0x0000000720c00000, 0x00000007c0000000)
   the space 174784K,   0% used [0x0000000716150000, 0x00000007161ed178, 0x00000007161ed200, 0x0000000720c00000)
 Metaspace       used 3246K, capacity 4500K, committed 4864K, reserved 1056768K
  class space    used 355K, capacity 388K, committed 512K, reserved 1048576K
```