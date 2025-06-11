package base;

public class TestingThread implements Runnable{

    @Override
    public void run() {
        System.out.println("This is run method in thread");
    }

    public static void main(String[] args){
        TestingThread testingThread= new TestingThread();
        Thread r1 = new Thread(testingThread);
        Thread r2 = new Thread(testingThread);
        r1.start();
        r2.start();
    }
}

