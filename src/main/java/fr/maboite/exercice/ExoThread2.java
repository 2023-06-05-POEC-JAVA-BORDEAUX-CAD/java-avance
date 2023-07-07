package fr.maboite.exercice;

class SynchronousThread implements Runnable {
    int myvar;

    public int getMyvar() {
        return myvar;
    }

    public void setMyvar(int myvar) {
        this.myvar = myvar;
    }

    @Override
    public void run() {
        try {
            System.out.println("Attend 5s");
            Thread.sleep(5000);
            this.setMyvar(1997);
            System.out.println("Ça y es !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class BonusThread implements Runnable {
    int sleep;

    public BonusThread(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            System.out.println("Attend " + this.sleep + "s");
            Thread.sleep(this.sleep * 1000);
            System.out.println("fin de l'attente ! (" + this.sleep + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExoThread2 {
    public static void main(String[] args) {
        SynchronousThread runnable = new SynchronousThread();
        Thread thread = new Thread(runnable);
        runnable.setMyvar(7991);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(runnable.getMyvar());

        Thread thread1 = new Thread(new BonusThread((int) Math.floor((Math.random() * 10) + 1)));
        Thread thread2 = new Thread(new BonusThread((int) Math.floor((Math.random() * 10) + 1)));
        Thread thread3 = new Thread(new BonusThread((int) Math.floor((Math.random() * 10) + 1)));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
