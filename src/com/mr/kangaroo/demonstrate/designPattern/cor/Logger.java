package com.mr.kangaroo.demonstrate.designPattern.cor;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public abstract class Logger {
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;
    protected int mask;

    // The next element in the chain of responsibility
    protected Logger next;

    public Logger setNext(Logger l) {
        next = l;
        return this;
    }

    public final void message(String msg, int priority) {
        if (priority <= mask) {
            writeMessage(msg, priority);
            if (next != null) {
                next.message(msg, priority);
            }
        }
    }

    protected abstract void writeMessage(String msg, int priority);
}
