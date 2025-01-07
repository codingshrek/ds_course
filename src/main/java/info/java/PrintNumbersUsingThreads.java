package info.java;

public class PrintNumbersUsingThreads {


    static int i = 0;

    public synchronized void printEven(int[] arr) {
        while (i < arr.length) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : "+arr[i]);
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void printOdd(int[] arr) {

        while (i < arr.length) {


            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " : " +arr[i]);
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        PrintNumbersUsingThreads obj = new PrintNumbersUsingThreads();
        final int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEven(a);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printOdd(a);
            }
        });

        t1.start();
        t2.start();
    }

}
