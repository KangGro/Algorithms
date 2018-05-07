package com.mr.kangaroo.demonstrate.designPattern.cor;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class StdoutLogger extends Logger {
    public StdoutLogger(int mask) {
        this.mask = mask;
    }

    @Override
    protected void writeMessage(String msg, int priority) {
        System.out.println("Writting to stdout: " + msg + ",  priority:" + priority);
    }
}
