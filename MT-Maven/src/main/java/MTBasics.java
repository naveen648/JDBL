public class MTBasics {
    public static void main(String[] args)
    {
        MTBasics o=new MTBasics();
//        MyThread thread=o.new MyThread();
//        MyThread thread=o.new MyThread();
//        Thread thread=new Thread(o.new MyThread());
//        thread.start();
        MyThread thread=o.new MyThread();
        try{
//            thread.setDaemon(true);
//            thread.start();
//            thread.setDaemon(true);
              thread.setDaemon(true);
              thread.start();
              Thread.sleep(5000);
              System.out.println("thread 0 is "+thread.isAlive());
              thread.interrupt();
              Thread.sleep(3000);
              System.out.println("thread 0 is "+thread.isAlive());
              //Thread.currentThread().isAlive();
        }
        catch(Exception e){
//            e.printStackTrace();
            System.out.println("Application has Stopped Forcefully");
            thread.interrupt();
        }
//        Thread.sleep(40000);
    }
    // private class MyThread implements Runnable
    private class MyThread extends Thread
    {
        //@Override
        public void run()
        {
            try {
                System.out.println("in Thread before sleep : "+Thread.currentThread().getName( ));
//                currentThread().setDaemon(true);
                Thread.sleep(6000);
                System.out.println("in Thread after sleep : "+Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("application has stopped forcefully");
            }
        }
    }
//    private class MyThread implements Runnable
//    {
//        @Override
//        public void run() {
//            System.out.println("in Thread: "+Thread.currentThread().getName());
//        }
//    }
}
