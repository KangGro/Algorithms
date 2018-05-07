package com.mr.kangaroo.demonstrate.designPattern.cor;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class ChainOfResponsibilityExample {
    public static void main( String[] args )
    {
        // Build the chain of responsibility
        Logger l = new StdoutLogger( Logger.DEBUG).setNext(
                new EmailLogger( Logger.NOTICE ).setNext(
                        new StderrLogger( Logger.ERR ) ) );

        // Handled by all three loggers
        l.message( "An error has occurred.", Logger.ERR );
        // Handled by StdoutLogger
        l.message( "Entering function y.", Logger.DEBUG );

        // Handled by StdoutLogger and EmailLogger
        l.message( "Step1 completed.", Logger.NOTICE );

    }
}
