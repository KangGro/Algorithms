package com.mr.kangaroo.demonstrate.designPattern.cor;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class EmailLogger extends Logger {
    public EmailLogger(int mask) {
        this.mask = mask;
    }

    @Override
    protected void writeMessage(String msg, int priority) {
        System.out.println("Sending via email: " + msg + ",  priority:" + priority);
    }
}
