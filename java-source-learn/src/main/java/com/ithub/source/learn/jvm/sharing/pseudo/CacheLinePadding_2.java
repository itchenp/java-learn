package com.ithub.source.learn.jvm.sharing.pseudo;

public class CacheLinePadding_2 {

    private static class Padding{
        public volatile long p1,p2,p3,p4,p5,p6,p7;
    }

    //从padding继承，就会发生我前面先占了56个字节，然后我会把我自己的这个存到后面，所以一个我自己就占了一行，所以另一个绝对不会在一个行里，这样效率就高了
    private static class T extends Padding{
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 10000000L; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(()->{
            for (long i = 0; i < 10000000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime()-start)/10000000);
    }
}
