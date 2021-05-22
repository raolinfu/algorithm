package com.rao.base;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        RunT r = new RunT();
        for (int i = 0; i < 5; i++){
            new Thread(r, "RunT" + i).start();
        }

        new Thread(new TheT()).start();
    }
    static class RunT implements Runnable{
        private int num = 20;
        public synchronized void descent(){
            num--;
        }

        @Override
        public void run() {
            while (num > 0){
                descent();
                System.out.println(Thread.currentThread().getName() + ": " + num);
            }


        }
    }

    static class TheT extends Thread{
        @Override
        public void run(){
            System.out.println("I am thread");
        }
    }
}
