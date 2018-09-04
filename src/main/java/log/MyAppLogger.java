package log;

import org.slf4j.Logger;
//import com.jcabi.log.Logger;
import org.slf4j.LoggerFactory;

public class MyAppLogger {
    static Logger logger = LoggerFactory.getLogger(MyAppLogger.class);

    void bar(int value) {
        final long start = System.nanoTime();
        // some operations
/*
        Logger.debug(
                this,
                "one(%d): done in %[nano]d",
                value,
                System.nanoTime() - start
        );
*/
    }

    public static void main(String[] args) {
        new MyAppLogger().bar(10);

        System.out.println("Start");
        System.out.println("Hello Wotld");
        System.out.println("Finish");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        System.out.println("error EN:"+logger.isErrorEnabled());
        System.out.println("warn  EN:"+logger.isWarnEnabled());
        System.out.println("info  EN:"+logger.isInfoEnabled());
        System.out.println("debug EN:"+logger.isDebugEnabled());
        System.out.println("trace EN:"+logger.isTraceEnabled());
    }
}
