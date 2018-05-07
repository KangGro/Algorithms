package com.mr.kangaroo.demonstrate.designPattern.cor;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class StderrLogger extends Logger {
    public StderrLogger(int mask) {
        this.mask = mask;
    }

    @Override
    protected void writeMessage(String msg, int priority) {
        System.out.println("Sending to stderr: " + msg + ",  priority:" + priority);
    }
}
