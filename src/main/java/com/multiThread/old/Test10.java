package com.multiThread.old;

public class Test10 extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 300; i++) {
            try {
                if (this.isInterrupted()) {
                    System.out.println(" 已经是停止状态的了，will quit. ");
    //                break;
                    throw new InterruptedException();
                }
                System.out.println(" i = " + (i + 1));
                System.out.println(" 我在for下边");
            } catch (InterruptedException e) {
                System.out.println(" catch...................");
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) throws Exception{
//
//    }
}

class Run {
    public static void main(String[] args) {
        try {
            Test10 thread = new Test10();
            thread.start();
            Thread.sleep(2);
            thread.interrupt();
            System.out.println("end");
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
