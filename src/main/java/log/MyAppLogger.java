package log;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyAppLogger {

    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println("Hello Wotld");
        System.out.println("Finish");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
        System.out.println("error EN:"+log.isErrorEnabled());
        System.out.println("warn  EN:"+log.isWarnEnabled());
        System.out.println("info  EN:"+log.isInfoEnabled());
        System.out.println("debug EN:"+log.isDebugEnabled());
        System.out.println("trace EN:"+log.isTraceEnabled());
    }
}
