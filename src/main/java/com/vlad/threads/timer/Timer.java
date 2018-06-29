package com.vlad.threads.timer;

public class Timer extends Thread {
    private String timerName;
    private int timeSec;

    public Timer(String timerName, int timeSec) {
        this.timerName = timerName;
        this.timeSec = timeSec;
    }

    public void run() {
        int timeToFinish = timeSec;

        while (timeToFinish > 0) {
            System.out.println("Timer name: " + timerName + ". Time to finish: " + timeToFinish + " sec.");
            timeToFinish -= 1;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Timer: " + timerName + " finished.");
    }
}





